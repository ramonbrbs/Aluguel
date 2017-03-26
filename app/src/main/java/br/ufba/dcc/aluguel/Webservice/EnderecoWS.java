package br.ufba.dcc.aluguel.Webservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Model.Constantes;
import br.ufba.dcc.aluguel.Model.Endereco;
import br.ufba.dcc.aluguel.Model.Quarto;

/**
 * Created by ASUS on 25/03/2017.
 */

public class EnderecoWS {
    public static Endereco detalhe(int id) throws ExecutionException, InterruptedException {
        WebRequest request = new WebRequest(Constantes.enderecoAPI + "/address/" + id,"GET","");
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, Endereco.class);
    }
}
