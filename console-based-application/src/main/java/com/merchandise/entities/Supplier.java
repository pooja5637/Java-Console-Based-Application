package com.merchandise.entities;


public class Supplier extends Merchandise {

	private long creditBalance;
	private String drivingLicenseNumber;
	
	public Supplier(int partnerId, String partnerName, String city, String state, long creditBalance,String drivingLicenseNumber) {
		super(partnerId,partnerName, city, state);
		this.creditBalance = creditBalance;
		this.drivingLicenseNumber = drivingLicenseNumber;
	}
	
	
	public long getCreditBalance() {
		return this.creditBalance;
	}

	
	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}
	
	
	
	@Override
	public String[] validate() {
		String[] msg =super.validate();
		
		//Logic for credit Balance
		if (this.creditBalance > 175000) {
			//msg[4] = String.valueOf(this.creditBalance);
			msg[4] = "Credit Balance not Valid";
		} 
		
		//logic for Driving license
		
		String regex = "^(([A-Z]{2}[0-9]{2})" + "( )|([A-Z]{2}-[0-9]" + "{2}))((19|20)[0-9]" + "[0-9])[0-9]{7}$";
		// It validate this format : HR-0619850034761
		boolean validLicence = this.drivingLicenseNumber.matches(regex);
		if (!validLicence) {
			
			//msg[5] = this.drivingLicenseNumber;
			msg[5] = "Driving Licence not valid";
		} 
		
		
		return msg;
	}

	@Override
	public String toString() {
		return "Supplier : [ " + getPartnerId() + ", " + getPartnerName() + ", " + getCity() + ", " + getState() + ", "
				+ getCreditBalance() + ", " + getDrivingLicenseNumber() + " ]";
	}

//	
//	public static void main(String args[]) {
//		
//		
//	Scanner sc=new Scanner(System.in);
//	
//	System.out.println("Enter partner Id:");
//	int id=sc.nextInt();
//	
//	System.out.println("Enter partner name:");
//	String partnerName=sc.next();
//	
//	System.out.println("Enter city:");
//	String city=sc.next();
//	
//	System.out.println("Enter state:");
//	String state=sc.next();
//	
//	System.out.println("Enter credit balance : ");
//	long creditBal =sc.nextLong();
//	
//	System.out.println("Enter driving License Number : ");
//	String drivingLicenseNum = sc.next();
//	
//	
//	
//	Supplier supp=new Supplier(id, partnerName, city, state, creditBal, drivingLicenseNum);
//
//	String[] value = supp.validate();
//	
//	
////	for (type variableName : arrayName) {
////		  // code block to be executed
////		}
//	for (String val : value) {
//		System.out.print(val+","); 
//	}
//	
//}
}
