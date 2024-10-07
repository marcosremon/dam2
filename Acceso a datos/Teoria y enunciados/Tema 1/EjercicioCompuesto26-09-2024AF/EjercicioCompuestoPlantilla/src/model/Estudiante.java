package model;

import java.util.Map;

public class Estudiante extends  Persona{
    private Integer id;
    private Map<String, Float> listaAsignaturasyNotas;

    public Estudiante(String DNI, String nombre, Integer id, Map<String, Float> listaAsignaturasyNotas) {
        super(DNI, nombre);
        this.id = id;
        this.listaAsignaturasyNotas = listaAsignaturasyNotas;
    }

    public Estudiante(String DNI, String nombre, Integer id) {

        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Float> getListaAsignaturasyNotas() {
        return listaAsignaturasyNotas;
    }

    public void setListaAsignaturasyNotas(Map<String, Float> listaAsignaturasyNotas) {
        this.listaAsignaturasyNotas = listaAsignaturasyNotas;
    }

    @Override
    public String toString() {
        return super.toString()+" es estudiante con id: "+this.id+" y asignaturas y notas: "+this.listaAsignaturasyNotas;
    }
}
