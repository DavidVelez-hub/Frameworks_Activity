package com.speedroller.app_v1.Model;

import com.speedroller.app_v1.enums.EstadoAlumno;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    @Column(unique = true, nullable = false)
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String genero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAlumno estado = EstadoAlumno.PENDIENTE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private userModel usuario;

    // Relación uno-a-muchos con Matricula
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas = new ArrayList<>();

    // Relación uno-a-muchos con Pago
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos = new ArrayList<>();

    // Constructor para registro
    public Estudiante(String nombre, String apellido, String correo, String telefono,
        LocalDate fechaNacimiento, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estado = EstadoAlumno.PENDIENTE;
    }
}