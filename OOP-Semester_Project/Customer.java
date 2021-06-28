package hotelManagementSystem;

import java.io.Serializable;
import java.util.Objects;
//making the class abstract because of the abstract method method in it
public abstract class   Customer implements Serializable { // serializing the parent class will serialize all the child classes . we serialized the class to convert it into a byte stream

   //making data fields of parent class protected so could be accessed by the subclasses
    protected  String name;
    protected int age;
    protected String address;
    protected String city;
    protected String province;
    protected String country;
    protected long phoneNumber;

    public Customer(String name, int age, String address, String city, String province, String country, long phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Customer)) return false;
        Customer customer = (Customer) o;
        return age == customer.age && phoneNumber == customer.phoneNumber && Objects.equals(name, customer.name) && Objects.equals(address, customer.address) && Objects.equals(city, customer.city) && Objects.equals(province, customer.province) && Objects.equals(country, customer.country);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
              //making an abstract method of booking details
    public abstract void showBookingDetails();
}
