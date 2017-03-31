package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        if(lista.size() > id) {
            Quarto quarto = null;
            try {
                String idQuarto = lista.get(id);
                quarto = QuartoRN.detalhe(Integer.parseInt(idQuarto));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {

                if (quarto != null) {
                    Usuario usuario = UsuarioRN.detalhe(quarto.getLandlord_id());
                    ImageView image = (ImageView) findViewById(R.id.imageView);
                    byte[] photo = quarto.getPhoto();
                    BitmapFactory.Options bmo = new BitmapFactory.Options();
                    bmo.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap bMap = BitmapFactory.decodeByteArray(photo, 0, photo.length, bmo);
                    image.setImageBitmap(bMap);
                    //((ImageView) findViewById(R.id.imageView)).setImageBitmap(BitmapFactory.decodeByteArray(quarto.getPhoto(),0,quarto.getPhoto().length));
                    ((TextView) findViewById(R.id.detalheDono)).setText("Anunciado por " + usuario.getName());
                    ((TextView) findViewById(R.id.detalheEndereco)).setText(quarto.getStreet() + "," + quarto.getNeighborhood() + " - " + quarto.getCity());
                    ((TextView) findViewById(R.id.detalheTel)).setText(usuario.getPhonenumber());
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(this, "Não há mais quartos com seu perfil. :(",
                    Toast.LENGTH_SHORT).show();
        }
    }
    ArrayList<String> lista;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacao);
        lista = (ArrayList<String>)getIntent().getSerializableExtra("LISTA");
        index = 0;
        carregarQuarto(index);
        Button btnProx = (Button) findViewById(R.id.detalheProx);
        btnProx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                VisualizacaoActivity.this.index++;


                VisualizacaoActivity.this.carregarQuarto(VisualizacaoActivity.this.index);
                VisualizacaoActivity.this.index ++;
            }
        });
    }
}
