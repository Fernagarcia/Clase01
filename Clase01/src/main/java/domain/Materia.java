package domain;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private final String nombre;
    private List<Materia> correlativas;

    public List<Materia> getCorrelativas() {
        return this.correlativas;
    }

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>(correlativas);
    }
}