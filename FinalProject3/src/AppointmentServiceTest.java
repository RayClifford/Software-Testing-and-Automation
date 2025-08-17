import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

public class AppointmentServiceTest {
    private AppointmentService service;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
        Appointment appointment = new Appointment("APT001", getFutureDate(2), "Dental cleaning");
        service.addAppointment(appointment);
    }

    @Test
    public void testAddAppointmentSuccess() {
        Appointment newAppointment = new Appointment("APT002", getFutureDate(5), "Eye exam");
        assertDoesNotThrow(() -> service.addAppointment(newAppointment));
    }

    @Test
    public void testAddDuplicateIdFails() {
        Appointment duplicate = new Appointment("APT001", getFutureDate(3), "Duplicate test");
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(duplicate));
    }

    @Test
    public void testDeleteAppointmentSuccess() {
        service.deleteAppointment("APT001");
        assertNull(service.getAppointment("APT001"));
    }

    @Test
    public void testDeleteNonExistentAppointmentFails() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("NON_EXIST"));
    }

    // Utility method

    private Date getFutureDate(int daysAhead) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysAhead);
        return cal.getTime();
    }
}
