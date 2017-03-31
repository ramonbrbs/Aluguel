package br.ufba.dcc.aluguel.Business;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Model.Interest;
import br.ufba.dcc.aluguel.Model.InterestType;
import br.ufba.dcc.aluguel.Webservice.InterestsWS;

/**
 * Created by ramon on 26/03/2017.
 */

public class InterestRN {
    public static List<InterestType> tipos() throws IOException, ExecutionException, InterruptedException  {
        return InterestsWS.tipos();
    }

    public static List<Interest> interessesPorTipo(InterestType type) throws IOException, ExecutionException, InterruptedException {
        return InterestsWS.interessesPorTipo(type);
    }
}
