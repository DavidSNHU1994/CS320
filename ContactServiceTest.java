/*
 * Written by: David Hammons
 */


package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	ContactService contactService;
	
	@BeforeEach
	void init() {
		contactService = new ContactService();
	}

	@Test
	@DisplayName("Test creating a new contact object in ContactService")
	void TestAccountCreation() {
		contactService.SetContacts("34", "Bob", "Ross", "6034567890", "34 Bob Lane");
		assertEquals("34", contactService.contacts.get(0).getUniqueID());
		assertEquals("Bob", contactService.contacts.get(0).getFirstName());
		assertEquals("Ross", contactService.contacts.get(0).getLastName());
		assertEquals("6034567890", contactService.contacts.get(0).getPhoneNumber());
		assertEquals("34 Bob Lane", contactService.contacts.get(0).getAddress());
	}
	
	@Test
	@DisplayName("Test removing an account from the ContactService")
	void TestRemoveAccount() {
		contactService.SetContacts("34", "Bob", "Ross", "6034567890", "34 Bob Lane");
		contactService.SetContacts("45", "Shawn", "Roger", "3456789234", "56 Roger Rd");
		contactService.RemoveContacts(34);
		assertTrue(contactService.contacts.get(0).getUniqueID().equals("45"));
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			contactService.contacts.get(1);
		}, "Should throw error because index 1 is empty now");
		
		
	}
	
	@Test
	@DisplayName("Test modifying a Contacts object in ContactService")
	void TestModifyAccount(){
		contactService.SetContacts("34", "Bob", "Ross", "6034567890", "34 Bob Lane");
		contactService.ModifyContacts("34", "first name", "Rob");
		contactService.ModifyContacts("34", "last name", "Floss");
		contactService.ModifyContacts("34", "phone number", "1234567890");
		contactService.ModifyContacts("34", "address", "67 Flossing Drive");
		
		assertEquals("Rob", contactService.contacts.get(0).getFirstName());
		assertEquals("Floss", contactService.contacts.get(0).getLastName());
		assertEquals("1234567890", contactService.contacts.get(0).getPhoneNumber());
		assertEquals("67 Flossing Drive", contactService.contacts.get(0).getAddress());
		
	}
	
	@Test
	@DisplayName("Test that an illegal argument occurs if info not allowed in field")
	void TestIllegalArgumentAccountCreation() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.SetContacts("34", "Bob", "Ross", "6034567890454534", "34 Bob Lane");
		}, "Should give illegal argument error since number field is too long");
		
	}
	
	@Test
	@DisplayName("Test illegal argument occurs if modified contact info isn't correctly done")
	void TestIllegalArgumentModifyAccount() {
		contactService.SetContacts("34", "Bob", "Ross", "6034567890", "34 Bob Lane");
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.ModifyContacts("34","last name", "Vanderbeltingrad");
		}, "Should give illegal argument error since number field is too long");
	}

}
