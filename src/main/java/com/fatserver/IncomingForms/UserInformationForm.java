package com.fatserver.IncomingForms;

/**
 * Class will be used as a container to send public user data
 */
public class UserInformationForm {
    private String number;
    private String city;
    private String country;

    public UserInformationForm(){
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserInformationForm(String number, String city, String country){
        this.number = number;
        this.city = city;
        this.country = country;

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

