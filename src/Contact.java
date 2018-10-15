public class Contact
{
    private String firstName, lastName, address;
    private int id, phoneNumber;

    public Contact(int id, String firstName, String lastName, String address, int phoneNumber) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(!firstName.isEmpty())
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("First name cannot be empty");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!lastName.isEmpty())
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("Last name cannot be empty");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(!address.isEmpty())
            this.address = address;
        else
            throw new IllegalArgumentException("Address cannot be empty");
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        if(phoneNumber >= 1)
            this.phoneNumber = phoneNumber;
        else
            throw new IllegalArgumentException("Phone number cannot be empty and must be a number");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 1)
            this.id = id;
        else
            throw new IllegalArgumentException("Id cannot be empty");
    }
}
