package com.example.rest.webServices.Restfull.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Acer on 2019-12-14.
 */
@ApiModel(description = "All details about the user. ")
public class User {

    private Integer id;

    @Size(min=2, message = "Name should have at least 2 characters")
    @ApiModelProperty(notes = "at least 2 char reqiured")
    private String name;
    @Past
    @ApiModelProperty(notes = "Birth date should be in the past")
    private Date birthDate;

    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    protected User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
