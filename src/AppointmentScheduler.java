import java.util.*;

class AppointmentScheduler {
    private List<Patient> patients;

    public AppointmentScheduler() {
        this.patients = new ArrayList<>();
    }

    public void scheduleAppointment(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter appointment schedule for " + patient.userName + ": ");
        String appointment = scanner.nextLine();
        patient.getSchedule().add(appointment);
        System.out.println("Appointment scheduled for " + patient.userName);
    }
}
