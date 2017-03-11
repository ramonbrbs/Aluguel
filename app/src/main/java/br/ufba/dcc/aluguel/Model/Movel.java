package br.ufba.dcc.aluguel.Model;

import java.io.Serializable;

/**
 * Created by ASUS on 03/03/2017.
 */

public class Movel implements Serializable{
    private int id;
    private String name;
    private int room_id;

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

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
