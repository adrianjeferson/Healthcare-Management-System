import java.util.*;

class Patient extends User implements UserOperations{
    protected List<String> testResults;
    protected List<String> prescriptions;
    protected double billingInfo;
    protected List<String> schedule;

    public Patient(String userID, String userName, int userAge) {
        super(userID, userName, userAge);
        this.testResults = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.schedule = new ArrayList<>();
        this.billingInfo = 0.0;
    }

    @Override
    public void viewDetails() {
        System.out.println("\nPatient Details: ");
        super.viewDetails();
    }

    @Override
    public void greetings() {
        System.out.println("\nHello, "+userName+"!");
    }

    public List<String> getPrescriptions() {
        return prescriptions;
    }
    
    public List<String> getSchedule() {
        return schedule;
    }

    public void viewTestResults(){
        System.out.println(userName +"'s Test Results: " + testResults);
    }

    public void viewPrescriptions() {
        System.out.println(userName + "'s Prescriptions: " + prescriptions);
    }

    public void viewBillingInfo(){
        System.out.println(userName + "'s Billing Information: " + billingInfo);
    }

    public void viewSchedule(){
        System.out.println(userName + "'s Schedule: " + schedule);
    }
}
