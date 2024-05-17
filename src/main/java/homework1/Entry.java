package homework1;

import java.util.Comparator;

public class Entry implements Comparable<Entry>, Comparator<Entry> {
    // implement the relevant data attributes
    private String name;
    private String streetAddress;
    private String city;
    private String postCode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String streetAddress, String city, String postCode, String country, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return  "Name: " + name + '\n' +
                "Street address: " + streetAddress + '\n' +
                "City: " + city + '\n' +
                "Postal code: " + postCode + '\n' +
                "Country: " + country + '\n' +
                "Phone number: " + phoneNumber + '\n'
                ;
    }

    @Override
    public int compare(Entry o1, Entry o2) {
        return 0;
    }
}