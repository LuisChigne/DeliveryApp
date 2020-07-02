package udep.ing.poo.deliveryapp.utilidades;

import udep.ing.poo.deliveryapp.R;

public class Utilidades {
    public static final String TABLA_OFERTAS="ofertas";
    public static final String CAMPO_ID="nombre";
    public static final String CAMPO_RESTAURANTE = "restaurante";
    public static final String CAMPO_INFO="info";
    public static final String CAMPO_PRECIO="precio";
    public static final String CAMPO_FOTO="foto";

    public static final String CREAR_TABLA_OFERTAS="CREATE TABLE " + ""+TABLA_OFERTAS+ " ("+CAMPO_ID+" " + "STRING, "+CAMPO_RESTAURANTE+" STRING,"+CAMPO_INFO+" TEXT, "+ CAMPO_PRECIO+" INTEGER, "+CAMPO_FOTO+" INTEGER)";

    public static final String REGISTRO1 = "INSERT INTO " + TABLA_OFERTAS + " (" + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", " + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('2X1 EN PIZZA MEDIANA', 'DOMINOS PIZZA', 'Peperoni/Americana/Hawaiana', '15', " + R.drawable.dominos+")";
    /*
    public static final String REGISTRO2 = "INSERT INTO " + TABLA_OFERTAS + " (" + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", " + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('-25% PIZZA CARNIVORA', 'PAPA JHONS', 'Hasta agotar stock', '15.OO', " + R.drawable.papajhons+")";

    public static final String REGISTRO3 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('2X1 PIZZA XL', 'PIZZA HUT', 'Válido sólo para San Miguel', '30.OO', " + R.drawable.pizzahut+")";

    public static final String REGISTRO4 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('-50% CHILLI CHIKEN', 'KFC', 'Todos los días de 11:00 a 13:00', '12.OO', " + R.drawable.kfc+")";

    public static final String REGISTRO5 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('2x1 CONO YOGURT', 'PINKBERRY', 'En los sabores de chocolate y fresa', '8.OO', " + R.drawable.pinkberry+")";

    public static final String REGISTRO6 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('2X1 EN PIZZA MEDIANA', 'DOMINOS PIZZA', 'Peperoni/Americana/Hawaiana', '15.OO', " + R.drawable.mcdonalds+")";

    public static final String REGISTRO7 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('$8 TABLA DE MAKIS', 'OHASHI MAKIS', 'En acevichado o seyi', '8.OO', " + R.drawable.ohashimakis+")";

    public static final String REGISTRO8 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('CHAUFA + GASEOSA', 'CHINAWOK', 'No incluye otros ingredientes', '20.OO', " + R.drawable.chaufa+")";
    public static final String REGISTRO9 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('MARTES DE TACOS', 'CHILIS', 'Tacos al 50% de descuento', '17.OO', " + R.drawable.chilis+")";
    public static final String REGISTRO10 = "INSERT INTO " + TABLA_OFERTAS + " ("
            + CAMPO_ID + ", " + CAMPO_RESTAURANTE + ", "
            + CAMPO_INFO + ", " + CAMPO_PRECIO + ", " + CAMPO_FOTO + ") Values ('1/4 DE POLLO A $10', 'ROCKY'S', 'No incluye ensalada ni papas', '10.OO', " + R.drawable.rockys+")";
    */

    public static final int LIST = 1;
    public static final int GRID = 2;
    public static int visualizacion = LIST;
}

