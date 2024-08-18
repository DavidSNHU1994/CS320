/*
 * Written by: David Hammons
 */

package src;

import java.util.ArrayList;

public class ContactService{
	
		//initializing array to hold Contacts object
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		//Create contacts
		public void SetContacts(String uniqueID, String firstName, String lastName, String phoneNumber, String address) {
			Contact contact = new Contact(uniqueID, firstName, lastName, phoneNumber, address);
			contacts.add(contact);
		}
		
		//Remove contacts
		public void RemoveContacts(int removeUniqueID) {
			
			for(int i = 0; i < contacts.size(); i++){
				if(contacts.get(i).getUniqueID().equals(String.valueOf(removeUniqueID))) {
					contacts.remove(i);
				}
			}
		}
		
		//ModifyContacts
		public void ModifyContacts(String uniqueID, String itemToModify, String itemChange) {
			
			
			for(int i = 0; i < contacts.size(); i++) {
				if(contacts.get(i).getUniqueID().equals(uniqueID)) {
					switch(itemToModify) {
						case "first name":
							contacts.get(i).ChangeFirstName(itemChange);
							break;
						case "last name":
							contacts.get(i).ChangeLastName(itemChange);
							break;
						case "phone number":
							contacts.get(i).ChangePhoneNumber(itemChange);
							break;
						case "address":
							contacts.get(i).ChangeAddress(itemChange);
							break;
						default:
							break;
					}
				}
			}
		}
	}