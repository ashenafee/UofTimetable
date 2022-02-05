package com.ttb;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandLine {
    public static void main(String[] args) {
        // Create Scanner object
        InputController ic = new InputController();

        // Ask for user to input their course code
        System.out.print("Enter the course code (e.g. CSC207):\t");
        ArrayList<Course> courses = ic.courseInput();

        // Print information
        System.out.println("\nCourse Information:");
        System.out.println("Name:\t\t\t" + courses.get(0).getCourseTitle());
        System.out.println("Description:\t" + courses.get(0).getCourseDescription());
        System.out.println("Prerequisites:\t" + courses.get(0).getPrerequisite());

        // Output course offerings
        System.out.println("\nCourse offerings:");
        for (Course c : courses) {
            System.out.println("[" + (courses.indexOf(c) + 1) + "]\t" + c.getCode() + "-" + c.getSection());
        }

        // Ask for user to input course offering
        System.out.print("Enter the course offering number (e.g. 1):\t");
        Course course = ic.offeringInput(courses);

        // Print course offerings
        System.out.println("\nSections for your selected offering:");
        ArrayList<Meeting> meeting = course.getMeetings();

        int i = 0;
        for (Meeting m : meeting) {
            ArrayList<HashMap<String, String>> meetingDayList = m.getMeetingDayList();
            System.out.println(m.getMeetingId());
            for (HashMap<String, String> meetingDay : meetingDayList) {
                System.out.println("\t" + meetingDay.get("meetingDay") + " " + meetingDay.get("meetingStartTime") + "-" + meetingDay.get("meetingEndTime"));
            }
        }
    }
}
