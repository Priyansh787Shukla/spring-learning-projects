package com.endeavour.OAuthDemo.controller;

import com.endeavour.OAuthDemo.Service.UserService;
import com.endeavour.OAuthDemo.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController
{
    private UserService userService;
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home()
    {
        return """
                Public Home
                Login Using: localhost:8080/oauth2/authorization/google
                """;
    }

    @GetMapping("/profile")
    public Map<String, Object> profile(@AuthenticationPrincipal OidcUser oidcUser)
    {
        User user = userService.findByProviderAndProviderSubject("google", oidcUser.getSubject()).orElseThrow();
        Map<String, Object> response = new HashMap<>();
        response.put("internalUserId", user.getId());
        response.put("provider", user.getProvider());
        response.put("providerSubject", user.getProviderSubject());
        response.put("name",  user.getName());
        response.put("email", user.getEmail());
        return response;
    }
}
