package hotelManagementSystem;

import java.util.Objects;

public final class CheckOut extends  Booking{ // child classes of checkOut are not required so declaring it final
    private String dues;
    public CheckOut(String name, long phoneNumber, String roomType, int noOfDays, String payment,String email, String date,String charges) {
        super(name,phoneNumber,email,roomType,noOfDays,payment,date);
        super.setName(name);
        super.setPhoneNumber(phoneNumber);
        super.setEmail(email);
        super.setRoomType(roomType);
        super.setNoOfDays(noOfDays);
        super.setDate(date);
        this.dues =charges;
    }




    public String getDues() {
        return dues;
    }

    public void setDues(String dues) {
        this.dues = dues;
    }

    @Override
    public String toString() {

        return "CheckOut{" +
                ", roomType='" + roomType + '\'' +
                ", noOfDays=" + noOfDays +
                ", payment=" + payment +
                ", date='" + date + '\'' +
                ", charges='" + dues + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !( o instanceof Customer)) return false;

        CheckOut checkOut = (CheckOut) o;
        return Objects.equals(dues, checkOut.dues);
    }

  public  void  seeCheckoutDetails(){
      System.out.println("|Name: \t" +getName() + "|");
      System.out.println("|Phone Number:\t" + getPhoneNumber() + "|");
      System.out.println("|Check In date:\t" + getDate() + "|");
      System.out.println("Payment:\t" +getPayment() + "|");
      System.out.println("Extra Dues:\t"+ getDues()+"|");
  }
}
