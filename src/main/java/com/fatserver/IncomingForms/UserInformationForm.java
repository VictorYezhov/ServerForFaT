package com.fatserver.IncomingForms;

public class UserInformationForm {
    private String number;
    private String city;

    public UserInformationForm(){
    }

    public UserInformationForm(String number, String city){
        this.number = number;
        this.city = city;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

