package creational.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class Location implements Serializable {
    public String streetAddress, city, country;

    public Location(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class User implements Serializable {
    public String name;
    public Location address;

    public User(String name, Location address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

public class SerializationApproach {
    public static void main(String[] args) {
        User user1 = new User("Ray", new Location("street", "city", "country"));
        User user2 = SerializationUtils.roundtrip(user1);

        user2.name = "Hebrew";
        user2.address.city = "city2";

        System.out.println(user1);
        System.out.println(user2);
    }
}
