package hotelManagementSystem;

import java.util.Scanner;

public class Menu {

    public static void displayMenu(HotelManager hotelManager)  { // we made it static because,we don't need an instance to access it
        while (true) {
            Scanner scanner=new Scanner(System.in);
            int command = 0;
            while (true) {
                try {
                    System.out.println(" ___________________________________________");
                    System.out.println("|              Hello there!!                |");
                    System.out.println("|            Enter your choice              |");
                    System.out.println("|___________________________________________|");
                    System.out.println("|  Book a room           " + "    Press 1    |");
                    System.out.println("|  Check in              " + "    Press 2    |");
                    System.out.println("|  Cancel Booking        " + "    Press 3    |");
                    System.out.println("|  See Booking Details   " + "    Press 4    |");
                    System.out.println("|  See Check In Details   " + "   Press 5    |");
                    System.out.println("|  See all booking Details " + "   Press 6   |");
                    System.out.println("|  See all Check In Details   " + "Press 7   |");
                    System.out.println("|  Check Out                " + "  Press 8   |");
                    System.out.println("|  See all Check Out Details  " + "Press 9   |");
                    System.out.println("|_________________________________________|");


                    String line = scanner.nextLine();
                    command = Integer.parseInt(line);
                    break;
                } catch (Exception e) { //It prevents the code from crashing, in case user enters an invalid value
                    System.out.println("invalid input, try agaon");
                }
            }
            switch (command) {
                case 1: {
                    hotelManager.makeBooking();
                    break;
                }
                case 2: {
                    hotelManager.checkIn();
                    break;
                }
                case 3: {
                    hotelManager.cancelBooking();
                    break;
                }
                case 4: {
                    hotelManager.seeBookingDetails();
                    break;
                }
                case 5:{
                    hotelManager.showCheckInDetails();
                    break;
                }
                case 6:{
                    hotelManager.showAllBookings();
                    break;
                }
                case 7:{
                    hotelManager.showAllCheckIn();
                    break;
                }
                case  8:{
                    hotelManager.checkOut();
                    break;
                }
                case 9 :{
                    hotelManager.showAllCheckouts();
                    break;
                }
                default:
                    System.out.println("Wrong command");
            }
        }


    }








}
