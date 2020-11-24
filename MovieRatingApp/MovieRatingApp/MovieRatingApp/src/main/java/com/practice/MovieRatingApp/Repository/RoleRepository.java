package com.practice.MovieRatingApp.Repository;

import com.practice.MovieRatingApp.Model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}
