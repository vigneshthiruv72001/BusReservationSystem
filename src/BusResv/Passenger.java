package BusResv;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Passenger {
    public String name;
    public int age;
    public String gender;
    public String phone;

    public Passenger(String name, int age, String gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // Optional: Add toString() for display
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Phone: " + phone;
    }
}

