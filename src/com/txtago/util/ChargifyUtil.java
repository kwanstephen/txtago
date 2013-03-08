package com.txtago.util;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;
import org.apache.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Formatter;
import java.util.Map;

/**
 * This code was found on the chargify support site. I made slight modifications
 *
 * @author Bob Hopwood
 * @author Revision $Author: bobh $
 * @version $Revision: 1.2 $ $Date: 2012/01/03 22:59:55 $
 */

public class ChargifyUtil {
		
	private static final Logger logger = Logger.getLogger(ChargifyUtil.class);
	private static final String CHARGIFY_API_KEY = "chargify-api-key";
	private static final String CHARGIFY_SITE_SHARED_KEY = "chargify-site-shared-key";
	private static final String CHARGIFY_SITE = "chargify-site";

	private String chargifySite = "";
	private ApacheHttpClient apacheHttpClient = null;
	private String chargifySiteSharedKey;
	
	public ChargifyUtil()
	{
		super();
	}
	
	public void init(String site, String apiKey, String siteSharedKey) {
		DefaultApacheHttpClientConfig config = new DefaultApacheHttpClientConfig();
		config.getState().setCredentials(null, null, -1, apiKey, "x");
		
		if(TxtagoProperties.getInstance().getProperty("use.http.proxy").equals("Y"))
			config.getProperties().put(DefaultApacheHttpClientConfig.PROPERTY_PROXY_URI, "http://10.172.240.113:8080");
		
		this.apacheHttpClient = ApacheHttpClient.create(config);
		this.chargifySite = site;
		this.chargifySiteSharedKey = siteSharedKey;
	}

	public ApacheHttpClient getApacheHttpClient() {
		return apacheHttpClient;
	}

	public void setApacheHttpClient(ApacheHttpClient apacheHttpClient) {
		this.apacheHttpClient = apacheHttpClient;
	}

	public String getChargifySiteUrl() {
		return this.chargifySite;
	}

	public String getSiteSharedKey() {
		return chargifySiteSharedKey;
	}
	
	
	public String getChargifyCustomerSubscriptions( String ChargifyCustomerId ) throws UniformInterfaceException, JAXBException {
		if( null == apacheHttpClient ) throw new IllegalStateException("ApacheHttpClient not configured");

		// List By ChargifyCustomer
		// URL: https://<subdomain>.chargify.com/ChargifyCustomers/<ChargifyCustomer_id>/subscriptions.<format>
		// Method: GET
		// Required Parameters, ChargifyCustomer_id
		// Response: An array of Subscriptions

		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "ChargifyCustomers/" + ChargifyCustomerId + "/subscriptions.xml");
		URI uri = uriBuilder.build();

		logger.debug(uri);

		WebResource service = apacheHttpClient.resource(uri);

		// There is a problem when no subscriptions exist.  Instead of an empty subscriptions element, we get a <nil-classes> element

		String xml = service.accept(MediaType.TEXT_XML).get(String.class);
		

		return xml;
	}

	public ChargifySubscription getSubscription(String subscriptionId) throws UniformInterfaceException {
		if( null == apacheHttpClient ) throw new IllegalStateException("ApacheHttpClient not configured");

		// URL: https://<subdomain>.chargify.com/subscriptions/<subscription_id>.<format>
		// Method: GET
		// Required Parameters: subscription_id
		// Response: An single Subscription

		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "subscriptions/"+subscriptionId+".xml");
		URI uri = uriBuilder.build();

		logger.debug("getSubscription GET " + uri);

		WebResource service = apacheHttpClient.resource(uri);

		return service.accept(MediaType.TEXT_XML).get(ChargifySubscription.class);
	}

	
	public ChargifySubscription createSubscription(ChargifySubscription subscription) {

		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "subscriptions.xml");
		URI uri = uriBuilder.build();

		logger.debug("createSubscription POST " + uri);

		WebResource service = apacheHttpClient.resource(uri);
		logger.debug(subscription);

		return service.accept(MediaType.TEXT_XML).post(ChargifySubscription.class, subscription);

	}

	public ChargifyCustomer getCustomer(String chargifyId) {
		// URL: https://<subdomain>.chargify.com/ChargifyCustomers/<id>.<format>
		// Method:
		// GET
		// Required Parameters: id
		// Response: An single ChargifyCustomer

		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "customers/"+chargifyId+".xml");
		URI uri = uriBuilder.build();

		logger.debug(uri);

		WebResource service = apacheHttpClient.resource(uri);

		return service.accept(MediaType.TEXT_XML).get(ChargifyCustomer.class);
	}

	public ChargifyCustomer getCustomerByReference(String ChargifyCustomerCode) {
		//	Chargify https://<subdomain>.chargify.com/ChargifyCustomers/lookup.<format>?reference=<reference>
		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "customers/lookup.xml");
		uriBuilder.queryParam("reference", ChargifyCustomerCode);
		URI uri = uriBuilder.build();

		logger.debug(uri);

		WebResource service = apacheHttpClient.resource(uri);

		return service.accept(MediaType.TEXT_XML).get(ChargifyCustomer.class);
	}

	public ChargifyCustomer updateCustomer(ChargifyCustomer ChargifyCustomer) {
		// URL: https://<subdomain>.chargify.com/customers/<id>.<format>
		// Method: PUT
		// Required Parameters: XML or JSON data, as specified by the required attributes
		// Response: The updated ChargifyCustomer
		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "customers/"+ChargifyCustomer.getId()+".xml");
		URI uri = uriBuilder.build();

		logger.debug(uri);

		WebResource service = apacheHttpClient.resource(uri);

		return service.accept(MediaType.TEXT_XML).put(ChargifyCustomer.class, ChargifyCustomer);
	}

	/**
	 * Create a new ChargifyCustomer in Chargify
	 *
	 * @param chargifyChargifyCustomer the ChargifyCustomer to create. Should have org, name, email, reference
	 * @return The created ChargifyCustomer
	 * @throws UniformInterfaceException
	 */
	public ChargifyCustomer createCustomer(ChargifyCustomer chargifyChargifyCustomer) throws UniformInterfaceException {
		/*
		 * URL: https://<subdomain>.chargify.com/ChargifyCustomers.<format>
		 * Method: POST
		 * Required Parameters: XML or JSON data, as specified by the required attributes
		 * Response: The created ChargifyCustomer
		 */
		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "customers.xml");
		URI uri = uriBuilder.build();

		logger.debug(uri);

		WebResource service = apacheHttpClient.resource(uri);
		logger.debug(chargifyChargifyCustomer);

		return service.accept(MediaType.TEXT_XML).post(ChargifyCustomer.class, chargifyChargifyCustomer);
	}

	/**
	 * Delete/Cancel
	 *
	 * The delete action causes the cancellation of a subscription, i.e. it sets the subscription state to canceled.
	 *
	 *      URL: https://<subdomain>.chargify.com/subscriptions/<subscription_id>.<format>
     *      Method: DELETE
     *      Required Parameters: None
     *      Optional Parameters: XML or JSON data with a cancellation_message note that will be stored with the subscription.
     *      Response: 200 OK on success @param chargifyId
	 *
	 * @param cancellationMessage
	 */
	public void cancelSubscriptionNow(String chargifyId, String cancellationMessage) {
		if( chargifyId == null || "".equals(chargifyId) )
			throw new IllegalArgumentException("ChargifyId cannot be blank");

		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "subscriptions/"+chargifyId+".xml");
		URI uri = uriBuilder.build();

		logger.debug("cancelSubscriptionNow DELETE " + uri);

		WebResource service = apacheHttpClient.resource(uri);
		
		service.accept(MediaType.TEXT_XML).delete();
	}

	
	/**
	 *
	 * Generating Tokens<br/>
	 * <br/>
	 * URLs are constructed, and later verified, via a secret token. This token is the first 10 characters of
	 * the SHA-1 hex digest of a specially constructed message. In pseudo-code: <br/>
	 *      <code> token = SHA1(message)[0..9]</code><br/>
	 * The message is a concatenation of the page ÒshortnameÓ, the resourceÕs ID, and the SiteÕs Shared Key. The
	 * message parts are joined using double dashes (Ñ). Consider the Update Payment page for a subscription
	 * with ID Ô77Õ and a Shared Key of Ô1234Õ: <br/>
	 * <code>message = "update_payment--77--1234"</code> <br/>
	 * Putting it all together: <br/>
	 * <code> token = SHA1("update_payment--77--1234")[0..9] # => b59a09cc72 </code> <br/>
	 * <br/>
	 * Generating URLs <br/>
	 * <br/>
	 * URLs follow the pattern: <code>https://[subdomain].chargify.com/[shortname]/[id]/[token] </code>
	 * So, a full URL for the Update Payment page on the `acme` subdomain, using the values from the
	 * earlier example, would be: <code>https://acme.chargify.com/update_payment/77/b59a09cc72 </code><br/>
	 * <br/>
	 * Resource IDs <br/>
	 * <br/>
	 * The required value for [id] in the URL is available via the `id` parameter in a response from our API.
	 * This ID is a unique value assigned to resources by Chargify. Token Length You may pass a token that
	 * is longer than 10 characters; however, we only verify that the first 10 characters of your token
	 * match the expected token. Pretty IDs You may pass more information in the [id] parameter, as long as
	 * that information is proceeded by a dash (-). For example, the following two URLs access the same
	 * payment update page:
	 *      <ul>
	 *      <li> https://acme.chargify.com/update_payment/77/b59a09cc72 </li>
	 *      <li> https://acme.chargify.com/update_payment/77-john-doe/b59a09cc72 </li>
	 *      </ul>
	 *
	 * In this example, weÕre adding the ChargifyCustomers name to the subscription ID, making it more ÒpersonalÓ.
	 * Just make sure that anything you add to the URL is in fact composed of URL-safe characters.
	 * <br/>
	 * URL Validity<br/>
	 * <br/>
	 * A Ò404 Not FoundÓ response will be returned if the URL is not valid. Invalid URLs can result from
	 * either of the following:
	 *      <ul>
	 *          <li> The resource ID does not identify a valid resource for the given Site     </li>
	 *          <li> The token does not match the expected token for the page shortname and ID </li>
	 *      </ul>
	 *
	 * @param chargifySubscriptionId the chargify id of the subscription as a string
	 * @return URI that can be used for updating the cc info for a given subscription
	 */
	public String buildUpdatePaymentURI( String chargifySubscriptionId ) {
		try {
			/*
			A MessageDigest object starts out initialized. The data is processed through it using the update
			methods. At any point reset can be called to reset the digest. Once all the data to be updated
			has been updated, one of the digest methods should be called to complete the hash computation.

			The digest method can be called once for a given number of updates. After digest has been called,
			the MessageDigest object is reset to its initialized state.
			*/
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

			/**
			 * The message is a concatenation of the page ÒshortnameÓ, the resourceÕs ID, and the SiteÕs Shared Key. The
			 * message parts are joined using double dashes (Ñ). Consider the Update Payment page for a subscription
			 * with ID Ô77Õ and a Shared Key of Ô1234Õ:
			 * message = "update_payment--77--1234"
			 */
			String message = "update_payment--"+chargifySubscriptionId+"--"+chargifySiteSharedKey;
//			String message = "update_payment--77--1234";
			messageDigest.update(message.getBytes());
			byte [] hash = messageDigest.digest();

			Formatter formatter = new Formatter();
            for (byte b : hash) {
                formatter.format("%02x", b);
            }

			String token = formatter.toString().substring(0,10);

			// URLs follow the pattern: <code>https://[subdomain].chargify.com/[shortname]/[id]/[token]
			UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "update_payment/"+chargifySubscriptionId+'/'+token);
			URI uri = uriBuilder.build();

			logger.debug("https://[subdomain].chargify.com/[shortname]/[id]/[token] = " + uri);

			return uri.toString();

		}
		catch (NoSuchAlgorithmException e) {
			logger.fatal(e.getClass().getSimpleName() + ": " + e.getMessage(), e);
		}

		return null;
	}


	public static ChargifyUtil createInstance() {


		String apiKey    = TxtagoProperties.getInstance().getProperty("chargify.api.key");
		String sharedKey = TxtagoProperties.getInstance().getProperty("chargify.shared.key");
		String site      = TxtagoProperties.getInstance().getProperty("chargify.site");

		logger.debug("chargify prop = "+apiKey);
		logger.debug("chargify prop = "+sharedKey);
		logger.debug("chargify prop = "+site);

		ChargifyUtil util = new ChargifyUtil();
		util.init( site, apiKey, sharedKey );
		return util;
	}

	/**
	 * The update action currently allows you to edit the attributes of the ChargifyCustomer, payment profile (credit card),
	 * or subscribed product (although no pro-ration or reset options are offered at this time). We only support
	 * updating the next billing date (testing this as it is unclear in the API)
	 *
	 * URL: https://<subdomain>.chargify.com/subscriptions/<subscription_id>.<format>
	 * Method: PUT
	 * Required Parameters: None
	 * Optional Parameters: XML or JSON data with updated values for ChargifyCustomer_attributes or credit_card_attributes
	 * Response: The updated subscription
	 *
	 * @param updateChargifySubscription
	 * @return updated subscription
	 */
	public ChargifySubscription updateSubscription(ChargifySubscription updateChargifySubscription) {

		UriBuilder uriBuilder = UriBuilder.fromUri(chargifySite + "subscriptions/"+updateChargifySubscription.getId()+".xml");
		URI uri = uriBuilder.build();

		logger.debug("updateSubscription: " + uri + " with " + updateChargifySubscription );

		WebResource service = apacheHttpClient.resource(uri);

		return service.accept(MediaType.TEXT_XML).put(ChargifySubscription.class, updateChargifySubscription );
	}
}

