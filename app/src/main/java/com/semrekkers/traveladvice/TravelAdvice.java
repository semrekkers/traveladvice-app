package com.semrekkers.traveladvice;

/**
 * Created by Sem Rekkers on 9-1-2017.
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 * TravelAdvice item
 * @see <a href="https://opendata.rijksoverheid.nl/v1/sources/rijksoverheid/infotypes/traveladvice?output=json">https://opendata.rijksoverheid.nl/v1/sources/rijksoverheid/infotypes/traveladvice?output=json</a>
 */
public class TravelAdvice implements Serializable {
    public String Id;
    public String Type;
    public String Canonical;
    public String DataURL;
    public String Title;
    public String Introduction;
    public String Location;
    public Date LastModified;

    public TravelAdvice(JSONObject obj) throws JSONException, ParseException {
        this.Id = obj.getString("id");
        this.Type = obj.getString("type");
        this.Canonical = obj.getString("canonical");
        this.DataURL = obj.getString("dataurl");
        this.Title = obj.getString("title");
        this.Introduction = obj.getString("introduction");
        this.Location = obj.getString("location");
        this.LastModified = Helper.parseISO8601(obj.getString("lastmodified"));
    }
}
