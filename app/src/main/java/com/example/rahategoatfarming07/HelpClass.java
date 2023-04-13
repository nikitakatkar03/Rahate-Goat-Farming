package com.example.rahategoatfarming07;

public class HelpClass {
    public HelpClass(String name, String message, String email, String phone) {

        this.name = name;
        this.message = message;
        this.phone = phone;
        this.email = email;
    }
    public HelpClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String  name, message,phone,email;
}
