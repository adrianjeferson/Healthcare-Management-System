import java.util.*;

public class Medical_InformationSystem {

    /**
     * Logs in a user based on their role (Patient, Doctor, or Nurse).
     * Prompts for the user's ID, Name, and Age, and returns the corresponding user object.
     *
     * role The role of the user (Patient, Doctor, or Nurse).
     * throws IllegalArgumentException if an invalid role is provided.
     */
    public static User login(String role) {
        Scanner scanner = new Scanner(System.in);

        // Gather user information (ID, Name, and Age)
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Create and return the appropriate user based on the role
        if (role.equalsIgnoreCase("Patient")) {
            return new Patient(id, name, age);
        } else if (role.equalsIgnoreCase("Doctor")) {
            return new Doctor(id, name, age);
        } else if (role.equalsIgnoreCase("Nurse")) {
            return new Nurse(id, name, age);
        } else {
            throw new IllegalArgumentException("Invalid role");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            // Welcome message for the system
            System.out.println("Welcome to the Medical Information System");
    
            // Prompt the user for their role
            System.out.print("Login as (Patient/Doctor/Nurse): ");
            String role = scanner.nextLine();
    
            // Call login method to authenticate the user
            User user = login(role);
    
            // Handle actions for Patient users
            if (user instanceof Patient) {
                Patient patient = (Patient) user;
                while (true) {
                    // Display available options for the Patient
                    System.out.println("\n1. View Test Results");
                    System.out.println("2. View Prescriptions");
                    System.out.println("3. View Billing Info");
                    System.out.println("4. View Schedule");
                    System.out.println("5. Log-out");
                    System.out.print("Enter choice: ");
                    String choice = scanner.nextLine();
    
                    // Execute the action based on the choice
                    switch (choice) {
                        case "1":
                            patient.viewTestResults();
                            break;
                        case "2":
                            patient.viewPrescriptions();
                            break;
                        case "3":
                            patient.viewBillingInfo();
                            break;
                        case "4":
                            patient.viewSchedule();
                            break;
                        case "5":
                            System.out.println("Logging out...");
                            System.out.println();
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    if(choice.equals("5")){
                        break;
                    }
                }
            }
            // Handle actions for Doctor users
            else if (user instanceof Doctor) {
                Doctor doctor = (Doctor) user;
                while (true) {
                    // Display available options for the Doctor
                    System.out.println("\n1. Add Patient");
                    System.out.println("2. Choose Patient");
                    System.out.println("3. Log-out");
                    System.out.print("Enter choice: ");
                    String choice = scanner.nextLine();
    
                    if (choice.equals("1")) {
                        // Add a new patient for the Doctor
                        System.out.print("Patient ID: ");
                        String patientId = scanner.nextLine();
                        System.out.print("Patient Name: ");
                        String patientName = scanner.nextLine();
                        System.out.print("Patient Age: ");
                        int patientAge = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        Patient patient = new Patient(patientId, patientName, patientAge);
                        doctor.addPatient(patient);
                    } else if (choice.equals("2")) {
                        try {
                            // Choose an existing patient and display patient-specific actions
                            Patient selectedPatient = doctor.choosePatient();
                            while (true) {
                                System.out.println("\n1. Create Prescription");
                                System.out.println("2. Update Test Result");
                                System.out.println("3. View Test Results");
                                System.out.println("4. View Prescriptions");
                                System.out.println("5. Compute Billing");
                                System.out.println("6. Schedule Appointment");
                                System.out.println("7. Back");
                                System.out.print("Enter choice: ");
                                String subChoice = scanner.nextLine();
    
                                // Execute the action based on the choice
                                switch (subChoice) {
                                    case "1":
                                        doctor.createPrescription(selectedPatient);
                                        break;
                                    case "2":
                                        doctor.updateTestResult(selectedPatient);
                                        break;
                                    case "3":
                                        doctor.viewTestResults(selectedPatient);
                                        break;
                                    case "4":
                                        doctor.viewPrescriptions(selectedPatient);
                                        break;
                                    case "5":
                                        doctor.computeBilling(selectedPatient);
                                        break;
                                    case "6":
                                        doctor.scheduleAppointment(selectedPatient);
                                        break;
                                    case "7":
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                                if(subChoice.equals("7")){
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // Handle case where a non-existing patient is selected
                            e.printStackTrace();
                            System.out.println("Non existing Patient!");
                        }
                    } else if(choice.equals("3")){
                        System.out.println("Logging out...");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Invalid choice");
                    }
                }
            }
            // Handle actions for Nurse users
            else if (user instanceof Nurse) {
                Nurse nurse = (Nurse) user;
                while (true) {
                    // Display available options for the Nurse
                    System.out.println("\n1. Add Patient");
                    System.out.println("2. Choose Patient");
                    System.out.println("3. Log-out");
                    System.out.print("Enter choice: ");
                    String choice = scanner.nextLine();
    
                    if (choice.equals("1")) {
                        // Add a new patient for the Nurse
                        System.out.print("Patient ID: ");
                        String patientId = scanner.nextLine();
                        System.out.print("Patient Name: ");
                        String patientName = scanner.nextLine();
                        System.out.print("Patient Age: ");
                        int patientAge = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        Patient patient = new Patient(patientId, patientName, patientAge);
                        nurse.addPatient(patient);
                    } else if (choice.equals("2")) {
                        try {
                            // Choose an existing patient and display patient-specific actions
                            Patient selectedPatient = nurse.choosePatient();
                            while (true) {
                                System.out.println("\n1. View Test Results");
                                System.out.println("2. View Prescriptions");
                                System.out.println("3. Compute Billing");
                                System.out.println("4. Schedule Appointment");
                                System.out.println("5. Back");
                                System.out.print("Enter choice: ");
                                String subChoice = scanner.nextLine();
    
                                // Execute the action based on the choice
                                switch (subChoice) {
                                    case "1":
                                        nurse.viewTestResults(selectedPatient);
                                        break;
                                    case "2":
                                        nurse.viewPrescriptions(selectedPatient);
                                        break;
                                    case "3":
                                        nurse.computeBilling(selectedPatient);
                                        break;
                                    case "4":
                                        nurse.scheduleAppointment(selectedPatient);
                                        break;
                                    case "5":
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                                if (subChoice.equals("5")){
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            // Handle case where a non-existing patient is selected
                            e.printStackTrace();
                            System.out.println("Non existing Patient!");
                        }
                    } else if (choice.equals("3")) {
                        System.out.println("Logging-out...");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Invalid choice");
                    }
                }
            }
        }
    }
}
