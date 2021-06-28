package hotelManagementSystem;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelManager implements BookingMethods,CheckInMethods {
    int numberOfRoomsAvailable;
    ArrayList<Booking> bk;
    ArrayList<CheckIn> ck;
    ArrayList<CheckOut> co;
    private transient static Scanner scanner;//Scanner classes doesn't implements Serializable interface. So  declaring it  it is not included while writing the object into a file


    File file; //creating an instance of File class

    //without argument constructor using it to declare the default values
    public HotelManager() {
        bk = new ArrayList<>();
        ck = new ArrayList<>();
        co = new ArrayList<>();
        scanner = new Scanner(System.in);
        numberOfRoomsAvailable = 10;
        file = new File("information.txt");
    }

    //argument constructor
    public HotelManager(int numberOfRoomsAvailable) {
        bk = new ArrayList<>();
        ck = new ArrayList<>();
        scanner = new Scanner(System.in);
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
        file = new File("information.txt");

    }



//                          ________________________methods____________________

    //                                                1.BOOKING
    public void makeBooking() {


        if (bk.size() == numberOfRoomsAvailable) {
            System.out.println("sorry no room is available");
            return;
        }

        System.out.println("Name: ");

        String input;
        String name = scanner.nextLine();
        String email = null, roomType, payment = null, date = null;
        int noOfDays;
        long phonenumber = 0;
        Matcher matcher = null;
        while (phonenumber==0l) {
            System.out.println("Phone Number: ");
            input = scanner.nextLine();

            //             ---------------validating phone number----------
            Pattern pattern = Pattern.compile("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$");
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Phone Number Valid");
                Long input2 = Long.parseLong(input);
                phonenumber = input2;
            }else System.out.println("Invalid entry. try again");
        }


        while (email==null) {
            System.out.println("Phone Email: ");
            input = scanner.nextLine();
//      -------------------------------------- Validating Email------------------------------------------
            String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
            matcher = emailPat.matcher(input);
            if (matcher.matches()) {
                System.out.println("Email is correct");
                email = input;
            } else System.out.println("Invalid entry. try again");
        }
        ;


        System.out.println(" _______________________________________");
        System.out.println("|       Type your room type             |");
        System.out.println("|_______________________________________|");
        System.out.println("| 1.Deluxe Suite             Rs.3000    |");
        System.out.println("| 2.Executive Suite          Rs.5000    |");
        System.out.println("|_______________________________________|");


        input = scanner.nextLine();
        roomType = input;


        System.out.println("How many days you want to stay:");
        input = scanner.nextLine();
        int days = Integer.parseInt(input);
        noOfDays = days;


        System.out.println(" ______________________________________________");
        System.out.println("|   press 1 if you want to confirm Deluxe Suit |");
        System.out.println("|   press 2 if you want to confirm Executve  Suit |");
        System.out.println("|______________________________________________|");


        input = scanner.nextLine();

        Long confirm = Long.parseLong(input);
        if (confirm == 1) {
            payment = "Deluxe";
        } else {
            payment = "Executive"; // the payment will be executive by default
        }


        System.out.println("Enter Date of Check In :  ");
        System.out.println("format : dd-mm-yy (for example, 21-06-21 )");
        Date date1;
        input = scanner.nextLine();
        while (true) {
            try {
                date1 = new SimpleDateFormat("mm-dd-yy").parse(input);
                date = date1.toString();
                break;
            } catch (ParseException parseException) {
                System.out.println("You have to enter in mm-dd-yy format");
            }
        }


        System.out.println("");
        System.out.println("  YOUR BOOKING HAS BEEN CONFIRMED ");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Booking booking = new Booking(name, phonenumber, email, roomType, noOfDays, payment, date);
        bk.add(booking);
        updateFile();

    }
    public void seeBookingDetails() {
        System.out.println("enter your name:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (Booking b : bk) {
            if (b.getName().equals(input)) {
                System.out.println("------------------------------------");
                b.showBookingDetails();
                return;
            }
        }
        System.out.println("Booking doesn't exisit");

    }
    public void showAllBookings() {
        if (bk.size() > 0) {
            for (Booking b1 : bk) {
                b1.showBookingDetails();

            }
        } else System.out.println("No items to show");

    }
    public void cancelBooking() {
        System.out.println("Enter your Name :");
        String input = scanner.nextLine();

        for (Booking booking : bk) {
            if (booking.getName().equals(input)) {
                {
                    bk.remove(booking);
                    updateFile();
                    return;
                }


            }

        }
        System.out.println("No such booking exists");
        return;
    }

   //                                               2.CHECK-IN
    public void checkIn() {

        System.out.println("                                                       ");

        System.out.println("________________________________________");
        System.out.println("|              CheckIn Form             |");
        System.out.println("|_______________________________________|");

        String name, roomType, address, city, province, country, email = null, payment = null, date=null;
        Long phoneNumber = 00000000l;
        int age, noOfDays, noOfAdults, noOfKids;


        System.out.println("Enter your Full Name :               ");
        String input = scanner.nextLine();
        name = input;

        while (true) {
            try {
                System.out.println("Enter your Age :");
                input = scanner.nextLine();
                age = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Invalid entry try again");
            }
        }

        ;


        System.out.println("Enter your Address  : ");
        input = scanner.nextLine();
        address = input;

        System.out.println("Enter  City : ");
        input = scanner.nextLine();
        city = input;
        System.out.println("Enter  Province  : ");
        input = scanner.nextLine();
        province = input;

        System.out.println("Enter  Country : ");
        input = scanner.nextLine();
        country = input;


        Matcher matcher = null;
        while (phoneNumber==0l) {
            System.out.println("Enter  Phone Number");
            input = scanner.nextLine();
//                   ---------------validating phone number----------


            Pattern pattern = Pattern.compile("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$");
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Phone Number Valid");
                phoneNumber = Long.parseLong(input);

            }else System.out.println("Invalid entry. try again");
        }


        while (email==null) {
            System.out.println("Enter your email address");
            input = scanner.nextLine();
//                                    EMAIL VALIDATION

            String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
            matcher = emailPat.matcher(input);
            if (matcher.matches()) {
                System.out.println("Email is correct");
                email = input;
            }else System.out.println("Invalid entry. try again");
        }


        while (true) {
            try {
                System.out.println("Enter number of Adults:  ");
                input = scanner.nextLine();
                noOfAdults = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input try again");
            }
        }

        while (true) {
            try {
                System.out.println("Enter room type:  ");
                input = scanner.nextLine();
                roomType = input;
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input try again");
            }
        }
        while (true) {

            try {
                System.out.println("Enter number of kids:  ");

                input = scanner.nextLine();
                noOfKids = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid inpput");

            }

        }

        System.out.println(" ________________________________________________");
        System.out.println("|   press 1 if you want to confirm Deluxe   Suit |");
        System.out.println("|   press 2 if you want to confirm Executve Suit |");
        System.out.println("|________________________________________________|");


        input = scanner.nextLine();

        Long confirm = Long.parseLong(input);
        if (confirm == 1) {
            payment = "Deluxe";
        } else {
            payment = "Executive"; // the payment will be executive by default
        }

        while (true) {
            try {
                System.out.println("How many days you want to stay:");
                input = scanner.nextLine();
                noOfDays = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input try again");
            }
        }

        while (date==null) {
            System.out.println("Enter Date of Check In :  ");
            System.out.println("format : dd-mm-yy (for example, 21-06-21 )");
            Date date1;
            input = scanner.nextLine();
            try {
                date1 = new SimpleDateFormat("mm-dd-yy").parse(input);
                date = date1.toString();
            } catch (ParseException parseException) {
                System.out.println("You have to enter in mm-dd-yy format");
                return;
            }
        }


        System.out.println("Check In formed filled ");
        System.out.println("");
        System.out.println("");
        System.out.println("Proceed for Payment");
        System.out.println("");
        System.out.println("");

        CheckIn details = new CheckIn(name, age, address, city, province, country, phoneNumber, email, roomType, noOfDays, payment, date, noOfAdults, noOfKids);
        ck.add(details);
        updateFile();
    }
    public void showCheckInDetails() {

        System.out.println("Write your Name:  ");
        String input = scanner.nextLine();


        for (CheckIn checkIn : ck) {
            if (checkIn.getName().equals(input)) {

                checkIn.checkInDetails();

                return;

            }

        }
        System.out.println("checkIn details not Found");

    }
    public void showAllCheckIn() {
        if (ck.size() > 0) {
            for (CheckIn c1 : ck) {
                c1.checkInDetails();

            }
        } else System.out.println("No items to show");

    }
    //                                              3.CHECK-OUT
    public void checkOut(){

        String  roomType,email=null, payment = null, date = null;
        int noOfDays;
        long phonenumber = 0;
        System.out.println("Name: ");
        String input;
        String name = scanner.nextLine();

         Matcher matcher = null;

        while (phonenumber==0l) {
            System.out.println("Phone Number: ");
            input = scanner.nextLine();
            //             ---------------validating phone number----------
            Pattern pattern = Pattern.compile("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$");
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Phone Number Valid");
                Long input2 = Long.parseLong(input);
                phonenumber = input2;
            }else System.out.println("Invalid entry. try again");
        }



        while (email==null) {
            System.out.println("Enter your email address");
            input = scanner.nextLine();
//                                    EMAIL VALIDATION

            String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
            Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
            matcher = emailPat.matcher(input);
            if (matcher.matches()) {
                System.out.println("Email is correct");
                email = input;
            }else System.out.println("Invalid entry. try again");
        }

        System.out.println(" _______________________________________");
        System.out.println("|       Type your room type             |");
        System.out.println("|_______________________________________|");
        System.out.println("| 1.Deluxe Suite             Rs.3000    |");
        System.out.println("| 2.Executive Suite          Rs.5000    |");
        System.out.println("|_______________________________________|");


        input = scanner.nextLine();
        roomType = input;


        System.out.println(" days stayed at hotel :");
        input = scanner.nextLine();
        int days = Integer.parseInt(input);
        noOfDays = days;


        System.out.println(" ______________________________________________");
        System.out.println("|   press 1 if your  stay was at Deluxe Suit |");
        System.out.println("|   press 2 if your stay was at Executve  Suit |");
        System.out.println("|______________________________________________|");


        input = scanner.nextLine();

        Long confirm = Long.parseLong(input);
        if (confirm == 1) {
            payment = "Deluxe";
        } else {
            payment = "Executive"; // the payment will be executive by default
        }


        System.out.println("Enter Date of Check Out :  ");
        System.out.println("format : dd-mm-yy (for example, 21-06-21 )");
        Date date1;
        input = scanner.nextLine();
        while (true) {
            try {
                date1 = new SimpleDateFormat("mm-dd-yy").parse(input);
                date = date1.toString();
                break;
            } catch (ParseException parseException) {
                System.out.println("You have to enter in mm-dd-yy format");
            }
        }
        System.out.println("extra dues:");
        input=scanner.nextLine();
        String dues=input;

        System.out.println("");
        System.out.println("  CHECKED OUT COMPLETED  ");
        System.out.println("");
        System.out.println("");
        System.out.println("");
     CheckOut checkOut=new CheckOut(name,phonenumber,roomType,noOfDays,payment,email,date,dues);
        co.add(checkOut);
        updateFile();
    }
    public  void showAllCheckouts(){
        System.out.println();
            if(co.size()>0){
                for(CheckOut c1:co){
                     c1.seeCheckoutDetails();
                }
            }else System.out.println("....");

    }


    //                                              4.FILE
    public final void updateFile() { // we don't want to  override this methods  hence,we made it final

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bk);
            objectOutputStream.writeObject(ck);
            objectOutputStream.writeObject(co);
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public final void readFile() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

            bk = (ArrayList<Booking>) objectInputStream.readObject();
            ck = (ArrayList<CheckIn>) objectInputStream.readObject();
            co = (ArrayList<CheckOut>) objectInputStream.readObject();


        } catch (Exception e) {
            System.out.println("There is no previously saved data!");
        }

    }


 }




