/*
 * Written by: David Hammons
 */

package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	@DisplayName("Tests creating a Contact object")
	void TestIDCreation() {
		Contact contact = new Contact("34", "Bob", "Ross", "6034567890", "34 Bob Lane");
		assertTrue(contact.getUniqueID().equals("34"));
		assertTrue(contact.getFirstName().equals("Bob"));
		assertTrue(contact.getLastName().equals("Ross"));
		assertTrue(contact.getPhoneNumber().equals("6034567890"));
		assertTrue(contact.getAddress().equals("34 Bob Lane"));
		
	}
	
	@Test
	@DisplayName("Tests exceptions are thrown if strings are null")
	void TestIDCreationNullException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Bob", "Ross", "6034567890", "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", null, "Ross", "6034567890", "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", "Bob", null, "6034567890", "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", "Bob", "Ross", null, "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", "Bob", "Ross", "6034567890", null);
		});
	}
	
	@Test
	@DisplayName("Tests that illegal argument is thrown if requirements are not met")
	void TestIDCreationStringTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678976", "Bob", "Ross", "6034567890", "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", "Robert Ross", "Ross", "6034567890", "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", "Bob", "Robert Ross", "6034567890", "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", "Bob", "Ross", "60345678902", "34 Bob Lane");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("34", "Bob", "Ross", "6034567890", "34 Bob Ross Lane, Los Angeles, California ");
		});
	}
}
