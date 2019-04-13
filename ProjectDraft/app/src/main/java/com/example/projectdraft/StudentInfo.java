package com.example.projectdraft;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo {

    private String number;
    private String firstName;
    private String surname;
    private String email;

    private List<String> list = new ArrayList<String>();


    public void setStuInfo(String number, String firstName,
                               String surname, String email){

        this.number = number;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;

        list.add(number);
        list.add(firstName);
        list.add(surname);
        list.add(email);

    }

    public List<String> getStuInfo(){

        return list;

    }



}
