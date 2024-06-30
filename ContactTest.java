import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactConstructorValid() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertEquals("C001", contact.getContactId());
        Assertions.assertEquals("John", contact.getFirstName());
        Assertions.assertEquals("Doe", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhoneNumber());
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testSetContactIdValid() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contact.setContactId("C002");
        Assertions.assertEquals("C002", contact.getContactId());
    }

    @Test
    public void testSetFirstNameValid() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        Assertions.assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetLastNameValid() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        Assertions.assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetPhoneNumberValid() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhoneNumber("9876543210");
        Assertions.assertEquals("9876543210", contact.getPhoneNumber());
    }

    @Test
    public void testSetAddressValid() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Oak Ave");
        Assertions.assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    public void testSetContactIdInvalid_Null() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setContactId(null);
        });
    }

    @Test
    public void testSetFirstNameInvalid_Empty() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("");
        });
    }

    @Test
    public void testSetLastNameInvalid_TooLong() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("Smithers");
        });
    }

    @Test
    public void testSetPhoneNumberInvalid_Format() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("12345"); // Not 10 digits
        });
    }

    @Test
    public void testSetAddressInvalid_Null() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    public void testSetAddressInvalid_TooLong() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901"); // More than 30 characters
        });
    }
}