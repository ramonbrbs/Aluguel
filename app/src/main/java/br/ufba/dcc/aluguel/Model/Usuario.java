package br.ufba.dcc.aluguel.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 03/03/2017.
 */

public class Usuario {
    private int id;
    private String name;
    private String email;
    private String phonenumber;
    private String birthdate;
    private boolean drink;
    private boolean smoke;
    private char sex;
    private List<Integer> interestsid;


    public List<Integer> getInterestsid() {
        return interestsid;
    }

    public void setInterestsid(List<Integer> interestsid) {
        this.interestsid = interestsid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isDrink() {
        return drink;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }
}
