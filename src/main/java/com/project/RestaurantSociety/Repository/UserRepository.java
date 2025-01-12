package com.project.RestaurantSociety.Repository;

import com.project.RestaurantSociety.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
