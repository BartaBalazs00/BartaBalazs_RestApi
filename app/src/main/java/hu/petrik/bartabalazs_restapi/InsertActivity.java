package hu.petrik.bartabalazs_restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class InsertActivity extends AppCompatActivity {
    private EditText editTextNev, editTextOrszag, editTextLakossag;
    private Button felvetelButton, visszaButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();
        visszaButton.setOnClickListener(view -> {
            Intent vissza = new Intent(InsertActivity.this, MainActivity.class);
            startActivity(vissza);
            finish();
        });
        felvetelButton.setOnClickListener(view -> {
            String nev = editTextNev.getText().toString().trim();
            String orszag = editTextOrszag.getText().toString().trim();
            String lakossagText = editTextLakossag.getText().toString().trim();
            if(nev.isEmpty()){
                Toast.makeText(this, "A név megadása kötelező", Toast.LENGTH_SHORT).show();
                return;
            }
            if(orszag.isEmpty()){
                Toast.makeText(this, "Az ország megadása kötelező", Toast.LENGTH_SHORT).show();
                return;
            }
            if(lakossagText.isEmpty()){
                Toast.makeText(this, "A lakosság megadása kötelező", Toast.LENGTH_SHORT).show();
                return;
            }
            int lakossag = Integer.parseInt(lakossagText);
            Varos varos = new Varos(0, nev, orszag, lakossag);
            Gson jsonConvert = new Gson();
            RequestTask task = new RequestTask("https://retoolapi.dev/XqXBFR/varosok", "POST", jsonConvert.toJson(varos));
            task.execute();
            urlapAlaphelyzetbe();
            Toast.makeText(InsertActivity.this, "Sikeres felétel", Toast.LENGTH_SHORT).show();
        });
    }

    private void urlapAlaphelyzetbe() {
        editTextNev.setText("");
        editTextLakossag.setText("");
        editTextOrszag.setText("");
    }

    public void init(){
        editTextNev = findViewById(R.id.editTextNev);
        editTextOrszag = findViewById(R.id.editTextOrszag);
        editTextLakossag = findViewById(R.id.editTextLakossag);
        felvetelButton = findViewById(R.id.felvetelButton);
        visszaButton = findViewById(R.id.visszaButton);
    }
}