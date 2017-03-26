package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Business.EnderecoRN;
import br.ufba.dcc.aluguel.Business.InfoRN;
import br.ufba.dcc.aluguel.Business.QuartoRN;
import br.ufba.dcc.aluguel.Business.UsuarioRN;
import br.ufba.dcc.aluguel.Model.Endereco;
import br.ufba.dcc.aluguel.Model.Info;
import br.ufba.dcc.aluguel.Model.Quarto;
import br.ufba.dcc.aluguel.Model.Usuario;
import br.ufba.dcc.aluguel.Webservice.QuartoWS;

public class VisualizacaoActivity extends AppCompatActivity {


    private void carregarQuarto(int id){
        Quarto quarto = null;
        try {
            quarto = QuartoRN.listaQuartos().get(id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {

            if(quarto != null){
                Usuario usuario = UsuarioRN.detalhe(quarto.getLandlord_id());
                ((ImageView) findViewById(R.id.imageView)).setImageBitmap(BitmapFactory.decodeByteArray(quarto.getPhoto(),0,quarto.getPhoto().length));
                ((TextView)findViewById(R.id.detalheDono)).setText(usuario.getName());
                ((TextView)findViewById(R.id.detalheEndereco)).setText(quarto.getStreet() +"," + quarto.getNeighborhood() + " - " + quarto.getCity());
                ((TextView)findViewById(R.id.detalheTel)).setText(quarto.getAddress_id());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacao);

        index = 0;
        carregarQuarto(index);
        Button btnProx = (Button) findViewById(R.id.detalheProx);
        btnProx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                VisualizacaoActivity.this.index++;
                Info i = InfoRN.get(VisualizacaoActivity.this);

                VisualizacaoActivity.this.carregarQuarto(i.getIndex() + 1);
                i.setIndex(i.getIndex() + 1);
                InfoRN.insere(VisualizacaoActivity.this, i);
            }
        });
    }
}
