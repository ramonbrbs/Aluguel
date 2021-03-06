package br.ufba.dcc.aluguel.Webservice;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufba.dcc.aluguel.Model.Constantes;
import br.ufba.dcc.aluguel.Model.Endereco;
import br.ufba.dcc.aluguel.Model.Quarto;

/**
 * Created by ASUS on 03/03/2017.
 */

public class QuartoWS {

    public static ArrayList<String> listaQuartos(String id) throws  ExecutionException, InterruptedException {
        WebRequest request = new WebRequest(Constantes.enderecoAPI + "/bedroomsid/"+id,"GET","");
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, new TypeToken<ArrayList<String>>(){}.getType());
    }

    public static boolean publicaQuarto(Quarto quarto, String id) throws ExecutionException, InterruptedException {
        Gson toJS = new Gson();
        String quartoJSON = toJS.toJson(quarto);
        WebRequest request = new WebRequest(Constantes.enderecoAPI + "/bedroom/new/"+ id,"POST",quartoJSON);
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, Boolean.class);
    }

    public static boolean alteraQuarto(Quarto quarto) throws ExecutionException, InterruptedException {
        Gson toJS = new Gson();
        String quartoJSON = toJS.toJson(quarto);

        WebRequest request = new WebRequest("http://www.mocky.io/v2/58b95a3b0f00003a0df09c88","POST",quartoJSON);
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, Boolean.class);
    }

    public static Quarto detalheQuarto(int id) throws ExecutionException, InterruptedException {
        Gson toJS = new Gson();
        String idJSON = toJS.toJson(id);

        WebRequest request = new WebRequest(Constantes.enderecoAPI+ "/bedroom/" + id,"GET",idJSON);
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, Quarto.class);
    }
}
