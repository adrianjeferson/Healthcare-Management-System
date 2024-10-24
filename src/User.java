class User {
    protected String userID;
    protected String userName;
    protected int userAge;

    // Constructor
    public User(String userID, String userName, int userAge) {
        this.userID = userID;
        this.userName = userName;
        this.userAge = userAge;
    }

    public void viewDetails() {
        System.out.println("ID: " + userID);
        System.out.println("Name: " + userName);
        System.out.println("Age: " + userAge);
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }
}
