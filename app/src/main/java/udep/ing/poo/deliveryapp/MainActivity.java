package udep.ing.poo.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button botonSoyRepartidor, botonSoyCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonSoyCliente = (Button)findViewById(R.id.btnCliente);
        botonSoyRepartidor = (Button)findViewById(R.id.btnRepartidor);
        botonSoyCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSelectAuth();
            }
        });
        botonSoyRepartidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSelectAuth();
            }
        });
    }

    private void goToSelectAuth() {
        Intent i  = new Intent(MainActivity.this, SelectOptionActivity.class);
        startActivity(i);
    }
}
