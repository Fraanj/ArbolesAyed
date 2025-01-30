package Parciales;

public class tuplaPt1 {
        private String tipo;
    private String nombre;

    public tuplaPt1(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esDragon(){
        return this.getTipo().equalsIgnoreCase("Dragon");
    }
    
    public boolean esPrincesa(){
        return this.getTipo().equalsIgnoreCase("Princesa");
    }
    
    @Override
    public String toString() {
        return "tuplaPt1{" + "tipo=" + tipo + ", nombre=" + nombre + '}';
    }
}
