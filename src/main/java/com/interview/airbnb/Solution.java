package com.interview.airbnb;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner scanner = new Scanner(System.in);

        // iterator each next line
        String next = "";
        while ((next = scanner.nextLine()) != null) {
            // call parseCSV function to get Person class for single person
            Person re = parseCSV(next);
            System.out.println(String.format("%s, %s years old, is from %s and is interested in %s.", re.firstName, re.age, re.city, re.interests));
        }
    }


    // To define a single person from one csv line
    static class Person {
        String firstName;
        String age;
        String city;
        String interests;
    }

    // parse CSV to Person
    public static Person parseCSV(String str) {
        ArrayList<String> res = new ArrayList<>();

        // decide if there is quote
        boolean inQuote = false;

        StringBuilder buffer = new StringBuilder();

        // go through the line
        for (int i = 0; i < str.length(); i++) {

            if (inQuote) {  // info inside quote
                if (str.charAt(i) == '"') {

                    if (str.charAt(i + 1) == '"') {
                        buffer.append('"');
                        i++;
                    } else {
                        res.add(buffer.toString());
                        buffer.setLength(0);
                        inQuote = false;
                        i++;
                    }
                } else
                    buffer.append(str.charAt(i));

            } else { // info out of quote

                if (str.charAt(i) == '"') {
                    inQuote = true;
                } else if (str.charAt(i) == ',') {
                    res.add(buffer.toString());
                    buffer.setLength(0);
                } else
                    buffer.append(str.charAt(i));

            }

        }

        // get the last info if they are not in the list
        if (buffer.length() > 0)
            res.add(buffer.toString());

        return convertPersonFromList(res);

    }

    // convert person from arraylist
    private static Person convertPersonFromList(ArrayList<String> personInfo) {
        Person p = new Person();
        p.firstName = personInfo.get(0);
        p.age = personInfo.get(6);
        p.city = personInfo.get(5);
        p.interests = personInfo.get(3);

        return p;
    }

}