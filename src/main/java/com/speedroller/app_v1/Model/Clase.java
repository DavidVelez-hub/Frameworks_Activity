package com.speedroller.app_v1.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String dia;
    private LocalTime hora;
    private Integer duracionMinutos;


    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // Relación uno-a-muchos con Matricula
    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas = new ArrayList<>();
}