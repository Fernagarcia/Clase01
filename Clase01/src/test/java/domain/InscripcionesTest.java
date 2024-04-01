package domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InscripcionesTest {
    Materia algoritmos, paradigmas, disenio, gestionDeDatos, admDeRecursos;
    Inscripcion inscripcion;

    @BeforeEach
    public void instanceMaterias() {
        algoritmos = new Materia("Algoritmos y estructuras de datos", List.of());
        paradigmas = new Materia("Paradigmas de programación", List.of(algoritmos));
        disenio = new Materia("Diseño de Sistemas", List.of(paradigmas));
        gestionDeDatos = new Materia("Gestion de datos", List.of(paradigmas));
        admDeRecursos = new Materia("Administracion de Recursos", List.of(disenio));
    }

    @Test
    public void cumpleConRequisitosParaInscripcion() {
        Alumno alumno = new Alumno("2026995", "Fernando", List.of(paradigmas, algoritmos));
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(disenio, gestionDeDatos));
        Assertions.assertTrue(inscripcion.aprobado());
    }

    @Test
    public void noCumpleConRequisitosDeInscripcion() {
        Alumno alumno = new Alumno("2026995", "Fernando", List.of(paradigmas, algoritmos));
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(admDeRecursos, disenio));
        Assertions.assertFalse(inscripcion.aprobado());
    }
}
