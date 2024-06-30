
public class Contact { // Used to store variables
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) { // Constructor to initialize contact object with requirements
        setContactId(contactId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    public String getContactId() { // Get method for contactID
        return contactId;
    }

    void setContactId(String contactId) { // Private setter method for contactId with validation
        if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid input."); // Throw exception if input is invalid
        }
        this.contactId = contactId;
    }

    public String getFirstName() { // Get method for firstName
        return firstName;
    }

    public void setFirstName(String firstName) { // Set method with validation
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid input."); // Throw exception if input invalid
        }
        this.firstName = firstName;
    }

    public String getLastName() { // Get method
        return lastName;
    }

    public void setLastName(String lastName) { // Set method with validation
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid input."); // Throw exception if input is invalid
        }
        this.lastName = lastName;
    }

    public String getPhoneNumber() { // Get method
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() != 10 || phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid input.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Invalid input.");
        }
        this.address = address;
    }
}