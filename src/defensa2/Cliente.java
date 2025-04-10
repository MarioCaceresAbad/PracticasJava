package defensa2;


public record Cliente(String nombre, int antiguedad) {
    public static Cliente of(String nombre, int antiguedad) {
        return new Cliente(nombre, antiguedad);
    }

    @Override
    public String toString() {
        return "Cliente[nombre=" + nombre + ", antigüedad=" + antiguedad + "]";
    }
}

