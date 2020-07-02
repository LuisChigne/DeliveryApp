package udep.ing.poo.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;



public class RegistrarActivity extends AppCompatActivity {
    SharedPreferences mPref;
    TextInputEditText txtImputCorreo, txtImputContrasena, txtImputContrasenaComprobar;
    Button botonRegistrarme;

    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Registre su usuario");
        //El toolbar tendrá un botón para ir hacia atrás -- getSupportActionBar().setDisplayHomeAsUpEnables(true)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Valor recibido del sharedPreferences de ActivityMain
        mPref = getApplicationContext().getSharedPreferences("tipoUsuario", MODE_PRIVATE);
        String seleccionUsuario = mPref.getString("usuario","");
        Toast.makeText(this, "El valor que selecciono fue " + seleccionUsuario, Toast.LENGTH_SHORT).show();

        txtImputCorreo = (TextInputEditText) findViewById(R.id.CorreoRegistrar);
        txtImputContrasena = (TextInputEditText) findViewById(R.id.ContrasenaRegistrar);
        txtImputContrasenaComprobar =(TextInputEditText) findViewById(R.id.ContrasenaComprobar);

        botonRegistrarme = (Button) findViewById(R.id.btnRegistrarme);
        botonRegistrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }
    private void registerUser(){
        String usuario = txtImputCorreo.getText().toString();
        String contrasena = txtImputContrasena.getText().toString();
        String confirmar = txtImputContrasenaComprobar.getText().toString();
        if(usuario.equals("")) {
            Toast.makeText(this, "Tiene que colocar su correo", Toast.LENGTH_SHORT).show();
        } else if(contrasena.equals("")) {
            Toast.makeText(this, "Tiene que colocar su contraseña", Toast.LENGTH_SHORT).show();
        }else if(confirmar.equals("")) {
            Toast.makeText(this, "Tiene que confirmar su contraseña", Toast.LENGTH_SHORT).show();
        }else if(!contrasena.equals(confirmar)) {
            Toast.makeText(this, "Contraseñas ingresadas no coinciden", Toast.LENGTH_SHORT).show();
        } else {
            Usuarios usuarios = new Usuarios(this.getSharedPreferences("proyecto", Context.MODE_PRIVATE));
            usuarios.guardar(usuario, contrasena);
            usuarios.escribirUsuarios();

            Intent i = new Intent(this, LoginActivity.class);
            i.putExtra("campoCorreo", usuario);
            startActivity(i);

        }

    }

}
