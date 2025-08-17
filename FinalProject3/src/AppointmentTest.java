import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        Date futureDate = getFutureDate(2);
        Appointment appointment = new Appointment("APT001", futureDate, "Checkup with Dr. Smith");
        assertEquals("APT001", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Checkup with Dr. Smith", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        Date futureDate = getFutureDate(2);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("TOO_LONG_APT_ID", futureDate, "Valid description"));
    }

    @Test
    public void testNullDateOrPastDate() {
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT002", null, "No date"));


        Date pastDate = getPastDate();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT003", pastDate, "Backdated appointment"));
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = getFutureDate(1);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT004", futureDate, null));


        String tooLongDescription = "This description is way too long to be accepted as valid because it exceeds fifty characters.";
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT005", futureDate, tooLongDescription));
    }

    // Utility methods

    private Date getFutureDate(int daysAhead) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysAhead);
        return cal.getTime();
    }

    private Date getPastDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}

