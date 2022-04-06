package hu.petrik.bartabalazs_restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button felvetelButton, listazasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        felvetelButton.setOnClickListener(view -> {
            Intent felvetelre = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(felvetelre);
            finish();
        });
        listazasButton.setOnClickListener(view -> {
            Intent listazasra = new Intent(MainActivity.this, ListResultActivity.class);
            startActivity(listazasra);
            finish();
        });
    }
    public  void init(){
        felvetelButton = findViewById(R.id.felvetelButton);
        listazasButton = findViewById(R.id.listazasButton);

    }
}