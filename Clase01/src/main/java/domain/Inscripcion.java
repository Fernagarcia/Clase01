package domain;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasAInscribirse;

    public List<Materia> getMateriasAInscribirse() {
        return materiasAInscribirse;
    }

    public Inscripcion(Alumno alumno, List<Materia> materiaAInscribirse) {
        this.alumno = alumno;
        this.materiasAInscribirse = new ArrayList<Materia>(materiaAInscribirse);
    }

    public Boolean aprobado(){
        return this.getMateriasAInscribirse().stream().allMatch(materia -> alumno.puedeCursar(materia));
    }
}