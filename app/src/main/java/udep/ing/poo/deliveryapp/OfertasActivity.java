package udep.ing.poo.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import udep.ing.poo.deliveryapp.ofertas.Oferta;
import udep.ing.poo.deliveryapp.utilidades.Utilidades;

public class OfertasActivity extends AppCompatActivity {

    ArrayList<Oferta> listaOfertas;
    RecyclerView recyclerOfertas;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_ofertas", null, 1);

        construirRecycler();
    }


    private void consultarListaOfertas(){
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] campos = {Utilidades.CAMPO_ID, Utilidades.CAMPO_RESTAURANTE, Utilidades.CAMPO_INFO, Utilidades.CAMPO_PRECIO,
        Utilidades.CAMPO_FOTO};

        Cursor cursor = db.query(Utilidades.TABLA_OFERTAS,
                campos,
                null,
                null,
                null,
                null,
                null);
        if (!cursor.moveToFirst()) {
            cursor.close();
            db.close();
            return;
        }
        do {
            String id = cursor.getString(cursor.getColumnIndex(Utilidades.CAMPO_ID));
            String restaurante = cursor.getString(cursor.getColumnIndex(Utilidades.CAMPO_RESTAURANTE));
            String info = cursor.getString(cursor.getColumnIndex(Utilidades.CAMPO_INFO));
            int precio = cursor.getInt(cursor.getColumnIndex(Utilidades.CAMPO_PRECIO));
            int foto = cursor.getInt(cursor.getColumnIndex(Utilidades.CAMPO_FOTO));
            Oferta oferta = new Oferta(id,restaurante, info, precio, foto);
            listaOfertas.add(oferta);
        } while (cursor.moveToNext());

        cursor.close();
    }
    public void onClick(View view) {
        switch  (view.getId()){
            case R.id.btnList: Utilidades.visualizacion = Utilidades.LIST;
                break;
            case R.id.btnGrid: Utilidades.visualizacion = Utilidades.GRID;
                break;
        }
        construirRecycler();
    }
    private void construirRecycler() {
        listaOfertas = new ArrayList<>();
        recyclerOfertas = (RecyclerView)findViewById(R.id.recyclerid);

        if(Utilidades.visualizacion == Utilidades.LIST){
            recyclerOfertas.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerOfertas.setLayoutManager(new GridLayoutManager(this,2));
        }

        AdaptadorOfertas adapter =new AdaptadorOfertas(listaOfertas);

        adapter.setOnclickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Seleccion: "+
                        listaOfertas.get(recyclerOfertas.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerOfertas.setAdapter(adapter);

        consultarListaOfertas();
    }
}
