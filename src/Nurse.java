import java.util.*;

class Nurse extends User {
    private List<Patient> patients;

    public Nurse(String userID, String userName, int userAge) {
        super(userID, userName, userAge);
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient " + patient.userName + " added.");
    }

    public Patient choosePatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).userName + " (ID: " + patients.get(i).userID + ")");
        }
        System.out.print("Choose a patient by ID: ");
        int choice = scanner.nextInt() - 1;
        return patients.get(choice);
    }

    public void viewTestResults(Patient patient) {
        patient.viewTestResults();
    }

    public void viewPrescriptions(Patient patient) {
        patient.viewPrescriptions();
    }

    public void computeBilling(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter billing amount for " + patient.userName + ": $");
        double amount = scanner.nextDouble();
        patient.addBilling(amount);
        System.out.println("Billing updated for " + patient.userName);
    }

    public void scheduleAppointment(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter appointment schedule for " + patient.userName + ": ");
        String appointment = scanner.nextLine();
        patient.setSchedule(appointment);
        System.out.println("Appointment scheduled for " + patient.userName);
    }
}
