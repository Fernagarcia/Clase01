package domain;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String legajo;
    private final String nombre;
    private final List<Materia> materiasAprobadas;

    public Alumno(String legajo, String nombre, List<Materia> materiasAp) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>(materiasAp);
    }

    // Methods

    // Podría haber unificado en una misma función pero asi siento que queda mas declarativo

    public Boolean puedeCursar(Materia materia) {
        return this.tieneCorrelativasAprobadas(materia);
    }

    public Boolean tieneCorrelativasAprobadas(Materia materia) {
        return materia.getCorrelativas().stream().allMatch((correlativa) ->
           this.materiasAprobadas.contains(correlativa) && this.tieneCorrelativasAprobadas(correlativa));
    }
}