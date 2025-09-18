package com.speedroller.app_v1.dto;

import com.speedroller.app_v1.enums.MetodoPago;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AspiranteDto {

    @NotBlank(message = "Nombre obligatorio")
    private String nombre;

    @NotBlank(message = "Apellido obligatorio")
    private String apellido;

    @NotBlank(message = "Correo obligatorio")
    @Email(message = "Correo inválido")
    private String correo;

    @NotBlank(message = "Teléfono obligatorio")
    @Pattern(regexp = "^\\d{10}$", message = "Teléfono debe tener 10 dígitos")
    private String telefono;

    @NotNull(message = "Fecha de nacimiento obligatoria")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "Género obligatorio")
    private String genero;

    @NotNull(message = "Método de pago obligatorio")
    private MetodoPago metodoPago;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }
}