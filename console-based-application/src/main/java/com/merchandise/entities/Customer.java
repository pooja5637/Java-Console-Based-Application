package com.merchandise.entities;



public class Customer extends Merchandise {

	private long creditLimit;
	private String phoneNumber;
	private String email;
	
	public Customer(int partnerId,String partnerName, String city, String state, long creditLimit, String phoneNumber, String email) {
		
		super(partnerId,partnerName, city, state);
		this.creditLimit = creditLimit;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public long getCreditLimit() {
		return this.creditLimit;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	
	public String getEmail() {
		return this.phoneNumber;
	}
	

	@Override
	public String[] validate() {

		String[] msg =super.validate();
		
		//Logic for credit Limit
		if (this.creditLimit > 50000) {
			
			//msg[4] = String.valueOf(this.creditLimit);
			msg[4] = "Credit limit not valid";
		}
		
		
		//Logic for phone no
		
		boolean validNo=this.phoneNumber.matches("\\d{10}"); //validates phone numbers having 10 digits (9998887776)  
		
		if(!validNo) {
			
			//msg[5] = this.phoneNumber;
			msg[5] = "Phone number not valid";
		}
		
		//Logic for email
		
		boolean validEmail = this.email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
		if (!validEmail) {
			
			//msg[6] = this.email;
			msg[6] = "Email not valid";
		}
		return msg;
	}
	
	@Override
	public String toString() {
		return "Customer : [ " + getPartnerId() + ", " + getPartnerName() + ", " + getCity() + ", " + getState() + ", "
				+ getCreditLimit() + ", " + getPhoneNumber() + ", " + getEmail() + " ]";
	}


}