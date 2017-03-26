package br.ufba.dcc.aluguel.Webservice;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request.Builder;

/**
 * Created by ASUS on 03/03/2017.
 */

public class WebRequest extends AsyncTask<String, Void, String> {

    private Exception exception;

    @Override
    protected String doInBackground(String... urls) {
        try {
            switch (this.method.toUpperCase()){
                case "POST":
                    return doPost(this.content);
                case "GET":
                    return doGet();
            }
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
        return "";
    }

    @Override
    protected void onPostExecute(String feed) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }

    private String url;
    private String method;
    private String content;

    public
    WebRequest(String url, String method, String content){
        this.url = url;
        this.method = method;
        this.content = content;
    }


    public String doPost(String json) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Builder builder = new Builder();

        builder.url(this.url);

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(mediaType, json);
        builder.post(body);

        Request request = builder.build();

        Response response = client.newCall(request).execute();

        String jsonDeResposta = response.body().string();

        return jsonDeResposta;

    }

    public String doGet() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(this.url).build();

        Response response = client.newCall(request).execute();

        String jsonDeResposta = response.body().string();

        return jsonDeResposta;
    }
}
