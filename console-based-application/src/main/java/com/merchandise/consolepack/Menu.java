package com.merchandise.consolepack;


import java.util.*;


import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;
import com.merchandise.services.Service;

public class Menu {

	public static void main(String[] args) {
		
		Service service = new Service();
		
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
		
		
		
		// Loop for Menu
		
		boolean b = true;
		do {
			//display options list
			System.out.println("Select Proper Options");
			System.out.println("1 -> Add Customer");
			System.out.println("2 -> Add Supplier");
			System.out.println("3 -> Display Report");
			System.out.println("4 -> Search Customer By ID");
			System.out.println("5 -> Exit");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt(); 
			
			
			if(choice > 0) {
				switch (choice) {
				case 1: {
				
						System.out.println("Enter details for customer");
						
						System.out.println("Enter customer ID : ");
						int partnerId = sc.nextInt();
						
						System.out.println("Enter customer name : ");
						String partnerName = sc.next();
						
						System.out.println("Enter city : ");
						String city = sc.next();
						
						System.out.println("Enter state : ");
						String state = sc.next();
						
						System.out.println("Enter amount : ");
						long creditLimit = Long.parseLong(sc.next());
						
						System.out.println("Enter phone number : ");
						String phoneNumber = sc.next();
						
						System.out.println("Enter email : ");
						String email = sc.next();

						Customer cust = new Customer(partnerId,partnerName, city, state, creditLimit, phoneNumber, email);
						service.saveCustomerDetails(customerList,cust);
//						String[] value = cust.validate();
						
//						boolean flag = true;
//						for (String val : value) {
//							if (val != null) {
//								System.out.print(val+" , ");
//								flag=false;
//							}
//						}
//						
//						if (flag) {
//							service.saveCustomerDetails(customerList,cust);
//							System.out.println("Customer Details Saved..");
//						} else {
//							System.err.println("Sorry Something wrong.. can't add!!! ");
//						}
					
				
				System.out.println("************************************************");
				break;
			}
			case 2: {
				// Add Suppliers
			
						System.out.println("Enter details for Supplier");
						System.out.println("Enter Id : ");
						int partnerId = sc.nextInt();
						System.out.println("Enter Supplier Name : ");
						String partnerName = sc.next();
						System.out.println("Enter City : ");
						String city = sc.next();
						System.out.println("Enter State : ");
						String state = sc.next();
						System.out.println("Enter Credit Balance : ");
						long creditBalance = sc.nextLong();
						System.out.println("Enter Driving Licence Number : ");
						String drivingLicenseNumber = sc.next();

						Supplier sup = new Supplier(partnerId, partnerName, city, state, creditBalance,drivingLicenseNumber);
						service.saveSupplierDetails(supplierList,sup);
					
				
				System.out.println("*******************************************");
				break;
			}
			case 3: {
				// Display the Report
				System.out.println("***********Display Report****************");
				System.out.println("1 - Customer");
				System.out.println("2 - Supplier");
				System.out.print("Enter you choice : ");
			
				int ch = sc.nextInt();
				
				if (ch > 0 && ch <=2 ) {
					if (ch == 1) {
						// Display Customers
						List<Customer> customer = service.getAllCustomers(customerList);		 
					} else {
						// Display Suppliers
						List<Supplier> supplier = service.getAllSuppliers(supplierList);
						if (supplier.isEmpty()) {
							System.err.println("No supplier added yet");
						}
						
					}
				} else {
					System.out.println("Wrong choice!");
				}
				System.out.println("*************************************");
				break;
			}
			case 4: {
				// Search by ID in customer
				
				System.out.println("Enter ID for search : ");
				
				int id = sc.nextInt();
				
				service.getCustomerById(customerList,id);
				
				System.out.println("*************************************");
				break;
			}
			case 5: {
				// Loop termination
				b = false;
				sc.close();
				System.out.println("");
				break;
			}
			default: {
				System.err.println("Please enter correct choice..");
			}
			}}
		
		}while(b);
		
		
		
	}
}