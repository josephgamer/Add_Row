package Logic;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:35 a. m.
 */
public class Disease {
    private String nombre;

    public Disease() {
        this.nombre = "";
    }

    public Disease(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
