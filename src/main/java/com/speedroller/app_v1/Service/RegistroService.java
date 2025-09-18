package com.speedroller.app_v1.Service;


import com.speedroller.app_v1.dto.AspiranteDto;
import com.speedroller.app_v1.Model.Estudiante;
import com.speedroller. app_v1.Model.userModel;
import com.speedroller.app_v1.Repository.EstudianteRepository;
import com.speedroller.app_v1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registrarAspirante(AspiranteDto dto) {
        // Crear usuario
        userModel usuario = new userModel();
        usuario.setName(dto.getCorreo());
        usuario.setPassword(passwordEncoder.encode("123456"));
        usuario.setRol(com.speedroller.app_v1.enums.Rol.ALUMNO);

        // Crear estudiante
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setCorreo(dto.getCorreo());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setGenero(dto.getGenero());
        estudiante.setEstado(com.speedroller.app_v1.enums.EstadoAlumno.PENDIENTE);
        estudiante.setUsuario(usuario);

        // Relacionar
        usuario.setEstudiante(estudiante);

        // Guardar
        userRepository.save(usuario);
    }
}