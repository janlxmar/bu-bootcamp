import java.util.*;

public class ContactManager {
    
    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();
       // Step 4: add contacts here 
        contacts.put("John Appleseed", new Contact("John Appleseed", "(800) 000 0000"));
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "(800) 111 1111"));
        contacts.put("Mark Zuckerberg", new Contact("Mark Zuckerberg", "(818) 222 2222"));
        contacts.put("Maria Johnson", new Contact("Maria Johnson", "(818) 333 3333"));
        contacts.put("Alice Brown", new Contact("Alice Brown", "(818) 444 4444"));

        // Step 5: look up a contact 
        Contact found = contacts.get("Ada"); 
        if (found != null) {
             System.out.println(found);
        } else {
             System.out.println("Contact not found.");
        }

        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  
        System.out.println("=== All Contacts ===");
        for (Contact sort : sorted) {
            System.out.println(sort);
        }
    }
}
