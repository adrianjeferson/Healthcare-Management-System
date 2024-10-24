import java.util.*;

class Doctor extends User implements UserOperations{
    private List<Patient> patients;
    private PatientManager patientManager;
    private PrescriptionManager prescriptionManager;
    private AppointmentScheduler appointmentScheduler;

    public Doctor(String userID, String userName, int userAge) {
        super(userID, userName, userAge);
        this.patients = new ArrayList<>();
        this.patientManager = new PatientManager();
        this.prescriptionManager = new PrescriptionManager();
        this.appointmentScheduler = new AppointmentScheduler();
    }

    @Override
    public void viewDetails() {
        System.out.println("\nDoctor Details: ");
        super.viewDetails(); 
    }

    @Override
    public void greetings() {
        System.out.println("\nHello, Dr. "+userName+"!");
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
    
    public void updatePrescription(Patient patient) {
        prescriptionManager.updatePrescription(patient);
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
