package com.airbnbclone.backend.user.repository;

import com.airbnbclone.backend.user.domain.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findOneByEmail(String email);

  Optional<User> findOneByPublicId(UUID publicId);
}
