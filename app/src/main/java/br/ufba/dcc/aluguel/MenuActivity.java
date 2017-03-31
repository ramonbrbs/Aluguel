package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.ufba.dcc.aluguel.Business.InfoRN;
import br.ufba.dcc.aluguel.Model.Info;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btnPesq = (Button)findViewById(R.id.btnPesquisar);
        btnPesq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,ListagemActivity.class);
                startActivity(intent);
            }
        });
        Button btnCad = (Button)findViewById(R.id.btnCadastrar);
        btnCad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,NovoQuartoActivity.class);
                startActivity(intent);
            }
        });
        Button btnSair = (Button)findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,LoginActivity.class);
                intent.putExtra("SAIR","SAIR");
                startActivity(intent);
            }
        });
    }
}
