package br.ufba.dcc.aluguel.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ASUS on 03/03/2017.
 */

public class Quarto implements Serializable{

    private int id;
    private String width;
    private String height;
    private String expenses;
    private int address_id;
    private int landlord_id;
    private byte[] photo;
    private String zipcode;
    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private int number;
    private String complement;

    public List<Integer> getInterestsid() {
        return interestsid;
    }

    public void setInterestsid(List<Integer> interestsid) {
        this.interestsid = interestsid;
    }

    private List<Integer> interestsid;


    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(int landlord_id) {
        this.landlord_id = landlord_id;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    private boolean share;

    public List<String> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<String> furnitures) {
        this.furnitures = furnitures;
    }

    private List<String> furnitures;


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


    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String toString(){
        return "Rua das Laranjas - Brotas - Salvador";
    }
}
