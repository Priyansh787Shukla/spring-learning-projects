package com.endeavour.JWTdemo.service;

import com.endeavour.JWTdemo.entity.Role;
import com.endeavour.JWTdemo.repository.RoleRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class RoleService
{
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role)
    {
        roleRepository.save(role);
    }
}