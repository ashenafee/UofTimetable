package com.ttb;

import java.util.ArrayList;
import java.util.HashMap;

public class Meeting {

    private String meetingId;
    // private ArrayList<String> meetingDayList = new ArrayList<>();
    private ArrayList<HashMap<String, String>> meetingDayList = new ArrayList<>();
    private String meetingStart;
    private String meetingEnd;
    private String meetingRoom;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public ArrayList<HashMap<String, String>> getMeetingDayList() {
        return meetingDayList;
    }

    public void addMeetingDay(HashMap<String, String> meetingDay) {
        this.meetingDayList.add(meetingDay);
    }

    public String getMeetingStart() {
        return meetingStart;
    }

    public void setMeetingStart(String meetingStart) {
        this.meetingStart = meetingStart;
    }

    public String getMeetingEnd() {
        return meetingEnd;
    }

    public void setMeetingEnd(String meetingEnd) {
        this.meetingEnd = meetingEnd;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}
