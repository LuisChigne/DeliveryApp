package udep.ing.poo.deliveryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import udep.ing.poo.deliveryapp.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_OFERTAS);

        db.execSQL(Utilidades.REGISTRO1);
        /*
        db.execSQL(Utilidades.REGISTRO2);
        db.execSQL(Utilidades.REGISTRO3);
        db.execSQL(Utilidades.REGISTRO4);
        db.execSQL(Utilidades.REGISTRO5);
        db.execSQL(Utilidades.REGISTRO6);
        db.execSQL(Utilidades.REGISTRO7);
        db.execSQL(Utilidades.REGISTRO8);
        db.execSQL(Utilidades.REGISTRO9);
        db.execSQL(Utilidades.REGISTRO10);
        
         */


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_OFERTAS);
        onCreate(db);
    }
}
