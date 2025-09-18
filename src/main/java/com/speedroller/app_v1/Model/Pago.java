package com.speedroller.app_v1.Model;

import com.speedroller.app_v1.enums.MetodoPago;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;
    private LocalDateTime fechaPago;
    @Enumerated(EnumType.STRING)
    private MetodoPago metodo;
    // Puedes agregar un enum EstadoPago si lo necesitas
    private String estado; // Ej: "PENDIENTE", "PAGADO"

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
}
