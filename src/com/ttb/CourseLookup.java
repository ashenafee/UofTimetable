package com.ttb;

import org.json.JSONObject;

public class CourseLookup {

    private InformationGrabber grabber;

    public CourseLookup(String query) {
        this.grabber = new InformationGrabber("https://timetable.iit.artsci.utoronto.ca/api/20219/courses?org=&code=" + query);
    }

    public JSONObject getJson() {
        return this.grabber.grabJson();
    }
}
