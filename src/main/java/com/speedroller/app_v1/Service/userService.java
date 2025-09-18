package com.speedroller.app_v1.Service;

import com.speedroller.app_v1.Model.userModel;
import com.speedroller.app_v1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<userModel> listarUser() {
        return userRepository.findAll();
    }

    public void guardar(userModel usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        userRepository.save(usuario);
    }

    public userModel buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
