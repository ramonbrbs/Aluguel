package br.ufba.dcc.aluguel.Webservice;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufba.dcc.aluguel.Model.Quarto;

/**
 * Created by ASUS on 03/03/2017.
 */

public class QuartoWS {

    public static List<Quarto> listaQuartos() throws IOException {
        WebRequest req = new WebRequest("http://www.mocky.io/v2/58b95a3b0f00003a0df09c88");
        String retorno = req.get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, new TypeToken<List<Quarto>>(){}.getType());
    }
}
