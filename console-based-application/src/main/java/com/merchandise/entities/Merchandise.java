package com.merchandise.entities;

public class Merchandise {

	
	private int partnerId;
	private String partnerName;
	private String city;
	private String state;

	
	public Merchandise(int partnerId,String partnerName, String city, String state) {
	
		
		this.partnerId =partnerId;
		this.partnerName = partnerName;
		this.city = city;
		this.state = state;
			
}
	
	
	public int getPartnerId() {
		return this.partnerId;
	}
	
	public String getPartnerName() {
		return this.partnerName;
	}


	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}
	
	// Validation method
	public String[] validate() {
		
		String[] msg=new String[10];
		//Logic for partner id
		if (this.partnerId < 0) {
			
			//msg[0] = String.valueOf(this.partnerId);//convert int to string
			msg[0] = "Please enter valid ID";
		} 
		//Logic for Partner name
		
		if (this.partnerName == null || this.partnerName.length() < 5) {
			
			//msg[1] = this.partnerName;
			msg[1] = "Please enter valid name";
		} 
		//Logic for City
		if ( this.city == null || this.city.length() < 3 ) {
			
			//msg[2] = this.city;
			msg[2] = "Please enter proper city name";
		} 
		
		
		//Logic for State
		if ( state == null || state.length() < 3 ) {
			//msg[3] = this.state;
			msg[3] = "Please enter proper state name";
			
		} 
		
		return msg;
	}
	
	@Override
	public String toString() {
		return "[partnerId=" + partnerId + ", partnerName=" + partnerName + ", city=" + city + ", state="
				+ state + "]";
	}



	
//	public static void main(String args[]) {
//		
//		
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("Enter partner Id:");
//		int id=sc.nextInt();
//		
//		System.out.println("Enter partner name:");
//		String partnerName=sc.next();
//		
//		System.out.println("Enter city:");
//		String city=sc.next();
//		
//		System.out.println("Enter state:");
//		String state=sc.next();
//		
//		
//		
//		Merchandise m= new Merchandise(id,partnerName,city,state);
//		
//		String[] value = m.validate();
//		
//		
////		for (type variableName : arrayName) {
////////			  // code block to be executed
////////			}
//////		for (String val : value) {
//////			System.out.print(val+","); 
//////		}
//////		
//////		
////////		System.out.println(value[0]);
//////		
//		
//		
//		
//	
//		
//	}
}
