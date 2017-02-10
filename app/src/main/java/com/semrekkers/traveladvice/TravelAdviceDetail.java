package com.semrekkers.traveladvice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Sem Rekkers on 9-1-2017.
 */

public class TravelAdviceDetail {
    public String Id;
    public String Type;
    public String Canonical;
    public String DataURL;
    public String Title;
    public String Introduction;
    public String Location;
    public String Modifications;
    public ContentParagraph[] Content;
    public String[] Authorities;
    public String[] Creators;
    public Date LastModified;
    public Date Available;
    public String License;
    public String[] RightsHolders;
    public String Language;
    public String Subject;
    public String[] Themes;

    public TravelAdviceDetail(JSONObject obj) throws JSONException, ParseException {
        this.Id = obj.getString("id");
        this.Type = obj.getString("type");
        this.Canonical = obj.getString("canonical");
        this.DataURL = obj.getString("dataurl");
        this.Title = obj.getString("title");
        this.Introduction = obj.getString("introduction");
        this.Location = obj.getString("location");
        this.Modifications = obj.getString("modifications");
        this.LastModified = Helper.parseISO8601(obj.getString("lastmodified"));
        this.Available = Helper.parseISO8601(obj.getString("available"));
        this.License = obj.getString("license");
        this.Language = obj.getString("language");
        this.Subject = obj.getString("subject");

        JSONArray content, authorities, creators, rightsholders, themes;
        content = obj.getJSONArray("content");
        authorities = obj.getJSONArray("authorities");
        creators = obj.getJSONArray("creators");
        rightsholders = obj.getJSONArray("rightsholders");
        themes = obj.getJSONArray("themes");

        this.Content = new ContentParagraph[content.length()];
        for (int i = 0; i < content.length(); i++) {
            this.Content[i] = new ContentParagraph(content.getJSONObject(i));
        }

        this.Authorities = new String[authorities.length()];
        for (int i = 0; i < authorities.length(); i++) {
            this.Authorities[i] = authorities.getString(i);
        }

        this.Creators = new String[creators.length()];
        for (int i = 0; i < creators.length(); i++) {
            this.Creators[i] = creators.getString(i);
        }

        this.RightsHolders = new String[rightsholders.length()];
        for (int i = 0; i < rightsholders.length(); i++) {
            this.RightsHolders[i] = rightsholders.getString(i);
        }

        this.Themes = new String[themes.length()];
        for (int i = 0; i < themes.length(); i++) {
            this.Themes[i] = themes.getString(i);
        }
    }

    public class ContentParagraph {
        public String ParagraphTitle = null;
        public String Summary = null;
        public String Paragraph = null;

        public ContentParagraph(JSONObject obj) throws JSONException {
            if (obj.has("paragraphtitle")) {
                this.ParagraphTitle = obj.getString("paragraphtitle");
            }
            if (obj.has("summary")) {
                this.ParagraphTitle = obj.getString("summary");
            }
            if (obj.has("paragraph")) {
                this.ParagraphTitle = obj.getString("paragraph");
            }
        }
    }
}
