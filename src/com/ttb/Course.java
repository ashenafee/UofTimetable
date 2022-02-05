package com.ttb;

import java.util.ArrayList;

public class Course {

    private String courseID;
    private String org;
    private String orgName;
    private String courseTitle;
    private String code;
    private String courseDescription;
    private String prerequisite;
    private String section;
    private String session;
    private ArrayList<Meeting> meetings = new ArrayList<Meeting>();

    public void addMeeting(Meeting meeting) {
        this.meetings.add(meeting);
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public String getOrg() {
        return org;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCode() {
        return code;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public String getSection() {
        return section;
    }

    public String getSession() {
        return session;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSession(String session) {
        this.session = session;
    }

}
