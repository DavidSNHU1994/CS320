/*
 * Written by: David Hammons
 */

package src;


public class Contact{

	private String uniqueID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	

	//Constructor that builds Contact object upon initialization
	public Contact(String uniqueID, String firstName, String lastName, String phoneNumber, String address) {
		if (uniqueID == null || uniqueID.length() > 10) {
			throw new IllegalArgumentException("Invalid Unique ID");
		}
		
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if(phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		
		this.uniqueID = uniqueID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
	public void ChangeFirstName(String firstName) {
		
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		this.firstName = firstName;
	}
	
	public void ChangeLastName(String lastName) {
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		this.lastName = lastName;
	}
	
	public void ChangePhoneNumber(String phoneNumber) {
		
		if(phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		this.phoneNumber = phoneNumber;
	}
	
	public void ChangeAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.address = address;
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	
	public String getLastName() {
		
		return lastName;
	}

	public String getPhoneNumber() {
	
	return phoneNumber;
	}

	public String getAddress() {
	
	return address;
	}

	public String getUniqueID() {
	
	return uniqueID;
	}
}
