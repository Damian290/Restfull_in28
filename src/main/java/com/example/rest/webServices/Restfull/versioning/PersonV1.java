package com.example.rest.webServices.Restfull.versioning;

/**
 * Created by Acer on 2019-12-27.
 */
public class PersonV1 {

    private String name;

    public PersonV1() {
    }

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
