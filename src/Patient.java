import java.util.*;

class Patient extends User {
    protected List<String> testResults;
    protected List<String> prescriptions;
    protected double billingInfo;
    protected String schedule;

    public Patient(String userID, String userName, int userAge) {
        super(userID, userName, userAge);
        this.testResults = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.schedule = "";
        this.billingInfo = 0.0;
    }

    public void viewTestResults(){
        System.out.println(userName +"'s Test Results: " + testResults);
    }

    public void viewPrescriptions() {
        System.out.println("Your Prescriptions: " + prescriptions);
    }

    public void viewBillingInfo(){
        System.out.println("Your Billing Information: " + billingInfo);
    }

    public void viewSchedule(){
        System.out.println(userName + "'s Schedule" + schedule);
    }

    public void addTestResult(String testResult) {
        testResults.add(testResult);
    }

    public void removeTestResult(String testResult){
        testResults.remove(testResult);
    }

    public void addPrescription(String prescription) {
        prescriptions.add(prescription);
    }

    public void addBilling(double amount) {
        this.billingInfo += amount;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

}
