package br.ufba.dcc.aluguel.Business;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Model.Quarto;
import br.ufba.dcc.aluguel.Model.Usuario;
import br.ufba.dcc.aluguel.Webservice.UsuarioWS;

/**
 * Created by ASUS on 07/03/2017.
 */

public class UsuarioRN {
    public static String login(Usuario usuario) throws IOException, ExecutionException, InterruptedException {
        return UsuarioWS.login(usuario);
    }

    public static String cadastrar(Usuario usuario) throws IOException, ExecutionException, InterruptedException {
        return UsuarioWS.cadastrar(usuario);
    }

    public static Usuario detalhe(int id) throws IOException, ExecutionException, InterruptedException {
        return UsuarioWS.detalhe(id);
    }
}
