package br.ufba.dcc.aluguel.Webservice;

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

public class WebRequest {


    private String url;

    public WebRequest(String url){
        this.url = url;
    }


    public String post(String json) throws IOException {

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

    public String get() throws IOException {


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(this.url).build();

        Response response = client.newCall(request).execute();

        String jsonDeResposta = response.body().string();

        return jsonDeResposta;
    }
}
