package hotelManagementSystem;
import java.util.Date;
import java.util.Objects;


public class Booking  extends Customer { //since parent class serializable, child class will be serializable by default
    protected String email;
    protected String roomType;
    protected int noOfDays;
    public final static long paymentDeluxe=3000;  //declaring deluxe ,Executive suite payments final since it wont be changed
    public final static long paymentExecutive =5000;
    protected long payment;
    protected String date;


    public Booking(String name, long phoneNumber, String email, String roomType, int noOfDays, String payment, String date) {
        super(); super.setName(name);super.setPhoneNumber(phoneNumber); //using name and phoneNumber from parent class
        this.email = email;
        this.roomType = roomType;
        this.noOfDays = noOfDays;
        setPayment(payment); // setting the payment method in constructor
        this.date = date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "email='" + email + '\'' +
                ", roomType='" + roomType + '\'' +
                ", noOfDays=" + noOfDays +
                ", date=" + date +
                ", payment=" + payment +
                ", name='" + name + '\'' +
                '}';    }



    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public long getPayment() {
        return payment;
    }
//making a method of setting payment which will set the payment by using final data fields
    public void setPayment(String x)
    {
        if(x.equals("Deluxe")) {
            payment = paymentDeluxe;
        }
        else    {
            payment = paymentExecutive;
        }
    }
    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return noOfDays == booking.noOfDays && payment == booking.payment && Objects.equals(email, booking.email) && Objects.equals(roomType, booking.roomType) && Objects.equals(date, booking.date);
    }




//using the abstract method from Customer class and declaring its body to use it further
    @Override
    public void showBookingDetails() {
        System.out.println("|Name: \t" +getName() + "|");
        System.out.println("|Phone Number:\t" + getPhoneNumber() + "|");
        System.out.println("|Email Address:\t" + getEmail() + "|");
        System.out.println("|Check In date:\t" + getDate() + "|");
        System.out.println("Payment:\t" +getPayment() + "|");
    }
}