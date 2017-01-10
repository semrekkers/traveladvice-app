package com.semrekkers.traveladvice;

/**
 * Created by Sem Rekkers on 9-1-2017.
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * ReisAdviesItem item
 * @see <a href="https://opendata.rijksoverheid.nl/v1/sources/rijksoverheid/infotypes/traveladvice?output=json">https://opendata.rijksoverheid.nl/v1/sources/rijksoverheid/infotypes/traveladvice?output=json</a>
 */
public class ReisAdviesItem implements Serializable {
    public String Id;
    public String Type;
    public String Canonical;
    public String DataURL;
    public String Title;
    public String Introduction;
    public String Location;
    public String LastModified;
    public Date ParsedLastModified;

    public ReisAdviesItem(String id, String type, String dataURL, String title, String introduction, String location, String lastModified) {
        this.Id = id;
        this.Type = type;
        this.DataURL = dataURL;
        this.Title = title;
        this.Introduction = introduction;
        this.Location = location;
        this.LastModified = lastModified;
    }

    public ReisAdviesItem(JSONObject obj) throws JSONException, ParseException {
        this.Id = obj.getString("id");
        this.Type = obj.getString("type");
        this.Canonical = obj.getString("canonical");
        this.DataURL = obj.getString("dataurl");
        this.Title = obj.getString("title");
        this.Introduction = obj.getString("introduction");
        this.Location = obj.getString("location");
        this.LastModified = obj.getString("lastmodified");
        this.ParsedLastModified = Helper.parseISO8601(this.LastModified);
    }

    public static ArrayList<ReisAdviesItem> getDummyData() {
        ArrayList<ReisAdviesItem> data = new ArrayList<>();

        final String TYPE = "reisadvies";
        final String TITLE_PREFIX = "Reisadvies ";

        final String DUMMY_NL = "Nederland";
        final String DUMMY_BE = "België";
        final String DUMMY_DE = "Duitsland";
        final String DUMMY_UK = "Verenigd Koninkrijk";

        data.add(new ReisAdviesItem(null, TYPE, null, TITLE_PREFIX + DUMMY_NL, null, DUMMY_NL, "2016-01-10T09:55:02.000Z"));
        data.add(new ReisAdviesItem(null, TYPE, null, TITLE_PREFIX + DUMMY_BE, null, DUMMY_BE, "2016-01-10T09:56:12.000Z"));
        data.add(new ReisAdviesItem(null, TYPE, null, TITLE_PREFIX + DUMMY_DE, null, DUMMY_DE, "2016-01-10T09:57:22.000Z"));
        data.add(new ReisAdviesItem(null, TYPE, null, TITLE_PREFIX + DUMMY_UK, null, DUMMY_UK, "2016-01-10T09:58:32.000Z"));

        return data;
    }
}
