package udep.ing.poo.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;


import dmax.dialog.SpotsDialog;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText eTextInEmail, eTextInPassword;
    Button botonIngresar;

    AlertDialog mDialog;
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eTextInEmail = (TextInputEditText) findViewById(R.id.textInputEmail);
        eTextInPassword = (TextInputEditText) findViewById(R.id.textoInputPassword);
        botonIngresar = (Button) findViewById(R.id.btnIngresar);

        mDialog = new SpotsDialog.Builder().setContext(LoginActivity.this).setMessage("Espere un momento").build();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Ingresar");
        //El toolbar tendrá un botón para ir hacia atrás -- getSupportActionBar().setDisplayHomeAsUpEnables(true)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String usuario = bundle.getString("campoCorreo");
            eTextInEmail.setText(usuario);
        }

    }

    private void ingresar() {
        String usuario = eTextInEmail.getText().toString();
        String password = eTextInPassword.getText().toString();
        if (usuario.equals("")) {
            Toast.makeText(this, "Tiene que colocar su correo ", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(this, "Tiene que colocar su contraseña", Toast.LENGTH_SHORT).show();

        } else {
            Usuarios usuarios = new Usuarios(this.getSharedPreferences("proyecto", Context.MODE_PRIVATE));
            if (usuarios.validar(usuario, password)) {
                Intent i = new Intent(this, MenuActivity.class);
                i.putExtra("correo", usuario);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o contraseña errónea", Toast.LENGTH_SHORT).show();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "proyecto");
                builder.setContentTitle("A lo mejor no se encuentra registrado...");
                builder.setContentText("Presione aquí para registrarse");
                builder.setSmallIcon(R.drawable.ic_launcher_foreground);
                builder.setAutoCancel(true); //

                Intent intent = new Intent(this, RegistrarActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

                builder.setContentIntent(pIntent);

                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(1, builder.build());
            }
        }
    }
}