import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact cannot be null or duplicate contactId.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        // Update fields (only update non-null values)
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phoneNumber != null) {
            contact.setPhoneNumber(phoneNumber);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    public Contact getContactById(String contactId) {
        return contacts.get(contactId);
    }
}