package homework1;

import java.util.Comparator;

public class Entry implements Comparable<Entry> {
    // Data attributes
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
        return "Name: " + name + '\n' +
                "Street address: " + streetAddress + '\n' +
                "City: " + city + '\n' +
                "Postal code: " + postCode + '\n' +
                "Country: " + country + '\n' +
                "Phone number: " + phoneNumber + '\n';
    }

    // Static inner classes for comparators
    public static class NameComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class StreetAddressComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getStreetAddress().compareTo(o2.getStreetAddress());
        }
    }

    public static class CityComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getCity().compareTo(o2.getCity());
        }
    }

    public static class PostCodeComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getPostCode().compareTo(o2.getPostCode());
        }
    }

    public static class CountryComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getCountry().compareTo(o2.getCountry());
        }
    }

    public static class PhoneNumberComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
        }
    }

    // Method to get comparator based on attribute name
    public static Comparator<Entry> getComparator(String attribute) {
        switch (attribute.toLowerCase()) {
            case "name":
                return new NameComparator();
            case "streetaddress":
                return new StreetAddressComparator();
            case "city":
                return new CityComparator();
            case "postcode":
                return new PostCodeComparator();
            case "country":
                return new CountryComparator();
            case "phonenumber":
                return new PhoneNumberComparator();
            default:
                throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }
}
