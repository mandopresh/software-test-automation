import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        Assertions.assertEquals(contact, contactService.getContactById("C001"));
    }

    @Test
    public void testAddContact_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    @Test
    public void testAddContact_DuplicateId() {
        Contact contact1 = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("C001", "Jane", "Smith", "9876543210", "456 Oak Ave");
        contactService.addContact(contact1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("C001");
        Assertions.assertNull(contactService.getContactById("C001"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("C001", "Jane", "Smith", "9876543210", "456 Oak Ave");
        Contact updatedContact = contactService.getContactById("C001");
        Assertions.assertEquals("Jane", updatedContact.getFirstName());
        Assertions.assertEquals("Smith", updatedContact.getLastName());
        Assertions.assertEquals("9876543210", updatedContact.getPhoneNumber());
        Assertions.assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContact_NotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("C002", "Jane", "Smith", "9876543210", "456 Oak Ave");
        });
    }

    @Test
    public void testGetContactById() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContactById("C001");
        Assertions.assertEquals(contact, retrievedContact);
    }

    @Test
    public void testGetContactById_NotFound() {
        Assertions.assertNull(contactService.getContactById("C002"));
    }
}