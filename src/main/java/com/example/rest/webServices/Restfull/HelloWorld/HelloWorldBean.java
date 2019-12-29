package com.example.rest.webServices.Restfull.HelloWorld;

/**
 * Created by Acer on 2019-12-13.
 */
public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
