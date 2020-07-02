package udep.ing.poo.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button botonSoyRepartidor, botonSoyCliente;
    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPref = getApplicationContext().getSharedPreferences("tipoUsuario", MODE_PRIVATE);
        final SharedPreferences.Editor editor = mPref.edit();

        botonSoyCliente = (Button)findViewById(R.id.btnCliente);
        botonSoyRepartidor = (Button)findViewById(R.id.btnRepartidor);
        botonSoyCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("usuario", "cliente");
                editor.apply();
                goToSelectAuth();
            }
        });
        botonSoyRepartidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSelectAuth();
                editor.putString("usuario", "repartidor");
                editor.apply();
            }
        });
    }

    private void goToSelectAuth() {
        Intent i  = new Intent(MainActivity.this, SelectOptionActivity.class);
        startActivity(i);
    }
}
