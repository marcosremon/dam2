package Clases;

public class PersonaSimple {
    String nombre;
    int edad;

    public PersonaSimple(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public PersonaSimple() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "PersonaSimple{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
