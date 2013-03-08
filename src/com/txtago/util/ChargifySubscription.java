package com.txtago.util;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * This code was found on the chargify support site. I made slight modifications
 *
 * @author Bob Hopwood
 * @author Revision $Author: bobh $
 * @version $Revision: 1.2 $ $Date: 2012/01/03 22:59:55 $
 */


@XmlRootElement(name="subscription")
public class ChargifySubscription {
	private String id; // The subscription unique id within Chargify.
	private String state; // The current state of the subscription. Please see the documentation for Subscription States
	private int    balance_in_cents; // Gives the current outstanding subscription balance, in the number of cents.
	private Date   current_period_started_at; // Timestamp relating to the start of the current (recurring) period
	private Date   current_period_ends_at; // Timestamp relating to the end of the current (recurring) period (i.e. when the next regularly scheduled attempted charge will occur)
	private Date   next_assessment_at; // Timestamp that indicates when capture of payment will be tried or retried. This value will usually track the current_period_ends_at, but will diverge if a renewal payment fails and must be retried. In that case, the current_period_ends_at will advance to the end of the next period (time doesnÕt stop because a payment was missed) but the next_assessment_at will be scheduled for the auto-retry time (i.e. 24 hours in the future, in some cases)
	private Date   trial_started_at; // Timestamp for when the trial period (if any) began
	private Date   trial_ended_at; // Timestamp for when the trial period (if any) ended
	private Date   activated_at; // (Read Only) Timestamp for when the subscription began (i.e. when it came out of trial, or when it began in the case of no trial)
	private Date   expires_at; // Timestamp giving the expiration date of this subscription (if any)
	private Date   created_at; // The creation date for this subscription
	private Date   updated_at; // The date of last update for this subscription
	private Date   canceled_at; // The timestamp of the most recent cancellation
	private Date   delayed_cancel_at; //  Timestamp for when the subscription is currently set to cancel.
	private String cancellation_message; // Seller-provided reason for, or note about, the cancellation.
	private String signup_revenue; // The revenue, formatted as a string of decimal separated dollars and cents, from the subscription signup ($50.00 would be formatted as 50.00)
	private String signup_payment_id; // The ID of the transaction that generated the revenue
	private String cancel_at_end_of_period; // Whether or not the subscription will (or has) canceled at the end of the period.
	private String previous_state; // Only valid for webhook payloads The previous state for webhooks that have indicated a change in state. For normal API calls, this will always be the same as the state (current state)
	private String coupon_code; // The coupon code of the coupon currently applied to the subscription
	private ChargifyCustomer   customer; // For customer attributes, see [Customers API](/faqs/api/api-customers)
	//private Product    product; // For product attributes, see [Products API]
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		
	}

	

	public int getBalance_in_cents() {
		return balance_in_cents;
	}

	public void setBalance_in_cents(int balance_in_cents) {
		this.balance_in_cents = balance_in_cents;
	}

	public Date getCurrent_period_started_at() {
		return current_period_started_at;
	}

	public void setCurrent_period_started_at(Date current_period_started_at) {
		this.current_period_started_at = current_period_started_at;
	}

	public Date getCurrent_period_ends_at() {
		return current_period_ends_at;
	}

	public void setCurrent_period_ends_at(Date current_period_ends_at) {
		this.current_period_ends_at = current_period_ends_at;
	}

	public Date getNext_assessment_at() {
		return next_assessment_at;
	}

	public void setNext_assessment_at(Date next_assessment_at) {
		this.next_assessment_at = next_assessment_at;
	}

	public Date getTrial_started_at() {
		return trial_started_at;
	}

	public void setTrial_started_at(Date trial_started_at) {
		this.trial_started_at = trial_started_at;
	}

	public Date getTrial_ended_at() {
		return trial_ended_at;
	}

	public void setTrial_ended_at(Date trial_ended_at) {
		this.trial_ended_at = trial_ended_at;
	}

	public Date getActivated_at() {
		return activated_at;
	}

	public void setActivated_at(Date activated_at) {
		this.activated_at = activated_at;
	}

	public Date getExpires_at() {
		return expires_at;
	}

	public void setExpires_at(Date expires_at) {
		this.expires_at = expires_at;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public ChargifyCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ChargifyCustomer customer) {
		this.customer = customer;
	}
/*
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
*/
	

	public String getCancellation_message() {
		return cancellation_message;
	}

	public void setCancellation_message(String cancellation_message) {
		this.cancellation_message = cancellation_message;
	}

	public Date getCanceled_at() {
		return canceled_at;
	}

	public void setCanceled_at(Date canceled_at) {
		this.canceled_at = canceled_at;
	}

	public String getSignup_revenue() {
		return signup_revenue;
	}

	public void setSignup_revenue(String signup_revenue) {
		this.signup_revenue = signup_revenue;
	}

	public String getSignup_payment_id() {
		return signup_payment_id;
	}

	public void setSignup_payment_id(String signup_payment_id) {
		this.signup_payment_id = signup_payment_id;
	}

	public String getCancel_at_end_of_period() {
		return cancel_at_end_of_period;
	}

	public void setCancel_at_end_of_period(String cancel_at_end_of_period) {
		this.cancel_at_end_of_period = cancel_at_end_of_period;
	}

	public Date getDelayed_cancel_at() {
		return delayed_cancel_at;
	}

	public void setDelayed_cancel_at(Date delayed_cancel_at) {
		this.delayed_cancel_at = delayed_cancel_at;
	}

	public String getPrevious_state() {
		return previous_state;
	}

	public void setPrevious_state(String previous_state) {
		this.previous_state = previous_state;
	}

	public String getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}


	@Override
	public String toString() {
		return new StringBuffer().
				append("id"+ id).
				append("state"+ state).
				append("balance_in_cents"+ balance_in_cents).
				append("current_period_started_at"+ current_period_started_at).
				append("current_period_ends_at"+ current_period_ends_at).
				append("next_assessment_at"+ next_assessment_at).
				append("trial_started_at"+ trial_started_at).
				append("trial_ended_at"+ trial_ended_at).
				append("activated_at"+ activated_at).
				append("expires_at"+ expires_at).
				append("created_at"+ created_at).
				append("updated_at"+ updated_at).
				append("customer"+ customer).
				//append("product"+ product).
				append("cancellation_message"+ cancellation_message).
				append("canceled_at"+ canceled_at).
				append("signup_revenue"+ signup_revenue).
				append("signup_payment_id"+ signup_payment_id).
				append("cancel_at_end_of_period"+ cancel_at_end_of_period).
				append("delayed_cancel_at"+ delayed_cancel_at).
				append("previous_state"+ previous_state).
				append("coupon_code"+ coupon_code).
				toString();
	}
}
