package hu.petrik.bartabalazs_restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }
    public void init(){
        editTextNev = findViewById(R.id.editTextNev);
        editTextOrszag = findViewById(R.id.editTextOrszag);
        editTextLakossag = findViewById(R.id.editTextLakossag);
        felvetelButton = findViewById(R.id.felvetelButton);
        visszaButton = findViewById(R.id.visszaButton);
    }
}