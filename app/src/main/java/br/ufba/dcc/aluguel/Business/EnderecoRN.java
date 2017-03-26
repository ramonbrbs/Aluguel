package br.ufba.dcc.aluguel.Business;

import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Model.Endereco;
import br.ufba.dcc.aluguel.Webservice.EnderecoWS;

/**
 * Created by ASUS on 25/03/2017.
 */

public class EnderecoRN {
    public static Endereco detalhe(int id) throws ExecutionException, InterruptedException {
        return EnderecoWS.detalhe(id);
    }
}
