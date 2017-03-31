package br.ufba.dcc.aluguel.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.ufba.dcc.aluguel.Model.Info;

/**
 * Created by ASUS on 25/03/2017.
 */

public class InfoDAO extends SQLiteOpenHelper{

    private Context contexto;
    public InfoDAO(Context context){
        super(context, "bd", null, 3);
        this.contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create_table = "CREATE TABLE Info(" +
                "   Id INTEGER PRIMARY KEY," +
                "   Hash           VARCHAR(512)    NOT NULL," +
                "   'Index'         INTEGER" +
                ");";
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTable = "DROP TABLE Info";
        sqLiteDatabase.execSQL(dropTable);
        this.onCreate(sqLiteDatabase);
    }

    public void insere(Info info) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Id", 1);
        dados.put("Hash", info.getHash());
        dados.put("Index", info.getIndex());
        db.insert("Info", null, dados);
        //db.close();
    }


    public void update(Info info) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("Id", 1);
        dados.put("Hash", info.getHash());
        dados.put("Index", info.getIndex());
        db.update("Info", dados, "Id = 1", null);
        //db.close();
    }



    public Info busca() {

        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery("select * from Info",null);

        Info info = new Info();
        info.setId(0);

        while (c.moveToNext()) {
            info.setId(c.getInt(c.getColumnIndex("Id")));
            info.setHash(c.getString(c.getColumnIndex("Hash")));
            info.setIndex(c.getInt(c.getColumnIndex("Index")));
            return info;

        }

        c.close();

        return info;

    }


}
