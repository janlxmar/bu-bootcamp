import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest {
 
 private Contact contact; 
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  } 
   @Test 
  void constructor_setsNameCorrectly() { 
    assertEquals("Ada Lovelace", contact.getName()); 
  } 

 @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", contact.getPhone()); 
  } 
 
@Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001"); 
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }

  // My own test cases
  @Test
  void constructor_containsNoPhone() {
    Contact c = new Contact("Jan Lemar Baltazar", null);
    assertNull(c.getPhone());
  }

  @Test
  void constructor_containsNoName() {
    Contact c = new Contact(null, "(800) 555-0001");
    assertNull(c.getName());
  }

} 