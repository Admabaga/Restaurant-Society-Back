package com.project.RestaurantSociety.Repository;

import com.project.RestaurantSociety.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userMail = :correo")
    Optional<User> getUserByEmail(@Param("correo") String userMail);
}
