package com.endeavour.OAuthDemo.Service;

import com.endeavour.OAuthDemo.entity.User;
import com.endeavour.OAuthDemo.repository.UserRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    private UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User registerOrUpdateUser(String provider, OidcUser oidcUser)
    {
        String providerSubject = oidcUser.getSubject();
        Optional<User> existingUser = userRepository.findByProviderAndProviderSubject(provider, providerSubject);
        if(existingUser.isPresent())
        {
            User user = existingUser.get();
            user.setName(oidcUser.getClaimAsString("name"));
            user.setEmail(oidcUser.getClaimAsString("email"));
            return existingUser.get();
        }
        User newUser = new User();
        newUser.setName(oidcUser.getClaimAsString("name"));
        newUser.setEmail(oidcUser.getClaimAsString("email"));
        newUser.setProvider(provider);
        newUser.setProviderSubject(providerSubject);
        userRepository.save(newUser);
        return newUser;
    }

    public Optional<User> findByProviderAndProviderSubject(String provider, String providerSubject)
    {
        return userRepository.findByProviderAndProviderSubject(provider, providerSubject);
    }
}
