import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
    }

    @Test
    public void testAddContactSuccess() {
        Contact newContact = new Contact("124", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(newContact);
        assertDoesNotThrow(() -> service.updateFirstName("124", "Janet"));
    }

    @Test
    public void testAddDuplicateIdThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.addContact(new Contact("123", "Bob", "Ross", "1234567890", "Somewhere")));
    }

    @Test
    public void testDeleteContactSuccess() {
        service.deleteContact("123");
        assertThrows(IllegalArgumentException.class, () ->
            service.updateLastName("123", "Gone"));
    }

    @Test
    public void testUpdateFields() {
        service.updateFirstName("123", "Johnny");
        assertEquals("Johnny", contact.getFirstName());

        service.updateLastName("123", "Donny");
        assertEquals("Donny", contact.getLastName());

        service.updatePhone("123", "1112223333");
        assertEquals("1112223333", contact.getPhone());

        service.updateAddress("123", "789 Maple Ave");
        assertEquals("789 Maple Ave", contact.getAddress());
    }
}

