package udep.ing.poo.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SelectOptionActivity extends AppCompatActivity {
    //barra de herramientas, tiene su layout action_bar_toollbar
    Toolbar mToolbar;
    Button botonLogin, botonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Seleccionar Opción");
        //El toolbar tendrá un botón para ir hacia atrás -- getSupportActionBar().setDisplayHomeAsUpEnables(true)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        botonLogin = (Button)findViewById(R.id.btnGoLogin);
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });
        botonRegistrar = (Button)findViewById(R.id.btnRegisterNow);
        botonRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToRegistrar();
            }
        });
    }

    private void goToLogin() {
        Intent i = new Intent(SelectOptionActivity.this, LoginActivity.class);
        startActivity(i);
    }
    private void goToRegistrar() {
        Intent i = new Intent(SelectOptionActivity.this, RegistrarActivity.class);
        startActivity(i);
    }
}
