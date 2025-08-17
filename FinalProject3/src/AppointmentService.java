import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds an appointment. The ID must be unique.
     */
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    /**
     * Deletes an appointment by ID.
     */
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentId);
    }

    /**
     * Gets an appointment (optional, for testing or use).
     */
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}

