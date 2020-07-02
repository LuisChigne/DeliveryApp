package udep.ing.poo.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button botonUbicacion, botonOfertas, botonRestaurantes, botonPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnOfertas:
                miIntent=new Intent(MenuActivity.this,OfertasActivity.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}
