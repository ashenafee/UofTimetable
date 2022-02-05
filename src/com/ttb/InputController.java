package com.ttb;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class InputController {
    private Scanner scn = new Scanner(System.in);

    public ArrayList<Course> courseInput() {
        // Lookup course code in database
        CourseLookup lookup = new CourseLookup(scn.nextLine());
        JSONObject course = lookup.getJson();

        // Parse information
        InformationParser parser = new InformationParser(course);
        ArrayList<Course> courses = parser.getCourseList();
        return courses;
    }

    public Course offeringInput(ArrayList<Course> courses) {
        return courses.get(scn.nextInt() - 1);
    }
}
