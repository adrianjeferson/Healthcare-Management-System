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

        // Validate ID input
        String id;
        while (true) {
            System.out.print("\nID: ");
            id = scanner.nextLine();
            if (id.isEmpty()) {
                System.out.println("ID cannot be empty. Please try again.");
            } else {
                break;
            }
        }

        // Validate Name input
        String name;
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            } else if (!name.matches("[a-zA-Z\\s]+")) {
                System.out.println("Name can only contain letters and spaces. Please try again.");
            } else {
                break;
            }
        }

        // Validate Age input
        int age = -1;
        while (age < 0 || age > 150) {
            System.out.print("Age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 0 || age > 150) {
                    System.out.println("Age must be between 0 and 150. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for age.");
            }
        }

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

            //Role input validation
            String role = "";
            while (true) {
                System.out.print("Login as (Patient/Doctor/Nurse): ");
                role = scanner.nextLine().trim();

                // Validate the role input
                if (role.equalsIgnoreCase("Patient") || role.equalsIgnoreCase("Doctor") || role.equalsIgnoreCase("Nurse")) {
                    break;
                } else {
                    System.out.println("Invalid role. Please enter either 'Patient', 'Doctor', or 'Nurse'.");
                }
            }

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
                    System.out.println("3. Remove a patient");
                    System.out.println("4. Log-out");
                    System.out.print("Enter choice: ");
                    String choice = scanner.nextLine();

                    if (choice.equals("1")) {
                        // Add a new patient for the Doctor
                        // Validate ID input
                        String patientId;
                        while (true) {
                            System.out.print("Patient ID: ");
                            patientId = scanner.nextLine().trim();
                            if (patientId.isEmpty()) {
                                System.out.println("Patient ID cannot be empty. Please try again.");
                            } else {
                                break;
                            }
                        }

                        // Validate Name input
                        String patientName;
                        while (true) {
                            System.out.print("Patient Name: ");
                            patientName = scanner.nextLine().trim();
                            if (patientName.isEmpty()) {
                                System.out.println("Patient Name cannot be empty or just spaces. Please try again.");
                            } else if (!patientName.matches("[a-zA-Z\\s]+")) {
                                System.out.println("Patient Name can only contain letters and spaces. Please try again.");
                            } else {
                                break;
                            }
                        }

                        // Validate Age input
                        int patientAge = -1;
                        while (patientAge < 0 || patientAge > 150) {
                            System.out.print("Patient Age: ");
                            try {
                                patientAge = Integer.parseInt(scanner.nextLine());
                                if (patientAge < 0 || patientAge > 150) {
                                    System.out.println("Age must be between 0 and 150. Please try again.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number for the patient's age.");
                            }
                        }
                        Patient patient = new Patient(patientId, patientName, patientAge);
                        doctor.addPatient(patient);
                    } else if (choice.equals("2")) {
                        while (true) {
                            System.out.println("\n1. Choose from list");
                            System.out.println("2. Search for a patient");
                            System.out.println("3. Back");
                            System.out.print("Enter choice: ");
                            String mychoice=scanner.nextLine().trim();

                            Patient selectedPatient=null;

                            if(mychoice.equals("1")){
                                selectedPatient = doctor.choosePatient();
                            } else if (mychoice.equals("2")) {
                                selectedPatient = doctor.searchPatient(scanner);
                    
                                if (selectedPatient != null) {
                                    System.out.println("\nPatient found: " + selectedPatient.getUserName() + " (ID: " + selectedPatient.getUserID() + ")");
                                } else {
                                    continue;
                                }
                            } else if (mychoice.equals("3")){
                                break;
                            } else {
                                System.out.println("Invalid choice. Try again.");
                            }

                            if(selectedPatient!=null){
                                while (true) {
                                    System.out.println("\n1. Update Prescription");
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
                                            doctor.updatePrescription(selectedPatient);
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
                            }
                        }
                            
                            
                            
                    } else if(choice.equals("3")){
                        doctor.removePatient();
                    } else if(choice.equals("4")){
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
                    System.out.println("3. Remove a patient");
                    System.out.println("4. Log-out");
                    System.out.print("Enter choice: ");
                    String choice = scanner.nextLine();

                    if (choice.equals("1")) {
                        // Validate ID input
                        String patientId;
                        while (true) {
                            System.out.print("Patient ID: ");
                            patientId = scanner.nextLine().trim();
                            if (patientId.isEmpty()) {
                                System.out.println("Patient ID cannot be empty. Please try again.");
                            } else {
                                break;
                            }
                        }

                        // Validate Name input
                        String patientName;
                        while (true) {
                            System.out.print("Patient Name: ");
                            patientName = scanner.nextLine().trim();  // Trim spaces from the input
                            if (patientName.isEmpty()) {
                                System.out.println("Patient Name cannot be empty or just spaces. Please try again.");
                            } else if (!patientName.matches("[a-zA-Z\\s]+")) {
                                System.out.println("Patient Name can only contain letters and spaces. Please try again.");
                            } else {
                                break;
                            }
                        }

                        // Validate Age input
                        int patientAge = -1;
                        while (patientAge < 0 || patientAge > 150) {
                            System.out.print("Patient Age: ");
                            try {
                                patientAge = Integer.parseInt(scanner.nextLine());
                                if (patientAge < 0 || patientAge > 150) {
                                    System.out.println("Age must be between 0 and 150. Please try again.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid number for the patient's age.");
                            }
                        }
                        Patient patient = new Patient(patientId, patientName, patientAge);
                        nurse.addPatient(patient);
                    } else if (choice.equals("2")) {
                        // Choose an existing patient and display patient-specific actions
                        Patient selectedPatient = nurse.choosePatient();
                        if(selectedPatient!=null){
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
                        }
                    } else if(choice.equals("3")){
                        nurse.removePatient();
                    } else if(choice.equals("4")){
                        System.out.println("Logging out...");
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
