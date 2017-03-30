package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Business.UsuarioRN;
import br.ufba.dcc.aluguel.Model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnEnviar = (Button) findViewById(R.id.btnCadastrar);
        final EditText txtNome = (EditText) findViewById(R.id.txtNome);
        final EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
        final EditText txtTelefone = (EditText) findViewById(R.id.txtTelefone);
        final EditText txtNasc = (EditText) findViewById(R.id.txtCidade);
        final RadioButton rdkMasc = (RadioButton) findViewById(R.id.rdMasculino);
        final RadioButton rdkFem = (RadioButton) findViewById(R.id.rdFem);
        RadioButton rdOutro = (RadioButton) findViewById(R.id.rdOutro);
        final CheckBox chkBebe = (CheckBox) findViewById(R.id.chkBebe);
        final CheckBox chkFuma = (CheckBox) findViewById(R.id.chkFuma);

        LinearLayout li  = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 123;

        CheckBox cb;
        for(int i = 0; i < 4; i++) {
            cb = new CheckBox(this);
            cb.setText("Amor");
            li.addView(cb, params);
        }

        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Usuario u = new Usuario();
                u.setEmail(txtEmail.getText().toString());
                u.setName(txtNome.getText().toString());
                u.setEmail(txtEmail.getText().toString());
                u.setPhonenumber(txtTelefone.getText().toString());
                u.setBirthdate(txtNasc.getText().toString());
                if(rdkMasc.isChecked()){
                    u.setSex('M');
                }else if(rdkFem.isChecked()){
                    u.setSex('F');
                }else{
                    u.setSex('O');
                }
                if(chkBebe.isChecked()){
                    u.setDrink(true);
                }else{
                    u.setDrink(false);
                }
                if(chkFuma.isChecked()){
                    u.setSmoke(true);
                }else{
                    u.setSmoke(false);
                }

                try {
                    if (UsuarioRN.cadastrar(u) != ""){ //verifica se retorna um token
                        Intent intent = new Intent(CadastroActivity.this,LoginActivity.class);
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
