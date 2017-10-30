package com.example.nayan.cardview;

/**
 * Created by Nayan on 10/30/2017.
 */

public class ContentItem extends ListItem {

    private String name;
    private String rollnumber;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }
}
