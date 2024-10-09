package EjerciciosRepaso.model;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instituto instituto = (Instituto) o;
        return Objects.equals(director.getId(), instituto.director.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(director.getId());
    }
}
