import java.util.*;

class PrescriptionManager {
    private List<Patient> patients;

    public PrescriptionManager() {
        this.patients = new ArrayList<>();
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
            patient.getPrescriptions().add(prescription);
            System.out.println(prescription + " added for " + patient.userName);
        } else if(choice.equals("2")){
            if (patient.getPrescriptions().isEmpty()) {
                System.out.println("\nNo prescriptions available for " + patient.getUserName());
                return;
            }
            while (true) {
                System.out.println("\nPrescriptions for " + patient.getUserName() + ":");
                for (String prescription : patient.getPrescriptions()) {
                    System.out.println("- " + prescription);
                }
                System.out.print("\nEnter prescription to delete for " + patient.getUserName() + " (type 1 to go back): ");
                String prescriptionToRemove = scanner.nextLine();

                if (patient.getPrescriptions().contains(prescriptionToRemove)) {
                    patient.getPrescriptions().remove(prescriptionToRemove); // Remove prescription
                    System.out.println(prescriptionToRemove + " deleted for " + patient.getUserName());
                    break; // Exit the loop once the prescription is successfully deleted
                } else if (prescriptionToRemove.equals("1")) {
                    break;
                }else {
                    System.out.println("\nPrescription not found. Please try again.");
                }
            }
        }
    }
}
