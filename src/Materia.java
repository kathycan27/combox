public class Materia {
int id_materia;
String nombre_materia;

    public Materia() {
        id_materia = 0;
        nombre_materia = "";
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    @Override
    public String toString() {
        return getNombre_materia();
    }
}