package udep.ing.poo.deliveryapp.ofertas;

public class Oferta {
    private String nombre;
    private String restaurante;
    private String info;
    private Integer precio;
    private Integer foto;

    public Oferta(String nombre, String restaurante, String info, Integer precio, Integer foto) {
        this.nombre = nombre;
        this.restaurante = restaurante;
        this.info = info;
        this.precio = precio;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
