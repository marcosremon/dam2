package Clases;

public class Cancion {
      String titulo;
      String cantante;

    public Cancion(String titulo, String cantante) {
        this.titulo = titulo;
        this.cantante = cantante;
    }

    public Cancion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", cantante='" + cantante + '\'' +
                '}';
    }
}
