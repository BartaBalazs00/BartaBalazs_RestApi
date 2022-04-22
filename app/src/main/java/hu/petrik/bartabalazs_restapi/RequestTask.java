package hu.petrik.bartabalazs_restapi;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

public class RequestTask extends AsyncTask<Void, Void, Response> {
    String requestUrl;
    String requestType = "";
    String requestParams;
    TextView textViewOrszagok;

    public RequestTask(String requestUrl, String requestType, String requestParams) {
        this.requestUrl = requestUrl;
        this.requestType = requestType;
        this.requestParams = requestParams;
    }

    public RequestTask(String requestUrl, String requestType) {
        this.requestUrl = requestUrl;
        this.requestType = requestType;
    }

    public RequestTask(TextView textViewOrszagok){
        this.textViewOrszagok = textViewOrszagok;
    }
    @Override
    protected Response doInBackground(Void... voids) {
        Response response = null;
        try {
            switch (requestType){
                case "":
                    response = RequestHandler.get("https://retoolapi.dev/XqXBFR/varosok");
                    break;
                case "POST":
                    response = RequestHandler.post(requestUrl, requestParams);
                    break;
            }
        } catch (IOException e) {
            Log.d("hiba", e.toString());
        }
        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        Gson converter = new Gson();
        if (response == null) {
            return;
        }
        if(response.getResponseCode() >=400){
            Log.d("hiba", "hiba");
            return;
        }
        switch (requestType) {
            case "":
                textViewOrszagok.setText(response.getContent());
                break;
            case "POST":
                Varos varos = converter.fromJson(response.getContent(), Varos.class);
                break;
        }

    }
}
