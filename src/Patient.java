import java.util.*;

class Doctor extends User {
    private List<Patient> patients;

    public Doctor(String userID, String userName, int userAge) {
        super(userID, userName, userAge);
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient " + patient.userName + " added.");
    }

    public void removePatient() {
        if (patients.isEmpty()) {
            System.out.println("\nNo patients available to remove.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPatients:");
            for (int i = 0; i < patients.size(); i++) {
                System.out.println((i + 1) + ". " + patients.get(i).getUserName() + " (ID: " + patients.get(i).getUserID() + ")");
            }
            System.out.print("\nEnter the Patient ID to remove: ");
            String patientId = scanner.nextLine();
    
            Patient patientToRemove = null;
            for (Patient patient : patients) {
                if (patient.getUserID().equals(patientId)) {
                    patientToRemove = patient;
                    break;
                }
            }
    
            if (patientToRemove != null) {
                patients.remove(patientToRemove);
                System.out.println("Patient " + patientToRemove.getUserName() + " has been removed.");
                break;
            } else {
                System.out.println("No patient found with that ID. Please try again.");
            }
        }
    }
    
    public Patient choosePatient() {
        if(patients.isEmpty()){
            System.out.println("\nNo patients available. Please add a patient first.");
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPatients:");
            for (int i = 0; i < patients.size(); i++) {
                System.out.println((i + 1) + ". " + patients.get(i).userName + " (ID: " + patients.get(i).userID + ")");
            }
            System.out.print("\nChoose a patient by ID: ");
            String choice = scanner.nextLine();
            for (Patient patient:patients){
                if (patient.userID.equals(choice)){
                    System.out.println("\nPatient "+patient.userName+" (ID: )"+patient.userID);
                    return patient;
                }
            }
            System.out.println("\nNo patient found with that ID. Please try again.");
        }
        
    }

    public Patient searchPatient(Scanner scanner) {
        System.out.print("\nEnter Patient ID or Name to search: ");
        String search = scanner.nextLine().trim();

        if (search.isEmpty()) {
            System.out.println("Search term cannot be empty. Please try again.");
            return null; // Return null if input is invalid
        }

        for (Patient patient : this.patients) {
            // Search by ID
            if (patient.getUserID().equalsIgnoreCase(search)) {
                return patient;
            }
            // Search by Name
            if (patient.getUserName().equalsIgnoreCase(search)) {
                return patient;
            }
        }
        
        System.out.println("\nNo patient found with the given ID or Name.");
        return null;  // Return null if no patient is found
    }
    

    public void updatePrescription(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Create prescription");
        System.out.println("2. Delete prescription");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        if(choice.equals("1")){
            System.out.print("\nEnter prescription for " + patient.userName + ": ");
            String prescription=scanner.nextLine();
            patient.addPrescription(prescription);
            System.out.println(prescription + " added for " + patient.userName);
        } else if(choice.equals("2")){
            System.out.print("\nDelete prescription for " + patient.userName + ": ");
            String prescription=scanner.nextLine();
            patient.removePrescription(prescription);
            System.out.println(prescription + " deleted for " + patient.userName);
        }
    }

    public void updateTestResult(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Create test result");
        System.out.println("2. Delete test result");
        System.out.print("Enter choice: ");
        String choice=scanner.nextLine();

        if(choice.equals("1")){
            System.out.print("\nEnter test result to add for " + patient.userName + ": ");
            String testResult = scanner.nextLine();
            patient.addTestResult(testResult);
            System.out.println("Test result updated for " + patient.userName);
        } else if(choice.equals("2")){
            System.out.print("\nEnter test result to delete for " + patient.userName + ": ");
            String testResult = scanner.nextLine();
            patient.removeTestResult(testResult);
            System.out.println("Test result updated for " + patient.userName);
        }
        
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
