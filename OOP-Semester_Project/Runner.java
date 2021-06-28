package hotelManagementSystem;

import java.io.IOException;
public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HotelManager b=new HotelManager();
        b.readFile();
        Menu.displayMenu(b);


    }
}
