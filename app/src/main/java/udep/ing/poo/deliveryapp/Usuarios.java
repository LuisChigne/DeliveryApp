package udep.ing.poo.deliveryapp;

import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class Usuarios {
    private Set<String> usuarios;
    private SharedPreferences preferences;
    public Usuarios(SharedPreferences preferences) {
        this.preferences = preferences;
        leerUsuarios(preferences);
    }
    public void leerUsuarios(SharedPreferences preferesnces) {
        usuarios = preferesnces.getStringSet("usuarios", new HashSet<String>());

    }
    public void guardar(String usuario, String contrasena){
        usuarios.add(usuario+":"+contrasena);
    }
    public boolean validar(String usuario, String contrasena){
        for(String datos : usuarios){
            if(datos.equals(usuario+":"+contrasena)){
                return true;
            }

        }
        return false;
    }
    public void escribirUsuarios(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet("usuarios", usuarios);
        editor.commit();

    }

}

