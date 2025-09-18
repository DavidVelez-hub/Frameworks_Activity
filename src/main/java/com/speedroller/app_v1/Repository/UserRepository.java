package com.speedroller.app_v1.Repository;

import com.speedroller.app_v1.Model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<userModel, Long> {
    Optional<userModel> findByEmail(String email);
}
