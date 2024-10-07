package EjerciciosRepaso.model;

import java.util.Map;

public class Instituto {
    private Profesor director;
    private Map<Integer, Estudiante> mapdeEstudiantes;
    private Map<Integer, Profesor> mapdeProfesores;

    public Instituto(Profesor director, Map<Integer, Estudiante> mapdeEstudiantes, Map<Integer, Profesor> mapdeProfesores) {
        this.director = director;
        this.mapdeEstudiantes = mapdeEstudiantes;
        this.mapdeProfesores = mapdeProfesores;
    }

    public Profesor getDirector() {
        return director;
    }

    public void setDirector(Profesor director) {
        this.director = director;
    }

    public Map<Integer, Estudiante> getMapdeEstudiantes() {
        return mapdeEstudiantes;
    }

    public void setMapdeEstudiantes(Map<Integer, Estudiante> mapdeEstudiantes) {
        this.mapdeEstudiantes = mapdeEstudiantes;
    }

    public Map<Integer, Profesor> getMapdeProfesores() {
        return mapdeProfesores;
    }

    public void setMapdeProfesores(Map<Integer, Profesor> mapdeProfesores) {
        this.mapdeProfesores = mapdeProfesores;
    }

    @Override
    public String toString() {
        return "El Instituto con director: "+director+", lista de profesores: "+this.mapdeProfesores+", lista de alumnos: "+this.mapdeEstudiantes;
    }

}
