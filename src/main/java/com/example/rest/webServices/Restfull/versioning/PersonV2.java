package com.example.rest.webServices.Restfull.versioning;

/**
 * Created by Acer on 2019-12-27.
 */
public class PersonV2 {
    private Name name;

    public PersonV2() {
    }

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
