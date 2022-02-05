package com.ttb;

import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class InformationParser {

    private final JSONObject json;
    private final ArrayList<Course> courseList;

    public InformationParser(JSONObject json) {
        this.json = json;
        this.courseList = new ArrayList<>();
        parseInformation();
    }

    public void parseInformation() {
        Set<String> courseOfferings = this.json.keySet();
        for (String courseOffering : courseOfferings) {
            Course course = new Course();

            parseCourses(courseOffering, course);
            parseMeetings(courseOffering, course);

            this.courseList.add(course);
        }
    }

    private void parseCourses(String courseOffering, Course course) {
        course.setCourseID((String) this.json.getJSONObject(courseOffering).get("courseId"));
        course.setOrg((String) this.json.getJSONObject(courseOffering).get("org"));
        course.setOrgName((String) this.json.getJSONObject(courseOffering).get("orgName"));
        course.setCourseTitle((String) this.json.getJSONObject(courseOffering).get("courseTitle"));
        course.setCode((String) this.json.getJSONObject(courseOffering).get("code"));
        course.setCourseDescription(Jsoup.parse((String) this.json.getJSONObject(courseOffering).get("courseDescription")).text());
        course.setPrerequisite((String) this.json.getJSONObject(courseOffering).get("prerequisite"));
        course.setSection((String) this.json.getJSONObject(courseOffering).get("section"));
        course.setSession((String) this.json.getJSONObject(courseOffering).get("session"));
    }

    private void parseMeetings(String courseOffering, Course course) {
        Set<String> meetingOfferings = this.json.getJSONObject(courseOffering).getJSONObject("meetings").keySet();
        // Add the items in meetingOfferings to the course's meeting list
        for (String meetingOffering : meetingOfferings) {
            JSONObject meetingJson = this.json.getJSONObject(courseOffering).getJSONObject("meetings").getJSONObject(meetingOffering);
            Set<String> meetingIDs = meetingJson.getJSONObject("schedule").keySet();

            Meeting meeting = new Meeting();

            meeting.setMeetingId(meetingOffering);
            for (String meetingID : meetingIDs) {
                JSONObject meetingDayJson = meetingJson.getJSONObject("schedule").getJSONObject(meetingID);

                String meetingDay = meetingDayJson.get("meetingDay").toString();
                String meetingStart = meetingDayJson.get("meetingStartTime").toString();
                String meetingEnd = meetingDayJson.get("meetingEndTime").toString();
                String meetingRoom = meetingDayJson.get("assignedRoom1").toString();

                HashMap<String, String> meetingDayMap = new HashMap<>();
                meetingDayMap.put("meetingDay", meetingDay);
                meetingDayMap.put("meetingStartTime", meetingStart);
                meetingDayMap.put("meetingEndTime", meetingEnd);
                meetingDayMap.put("assignedRoom1", meetingRoom);

                meeting.addMeetingDay(meetingDayMap);
            }
            course.addMeeting(meeting);
        }

    }

    public ArrayList<Course> getCourseList() {
        return this.courseList;
    }
}
