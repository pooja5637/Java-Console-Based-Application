package com.merchandise.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;


public class Service {
	
	public void saveCustomerDetails(List<Customer> list,Customer cust) {
		
		String[] errorMsg = cust.validate();
		
		boolean flag = true;
		for (String val : errorMsg) {
			if (val != null) {
				System.out.print(val+" , ");
				flag=false;
			}
		}
		
		if (flag) {
			list.add(cust);
			System.out.println("Customer Details Saved..");
		} else {
			System.err.println("Sorry Something wrong.. can't add!!! ");
		}
			
				
	}
		
	
	
	public void saveSupplierDetails(List<Supplier> list,Supplier sup) {
		
		String[] value = sup.validate();
		boolean flag = true;
		for (String val : value) {
			if (val != null) {
				System.out.print(val+" , ");
				flag = false;
			}			
		}
		
		if (flag) {
			list.add(sup);
			System.out.println("Supplier added succesfully");
		} else {
			System.err.println("Sorry Something wrong.. can't add!!! ");
		}
		
	}
	
	public List<Customer> getAllCustomers(List<Customer> list) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("D://sample.pdf"));
			document.open();
			for(Customer customer : list) {
				if(customer !=null ) {
					//System.out.println("Customer Details.."+customer.toString());
					Paragraph para=new Paragraph(customer.toString());
					document.add(para);
					System.out.println("Customer List Created -->location-->> D://sample.pdf");
				}
			}
			
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return list;
		
	}




	public List<Supplier> getAllSuppliers(List<Supplier> list) {
		for(Supplier supplier : list) {
			if(supplier !=null ) {
				System.out.println("Customer Details.."+supplier.toString());
			}
	}
		return list;
	}


	public Customer getCustomerById(List<Customer> list,int customerId) {
		
		if (list.isEmpty()) {
			System.out.println("Customer list is empty!");
		} else {
			for (Customer customer : list) {
				if (customer.getPartnerId() == customerId) {
					System.out.println(customer);
					
				}
				else {
					System.out.println(customerId+" Id not found..");
				}
			}
		}
		return null;
	}

	
}

