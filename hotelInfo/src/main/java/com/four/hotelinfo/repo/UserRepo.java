package com.four.hotelinfo.repo;

import com.four.hotelinfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Transactional
    void deleteUserByUserId(String userId);

    Optional<User> findByUserId(String userId);
}
