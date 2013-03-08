package com.txtago.util;

import com.mobile365.api.a2p.MessageFailedException;  // Used to notify API to generate an error response

import com.mobile365.api.a2p.datatypes.A2PDatatypeFactory;
import com.mobile365.api.a2p.datatypes.Item;
import com.mobile365.api.a2p.datatypes.MDN;
import com.mobile365.api.a2p.datatypes.Product;
import com.mobile365.api.a2p.datatypes.RequestStatus;


import com.mobile365.api.a2p.pdu.A2PMessageException;  // Used by the API to notify of an internal problem with an A2PMessage
import com.mobile365.api.a2p.pdu.A2PMessageFactory;  
import com.mobile365.api.a2p.pdu.PlaceOrderRequest;
import com.mobile365.api.a2p.pdu.PlaceOrderResponse;
import com.mobile365.api.a2p.pdu.QueryServiceRequest;
import com.mobile365.api.a2p.pdu.QueryServiceResponse;
import com.mobile365.api.a2p.pdu.SmsMoRequest;
import com.mobile365.api.a2p.pdu.SmsMoResponse;

import com.mobile365.api.a2p.servlet.A2PSMSRequestServlet; // Superclass
import com.txtago.scheduler.TaskScheduler;
import com.txtago.service.MessagingService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;

public class SmsMoServlet extends A2PSMSRequestServlet {

	protected Logger _log = Logger.getLogger( SmsMoServlet.class );
	private A2PMessageFactory _mf = null;
	private A2PDatatypeFactory _df = null;
	private int orderIDCounter = 0;
	
	
	public void init( ServletConfig config ) throws ServletException {
		// Initialize the servlet.
		// Call superclass
		super.init( config ); 
		_mf = A2PMessageFactory.newInstance();
		_df = A2PDatatypeFactory.newInstance();
		_log.info("Initializing A2P Test Servlet");
		
	}
	
	public SmsMoResponse onSmsMo( SmsMoRequest theRequest ) throws MessageFailedException {
		if ( theRequest == null ) {
			// The API should never pass a null object value to a callback method.  
			throw new MessageFailedException( RequestStatus.INVALID_REQUEST );
		}
		
		// Get some parameters from request
		String theShortCode = theRequest.getShortCode();
		MDN theMDN = theRequest.getSubscriberMdn();
		String textMessage = theRequest.getTextMessage();
				
		// Write parameters to log file.
		_log.info( "Some data points of received request ... " );
		_log.info( "Shortcode = " + theShortCode );
		_log.info( "Subscriber MDN = " + theMDN );
		_log.info( "TextMessage = " + textMessage );

		try {
			
			textMessage = textMessage.replaceAll("alau", "");
			textMessage = textMessage.trim();
			_log.info( "TextMessage = " + textMessage );
			
			MessagingService service = new MessagingService();
			service.optIn(theShortCode, theMDN.toString(), textMessage);
			
			//Use message factory to create a place order response message.
			SmsMoResponse response = _mf.createSmsMoResponse();

			// Set some parameters in reponse before returning
			response.setStatus( RequestStatus.SUCCESS );
			
			// Return response to send to client.
			return response;
		}
		catch ( Exception e ) {
			_log.error( "Exception Trace:", e );
			throw new MessageFailedException( RequestStatus.SERVER_ERROR );
		}	
	}
	
	public PlaceOrderResponse onPlaceOrder( PlaceOrderRequest theRequest ) throws MessageFailedException {
		if ( theRequest == null ) {
			// The API should never pass a null object value to a callback method.  
			throw new MessageFailedException( RequestStatus.INVALID_REQUEST );
		}
		
		// Get some parameters from request
		Item theItem = theRequest.getItem();
		String theShortCode = theRequest.getShortCode();
		MDN theMDN = theRequest.getSubscriberMdn();
		String theTransactionID = theRequest.getTransactionId();
				
		// Write parameters to log file.
		_log.info( "Some data points of received request ... " );
		_log.info( "Item = " + theItem.toString() );
		_log.info( "Shortcode = " + theShortCode );
		_log.info( "Subscriber MDN = " + theMDN );
		_log.info( "TransactionID = " + theTransactionID );

		try {
			//Use message factory to create a place order response message.
			PlaceOrderResponse response = _mf.createPlaceOrderResponse();

			// Set some parameters in reponse before returning
			response.setStatus( RequestStatus.SUCCESS );
			
			orderIDCounter++;
			response.setVASPOrderID( Integer.toString( orderIDCounter ) );
			// Return response to send to client.
			return response;
		}
		catch ( A2PMessageException e ) {
			_log.error( "Exception Trace:", e );
			throw new MessageFailedException(  RequestStatus.SERVER_ERROR );
		}
		catch ( Exception e ) {
			_log.error( "Exception Trace:", e );
			throw new MessageFailedException( RequestStatus.SERVER_ERROR );
		}
	}

	public QueryServiceResponse onQueryService(	QueryServiceRequest theRequest) throws MessageFailedException {
		_log.info( "Received a QueryService Request." );

		if ( theRequest == null ) {
			// The API should never pass a null object value to a callback method.  
			throw new MessageFailedException( RequestStatus.INVALID_REQUEST );
		}
		
		QueryServiceResponse response = _mf.createQueryServiceResponse();
		
		String[] keywords = theRequest.getKeywords();
		String shortCode = theRequest.getShortCode();
		
		_log.info( "ShortCode = " + shortCode );
		for ( int i = 0; i > keywords.length; i++ ) {
			_log.info( "Keyword = " + keywords[ i ] );
		}
		
		response.setStatus( RequestStatus.SUCCESS );

		Product product = _df.createProduct( "TextMessage", "txt1", 0.00F );
		response.setProductInformation( product );
		return response;

	}
}
