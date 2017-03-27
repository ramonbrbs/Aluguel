package br.ufba.dcc.aluguel.Webservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Model.Constantes;
import br.ufba.dcc.aluguel.Model.Interest;
import br.ufba.dcc.aluguel.Model.InterestType;
import br.ufba.dcc.aluguel.Model.Quarto;

/**
 * Created by ramon on 26/03/2017.
 */

public class InterestsWS {
    public static List<InterestType> tipos() throws ExecutionException, InterruptedException {
        WebRequest request = new WebRequest(Constantes.enderecoAPI + "/interesttype","GET","");
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, new TypeToken<List<InterestType>>(){}.getType());
    }

    public static List<Interest> interessesPorTipo(InterestType type) throws ExecutionException, InterruptedException {
        WebRequest request = new WebRequest(Constantes.enderecoAPI + "/interesbytype/" + type.getId(),"GET","");
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, new TypeToken<List<Interest>>(){}.getType());
    }
}
