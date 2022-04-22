package hu.petrik.bartabalazs_restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class ListResultActivity extends AppCompatActivity {
    private TextView textViewOrszagok;
    private Button visszaButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_result);
        init();

        textViewOrszagok.setMovementMethod(new ScrollingMovementMethod());
        RequestTask task = new RequestTask(textViewOrszagok);
        task.execute();

        visszaButton.setOnClickListener(view -> {
            Intent vissza = new Intent(ListResultActivity.this, MainActivity.class);
            startActivity(vissza);
            finish();
        });



    }
    public void init(){
        textViewOrszagok = findViewById(R.id.textViewOrszagok);
        visszaButton = findViewById(R.id.visszaButton);
    }
}