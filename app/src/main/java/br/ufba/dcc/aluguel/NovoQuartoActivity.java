package br.ufba.dcc.aluguel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.ufba.dcc.aluguel.Business.InterestRN;
import br.ufba.dcc.aluguel.Business.QuartoRN;
import br.ufba.dcc.aluguel.Business.UsuarioRN;
import br.ufba.dcc.aluguel.Model.Endereco;
import br.ufba.dcc.aluguel.Model.Interest;
import br.ufba.dcc.aluguel.Model.InterestType;
import br.ufba.dcc.aluguel.Model.Quarto;
import br.ufba.dcc.aluguel.Model.Usuario;

public class NovoQuartoActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");


            int bytes = imageBitmap.getByteCount();
//or we can calculate bytes this way. Use a different value than 4 if you don't use 32bit images.
//int bytes = b.getWidth()*b.getHeight()*4;

            ByteBuffer buffer = ByteBuffer.allocate(bytes); //Create a new buffer
            imageBitmap.copyPixelsToBuffer(buffer); //Move the byte data to the buffer

            byte[] photo = buffer.array(); //Get the underlying array containing the data.
            qua.setPhoto(photo);
            ImageView img = (ImageView)findViewById(R.id.imgNovo);
            img.setImageBitmap(imageBitmap);
        }
    }
    private Quarto qua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_quarto);

        ImageView img = (ImageView)findViewById(R.id.imgNovo);
        LinearLayout layout = (LinearLayout)findViewById(R.id.novoAnuncioLinear);

        qua = new Quarto();
        Button btnPub = (Button) findViewById(R.id.btnPublicar);
        ((ImageView)findViewById(R.id.imgNovo)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
            }
        } );
        btnPub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                qua.setFurnitures(new ArrayList<String>());
                qua.setHeight(((EditText) findViewById(R.id.txtComp)).toString());
                qua.setWidth(((EditText) findViewById(R.id.txtLarg)).toString());
                if (((CheckBox) findViewById(R.id.chkComp)).isChecked()){
                    qua.setShare(true);
                }else{
                    qua.setShare(false);
                }
                qua.setCity(((EditText) findViewById(R.id.txtCidade)).toString());
                qua.setState(((EditText) findViewById(R.id.txtEstado)).toString());
                qua.setZipcode(((EditText) findViewById(R.id.txtCEP)).toString());
                qua.setStreet(((EditText) findViewById(R.id.txtRua)).toString());
                qua.setNumber(Integer.parseInt(((EditText) findViewById(R.id.txtNum)).toString()));

                try {
                    if (QuartoRN.publicaQuarto(qua)){
                        Intent intent = new Intent(NovoQuartoActivity.this,ListagemActivity.class);
                        startActivity(intent);
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
