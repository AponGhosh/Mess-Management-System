package com.mycompany.project;

public class Person {

    private String Name;
    private int NID;
    private String Contact;
    private String DOB;
    private String Permanent_Adrs;

    void setName(String n) {
        Name = n;
    }

    String getName() {
        return Name;
    }

    void setNID(int n) {
        NID = n;
    }

    int getNID() {
        return NID;
    }

    void setContact(String c) {
        Contact = c;
    }

    String getContact() {
        return Contact;
    }

    void setDOB(String d) {
        DOB = d;
    }

    String DOB() {
        return DOB;
    }

    void setPAdrs(String a) {
        Permanent_Adrs = a;
    }

    String getPAdrs() {
        return Permanent_Adrs;
    }

}
