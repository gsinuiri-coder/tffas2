package com.crehana.userprofile.domain.repository;

import com.crehana.userprofile.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
