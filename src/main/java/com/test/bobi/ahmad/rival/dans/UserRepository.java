package com.test.bobi.ahmad.rival.dans;

import com.test.bobi.ahmad.rival.dans.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MUser, Long> {
    Optional<MUser> findByUsername(String username);
}
