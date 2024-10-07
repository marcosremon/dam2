package model;


public class Profesor extends Persona{
    private Integer id;
    private Boolean fijo;

    public Profesor(String DNI, String nombre, Integer id, Boolean fijo) {
        super(DNI, nombre);
        this.id = id;
        this.fijo = fijo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isFijo() {
        return fijo;
    }

    public void setFijo(Boolean fijo) {
        this.fijo = fijo;
    }

    @Override
    public String toString() {
        // Ejercicio 1.
        // Busca una manera eficiente de convertir el boolean "fijo" en: "es fijo" o "no es fijo".

        return super.toString()+" es profesor con id: "+this.id+" "+fijo;
    }
}
