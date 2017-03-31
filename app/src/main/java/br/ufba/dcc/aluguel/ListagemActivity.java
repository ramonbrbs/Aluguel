package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Business.QuartoRN;
import br.ufba.dcc.aluguel.Business.UsuarioRN;
import br.ufba.dcc.aluguel.Model.Quarto;
import br.ufba.dcc.aluguel.Model.Usuario;

public class ListagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        Button btnPublicar = (Button) findViewById(R.id.publicar);

        try {
            List<Quarto> quartos = new ArrayList<Quarto>();
            final ListView listaQuartos = (ListView) findViewById(R.id.lstQuartos);
            ArrayAdapter<Quarto> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, quartos);
            listaQuartos.setAdapter(adapter);


            listaQuartos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                    Quarto q = (Quarto) listaQuartos.getItemAtPosition(position);
                    Toast.makeText(ListagemActivity.this, q.toString(), Toast.LENGTH_SHORT).show();
                }

            });

            btnPublicar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ListagemActivity.this,CadastroActivity.class);

                    startActivity(intent);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
