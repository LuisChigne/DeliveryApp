package udep.ing.poo.deliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText eTextInEmail, eTextInPassowrd;
    Button botonIngresar;
    FirebaseAuth autenticacionLogin;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eTextInEmail = (TextInputEditText)findViewById(R.id.textInputEmail);
        eTextInPassowrd = (TextInputEditText)findViewById(R.id.textoInputPassword);
        botonIngresar = (Button)findViewById(R.id.btnIngresar);
        autenticacionLogin = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });

    }
    //Validación para ingresar, es decir deben coincidir las contraseña y el email.
    private void ingresar() {
        String email = eTextInEmail.getText().toString();
        String password = eTextInPassowrd.getText().toString();
        //Comprobar que el email y el passwor no esten vacíos
        if(!email.isEmpty() && !password.isEmpty()){
            //aseguro que la contraseña tenga mas de 6 caracteres, debido a que la herramienta autentication de firebase
            //te exige más de 6 caracteres
            if(password.length()>=6){
                //OnCompletListener sirve para detallar que es lo que se va a hacer cuando se completa la autenticación
                autenticacionLogin.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //si la tarea es exitosa
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Contraseña y Password válidos", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(LoginActivity.this,"La contraseña y/o el password son incorrectos",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            } else {
                Toast.makeText(LoginActivity.this,"La contraseña debe tener más de 6 caracteres", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(LoginActivity.this,"Necesitas escribir contraseña y usuario gil", Toast.LENGTH_SHORT).show();

        }
    }
}
