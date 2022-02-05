package com.ttb;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class InformationGrabber {

    private String url;

    public InformationGrabber(String url) {
        this.url = url;
    }

    public JSONObject grabJson() {
        Document doc = null;
        // Grab information from this.url
        try {
            doc = Jsoup.connect(this.url).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Find the JSON data (as a string) containing information on the specified course
        String rawData = doc.getElementsByTag("body").get(0).text();

        // Convert <rawData> into JSON information
        return new JSONObject(rawData);
    }

}
