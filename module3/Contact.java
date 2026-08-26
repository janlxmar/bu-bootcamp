public class Contact {

    // Two private string fields
    private String name;
    private String phone;
    
    // Constructor that takes both fields
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters for name and phone
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

    // TOSTRING
    @Override
    public String toString() {
        return name + " | " + phone;
    }
    
}
