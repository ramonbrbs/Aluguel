package br.ufba.dcc.aluguel.Model;

/**
 * Created by ramon on 26/03/2017.
 */

public class Interest {
    public int id;

    public String name;
    public int interest_type_id;

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

    public int getInterest_type_id() {
        return interest_type_id;
    }

    public void setInterest_type_id(int interest_type_id) {
        this.interest_type_id = interest_type_id;
    }

}
