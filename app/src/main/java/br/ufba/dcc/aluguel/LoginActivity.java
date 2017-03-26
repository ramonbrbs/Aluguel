package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Business.InfoRN;
import br.ufba.dcc.aluguel.Business.UsuarioRN;
import br.ufba.dcc.aluguel.Model.Info;
import br.ufba.dcc.aluguel.Model.Quarto;
import br.ufba.dcc.aluguel.Model.Usuario;
import br.ufba.dcc.aluguel.Webservice.QuartoWS;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        try {
            List<Quarto> quartos = QuartoWS.listaQuartos();
            String teste = "aaa";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //String j = quartos.toString();

        Button BtnEntrar = (Button) findViewById(R.id.brnLogin);
        final EditText EdtEmail = (EditText) findViewById(R.id.edtEmail);
        final EditText EdtSenha = (EditText) findViewById(R.id.edtSenha);

        BtnEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Usuario u = new Usuario();
                u.setEmail(EdtEmail.getText().toString());
                //u.setP(EdtSenha.getText().toString());
                try {
                    String hash = UsuarioRN.login(u);
                    if (hash != ""){ //verifica se retorna um token
                        Info i = new Info();
                        i.setHash(hash);
                        i.setIndex(0);
                        InfoRN.insere(LoginActivity.this, i);
                        Intent intent = new Intent(LoginActivity.this,ListagemActivity.class);
                        startActivity(intent);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
