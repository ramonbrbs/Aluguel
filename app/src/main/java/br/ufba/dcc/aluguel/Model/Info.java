package br.ufba.dcc.aluguel.Model;

/**
 * Created by ASUS on 25/03/2017.
 */

public class Info {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    private int id;
    private String hash;
    private int Index;

}
