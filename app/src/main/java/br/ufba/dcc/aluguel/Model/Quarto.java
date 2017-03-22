package br.ufba.dcc.aluguel.Model;

import java.io.Serializable;

/**
 * Created by ASUS on 03/03/2017.
 */

public class Quarto implements Serializable{

    private int id;
    private String width;
    private String height;
    private String expenses;
    private float address_id;
    private float landlord_id;

    public float getAddress_id() {
        return address_id;
    }

    public void setAddress_id(float address_id) {
        this.address_id = address_id;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(float landlord_id) {
        this.landlord_id = landlord_id;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
