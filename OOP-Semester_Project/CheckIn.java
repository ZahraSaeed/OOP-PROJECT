package hotelManagementSystem;

public final class CheckIn extends Booking  { // we don't need to make child classes of check in, so its final

    private  int noOfAdults;
    private int noOfKids;

    public CheckIn(String name, int age, String address, String city, String province, String country, long phoneNumber, String email, String roomType, int noOfDays, String payment, String date, int noOfAdults, int noOfKids) {
        super(name,  phoneNumber, email, roomType, noOfDays, payment, date);
        super.setName(name);
        super.setAge(age);
        super.setCity(city);
        super.setProvince(province);
        super.setCountry(country);
        super.setAddress(address);
        this.noOfAdults = noOfAdults;
        this.noOfKids = noOfKids;
    }

    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public int getNoOfAdults() {
        return noOfAdults;
    }

    public int getNoOfKids() {
        return noOfKids;
    }

    public void setNoOfKids(int noOfKids) {
        this.noOfKids = noOfKids;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                ", name='" + name + '\'' +
                "email='" + email + '\'' +
                ", roomType='" + roomType + '\'' +
                ", noOfDays=" + noOfDays +
                ", date=" + date +
                ", payment=" + payment +
                ", noOfAdults=" + noOfAdults +
                ", noOfKids=" + noOfKids +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof CheckIn)) return false; // if  i is not instance of Check in, it means it is an instance of some other class, so we can't compare some other class with instance of Check in.
        CheckIn checkIn = (CheckIn) o;
        return noOfAdults == checkIn.noOfAdults && noOfKids == checkIn.noOfKids && date.equals(checkIn.date);
    }


    public void checkInDetails(){ //creating a check In method to call it in seeCheckIn method of  hotelManager class
        System.out.println("------------------------------------");
        System.out.println("|Name: \t" + getName() + "|");
        System.out.println("|Age : \t" +getAge() + "|");
        System.out.println("|Address:\t" + getAddress() + "|");
        System.out.println("|City :\t" +getCity() + "|");
        System.out.println("|Province:\t" + getProvince() + "|");
        System.out.println("|Country: \t" + getCountry() + "|");

        System.out.println("|Phone Number:\t" +getPhoneNumber() + "|");
        System.out.println("|Email Address:\t" +getEmail() + "|");
        System.out.println("|no of Adults:\t" +getNoOfDays() + "|");
        System.out.println("|no of Kids :\t" +getNoOfKids() + "|");
        System.out.println("|Room type:\t" +getRoomType() + "|");
        System.out.println("|No of days you want to stay:\t" +getNoOfDays() + "|");

        System.out.println("Check In date:\t" + getDate() + "|");
    }

}
