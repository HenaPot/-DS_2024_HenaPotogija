package homework3;

import java.util.Objects;

public class Entry implements Comparable<Entry> {
    // implement the relevant data attributes

    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(name, entry.name) &&
                Objects.equals(streetAddress, entry.streetAddress) &&
                Objects.equals(city, entry.city) &&
                Objects.equals(postcode, entry.postcode) &&
                Objects.equals(country, entry.country) &&
                Objects.equals(phoneNumber, entry.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, streetAddress, city, postcode, country, phoneNumber);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}