package br.ufba.dcc.aluguel.Model;

import java.util.List;

/**
 * Created by ramon on 26/03/2017.
 */

public class InterestType {
    public int id;
    public String name;

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    private List<Interest> interests;

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
}
