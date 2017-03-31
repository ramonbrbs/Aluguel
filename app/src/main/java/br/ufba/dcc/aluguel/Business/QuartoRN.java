package br.ufba.dcc.aluguel.Business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Model.Quarto;
import br.ufba.dcc.aluguel.Webservice.QuartoWS;

/**
 * Created by ASUS on 07/03/2017.
 */

public class QuartoRN {
    public static ArrayList<String> listaQuartos(String id) throws IOException, ExecutionException, InterruptedException {
        return QuartoWS.listaQuartos(id);
    }

    public static boolean publicaQuarto(Quarto quarto, String id) throws ExecutionException, InterruptedException {
        return QuartoWS.publicaQuarto(quarto, id);
    }

    public static boolean alteraQuarto(Quarto quarto) throws ExecutionException, InterruptedException {
        return QuartoWS.alteraQuarto(quarto);
    }
    public static Quarto detalhe(int id) throws ExecutionException, InterruptedException {
        return QuartoWS.detalheQuarto(id);
    }
}
