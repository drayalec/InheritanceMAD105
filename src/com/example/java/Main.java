package com.example.java;
import java.util.Scanner;
import java.text.NumberFormat;

class Customer {

    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private double squareFootage;

    public Customer(String customerName, String customerPhone, String customerAddress, double squareFootage) {

        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.squareFootage = squareFootage;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }
}


    class Commercial extends Customer {

        private boolean multi_property;
        private String property_name;
        private double commercial_rate = 5;

        public Commercial(String customerName, String customerPhone, String customerAddress, double squareFootage, boolean multi_property, String property_name) {
            super(customerName, customerPhone, customerAddress, squareFootage);
            this.multi_property = multi_property;
            this.property_name = property_name;
        }


        public void Calculate_pay() {

            if (multi_property) {

                double property_discount = ((getSquareFootage() / 1000) * commercial_rate) * 0.1;
                double weekly_pay = ((getSquareFootage() / 1000) * commercial_rate) - property_discount;

                NumberFormat nF = NumberFormat.getNumberInstance();

                nF.setGroupingUsed(true);  //puts a comma every 3 digits
                nF.setMaximumFractionDigits(2); //max and min number of decimal places set to 2
                nF.setMinimumFractionDigits(2);

                String formatted_pay = nF.format(weekly_pay);
                System.out.println("Weekly Cost:  $" + formatted_pay);

            }

            else {
                double weekly_pay = ((getSquareFootage()/ 1000) * commercial_rate);

                NumberFormat nF = NumberFormat.getNumberInstance();

                nF.setGroupingUsed(true);  //puts a comma every 3 digits
                nF.setMaximumFractionDigits(2); //max and min number of decimal places set to 2
                nF.setMinimumFractionDigits(2);

                String formatted_pay = nF.format(weekly_pay);
                System.out.println("Weekly Cost:  $" + formatted_pay);
            }
        }
        public void Print_Info(){
            System.out.println("Customers Info:");
            System.out.println();
            System.out.println("Name:  " + getCustomerName());
            System.out.println("Address:  " + getCustomerAddress());
            System.out.println("Phone Number:  " + getCustomerPhone());
            System.out.println("Area of lawn:  " + getSquareFootage() +" feet");
            System.out.println("Name of property:   " + property_name);
            System.out.println("(True/False) Eligible for Multi-property discount?   " + multi_property);
        }
    }
    class Residential extends Customer {

        private boolean senior;
        double residential_rate = 6;

        public Residential(String customerName, String customerPhone, String customerAddress, double squareFootage, boolean senior) {
            super(customerName, customerPhone, customerAddress, squareFootage);
            this.senior = senior;
        }

        public void Calculate_pay() {

            if (senior) {

                double senior_discount = ((getSquareFootage()/ 1000) * residential_rate) * 0.15;
                double weekly_pay = ((getSquareFootage() / 1000) * residential_rate) - senior_discount;

                NumberFormat nF = NumberFormat.getNumberInstance();

                nF.setGroupingUsed(true);  //puts a comma every 3 digits
                nF.setMaximumFractionDigits(2); //max and min number of decimal places set to 2
                nF.setMinimumFractionDigits(2);

                String formatted_pay = nF.format(weekly_pay);
                System.out.println("Weekly Cost:  $" + formatted_pay);

            }

            else {
                double weekly_pay = ((getSquareFootage() / 1000) * residential_rate);
                //using numberformat to format number into a currency form

                NumberFormat nF = NumberFormat.getNumberInstance();

                nF.setGroupingUsed(true);  //puts a comma every 3 digits
                nF.setMaximumFractionDigits(2); //max and min number of decimal places set to 2
                nF.setMinimumFractionDigits(2);

                String formatted_pay = nF.format(weekly_pay);
                System.out.println("Weekly Cost:  $" + formatted_pay);
            }


        }

        public void Print_Info(){
            System.out.println("Customers Info:");
            System.out.println();
            System.out.println("Name:  " + getCustomerName());
            System.out.println("Address:  " + getCustomerAddress());
            System.out.println("Phone Number:  " + getCustomerPhone());
            System.out.println("Area of lawn:  " + getSquareFootage() +" feet");
            System.out.println("(True/False) Eligible for senior customer discount?   " + senior);
        }
    }







public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //creating input int and a while loop that will run until the input is changed.
        int input = 1;

        while (input == 1){
            System.out.println("1. Commercial");
            System.out.println("2. Residential");
            System.out.println("3. Exit");
            System.out.println();
            System.out.println("Please Enter Your Choice:");

            // Setting the users input equal to a variable used in case-break
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    //Calling commercial main method, and setting input to 2 to break while loop
                    Commercial();
                    input = 2;
                    break;
                case 2:
                    // Calling residential main method, and setting input to 2 to break while loop
                    Residential();
                    input = 2;
                    break;
                case 3:
                    System.out.println("Your session has ended..");
                    input = 2;
                    break;
                default:
                    System.out.println("Error: The input was invalid...");
                    break;
            }

        }
    }
    // Creating a commercial method that will use user input to construct an instance of the commercial class
    private static void Commercial(){
        //storing all users input into variables for use to create an instance of the commercial class
        Scanner scanner = new Scanner(System.in);
        boolean multi_property;
        System.out.println("Commercial Customer: ");
        System.out.println();
        System.out.println("Please Enter Full name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter Phone Number:  ");
        String phone_number = scanner.nextLine();
        System.out.println("Please enter street address:  ");
        String address = scanner.nextLine();
        System.out.println("Please enter area of yard in square feet: ");
        String square_feet = scanner.nextLine();
        double square_footage = Double.parseDouble(square_feet);
        System.out.println("(True/False) The customer owns more than one property: ");
        String property_discount = scanner.nextLine();
        System.out.println("Please enter the name of the property: ");
        String property_name = scanner.nextLine();

        //if the users input has a t as the first letter, the boolean variable will be set to true
        if (property_discount.substring(0,1).equalsIgnoreCase("t")){
            multi_property = true;

        }
        else {
            multi_property = false;
        }

        //creating an instance of the commercial class with the info gained from the user.
        Commercial user = new Commercial(name,phone_number,address,square_footage,multi_property,property_name);
        // printing the info and the pay by calling the methods build into the class
        user.Print_Info();
        user.Calculate_pay();


    }

    private static void Residential(){

        //storing all users input into variables for use to create an instance of the commercial class
        Scanner scanner = new Scanner(System.in);
        boolean senior;
        System.out.println("Residential Customer: ");
        System.out.println();
        System.out.println("Please Enter Full name: ");
        String name = scanner.nextLine();
        System.out.println("Please Enter Phone number: ");
        String phone_number = scanner.nextLine();
        System.out.println("Please enter address: ");
        String address = scanner.nextLine();
        System.out.println("Please enter area of yard in square feet: ");
        String square_feet = scanner.nextLine();
        double square_footage = Double.parseDouble(square_feet);
        System.out.println("(True/False) The customer is a senior customer: ");
        String senior_discount = scanner.nextLine();


        if (senior_discount.substring(0,1).equalsIgnoreCase("t")){
            senior = true;

        }
        else {
            senior = false;
        }

        //creating an instance of the Residential class with the info gained from the user.
        Residential user = new Residential(name,phone_number,address,square_footage,senior);
        // printing the info and the pay by calling the methods build into the class
        user.Print_Info();
        user.Calculate_pay();



    }
}