package br.ufba.dcc.aluguel.Webservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Model.Quarto;
import br.ufba.dcc.aluguel.Model.Usuario;

/**
 * Created by ASUS on 06/03/2017.
 */

public class UsuarioWS {

    public static String login(Usuario usuario) throws IOException, ExecutionException, InterruptedException {
        Gson toJS = new Gson();
        String usuarioJSON = toJS.toJson(usuario);

        WebRequest request = new WebRequest("https://demo0075251.mockable.io/login","POST",usuarioJSON);
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        Map<String,String> arrayRetorno = gson.fromJson(retorno, new TypeToken<Map<String,String>>(){}.getType());
        return arrayRetorno.get("token");
    }

    public static String cadastrar(Usuario usuario) throws IOException, ExecutionException, InterruptedException {
        Gson toJS = new Gson();
        String usuarioJSON = toJS.toJson(usuario);

        WebRequest request = new WebRequest("http://www.mocky.io/v2/58b95a3b0f00003a0df09c88","POST",usuarioJSON);
        String retorno = request.execute("").get();
        Gson gson = new Gson();
        return gson.fromJson(retorno, new TypeToken<List<Quarto>>(){}.getType());
    }


}
