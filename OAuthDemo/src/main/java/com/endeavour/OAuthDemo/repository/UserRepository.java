package com.endeavour.OAuthDemo.repository;

import com.endeavour.OAuthDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByProviderAndProviderSubject(String provider, String providerSubject);
}
