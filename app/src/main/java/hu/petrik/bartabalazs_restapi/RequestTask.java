package hu.petrik.bartabalazs_restapi;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class RequestTask extends AsyncTask<Void, Void, Response> {
    TextView textViewOrszagok;

    public RequestTask(TextView textViewOrszagok){
        this.textViewOrszagok = textViewOrszagok;
    }
    @Override
    protected Response doInBackground(Void... voids) {
        Response response = null;
        try {
            response = RequestHandler.get("https://retoolapi.dev/XqXBFR/varosok");
        } catch (IOException e) {
            Log.d("hiba", e.toString());
        }
        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        textViewOrszagok.setText(response.getContent());
    }
}
