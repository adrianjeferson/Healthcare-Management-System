import java.util.*;

class Nurse extends User implements UserOperations{
    private List<Patient> patients;
    private PatientManager patientManager;
    private AppointmentScheduler appointmentScheduler;

    public Nurse(String userID, String userName, int userAge) {
        super(userID, userName, userAge);
        this.patients = new ArrayList<>();
        this.patientManager = new PatientManager();
        this.appointmentScheduler = new AppointmentScheduler();
    }

    @Override
    public void viewDetails() {
        System.out.println("\nNurse Details: ");
        super.viewDetails();
    }

    @Override
    public void greetings() {
        System.out.println("\nHello, Nurse "+userName+"!");
    }

    public void addPatient(Patient patient) {
        patientManager.addPatient(patient);
    }

    public void removePatient() {
        patientManager.removePatient();
    }

    public Patient choosePatient() {
        return patientManager.choosePatient();
    }

    public Patient searchPatient(Scanner scanner) {
        return patientManager.searchPatient(scanner);
    }
    
    public void viewTestResults(Patient patient) {
        patient.viewTestResults();
    }

    public void viewPrescriptions(Patient patient) {
        patient.viewPrescriptions();
    }

    public void scheduleAppointment(Patient patient) {
        appointmentScheduler.scheduleAppointment(patient);
    }
}
