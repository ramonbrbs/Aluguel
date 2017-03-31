package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Business.InterestRN;
import br.ufba.dcc.aluguel.Business.UsuarioRN;
import br.ufba.dcc.aluguel.Model.Interest;
import br.ufba.dcc.aluguel.Model.InterestType;
import br.ufba.dcc.aluguel.Model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    List<CheckBox> checks;
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

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.novoUsuario);
        List<InterestType> tipos = new ArrayList<InterestType>();
        List<Interest> interesses = new ArrayList<Interest>();
        checks = new ArrayList<CheckBox>();
        try {
            tipos = InterestRN.tipos();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TextView label = new TextView(this);
        label.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        linearLayout.addView(label, 9);
        for(InterestType t: tipos){

            TextView text = new TextView(this);
            text.setText(t.getName() + ":");
            linearLayout.addView(text, 10);
            try {
                t.setInterests(InterestRN.interessesPorTipo(t));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(Interest i : t.getInterests()){
                CheckBox c = new CheckBox(this);
                c.setText(i.name);
                c.setId(i.id);
                linearLayout.addView(c, 11);
                checks.add(c);
            }
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
                List<Integer> interesses = new ArrayList<Integer>();
                for (CheckBox c : checks){
                    if(c.isChecked()){
                        interesses.add(c.getId());
                    }
                }
                u.setInterestsid(interesses);
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
