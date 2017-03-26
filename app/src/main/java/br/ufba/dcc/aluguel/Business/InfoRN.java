package br.ufba.dcc.aluguel.Business;

import android.content.Context;

import br.ufba.dcc.aluguel.DAO.InfoDAO;
import br.ufba.dcc.aluguel.Model.Info;

/**
 * Created by ASUS on 25/03/2017.
 */

public class InfoRN {
    public static Info get(Context c){
        InfoDAO d = new InfoDAO(c);
        return d.busca();
    }

    public static void insere(Context c, Info i){
        InfoDAO d = new InfoDAO(c);
        if(get(c).getId() == 0){
            d.insere(i);
        }else{
            d.update(i);
        }
    }
}
