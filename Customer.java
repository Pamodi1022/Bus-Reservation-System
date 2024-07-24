public class Customer {
    private String name;
    private String mobileNumber;
    private String emailID;
    private String city;
    private int age;

    public Customer(String name, String mobileNumber, String emailID, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailID = emailID;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Email ID: " + emailID);
        System.out.println("City: " + city);
        System.out.println("Age: " + age);
    }
}
