package com.tunnel.repository;

import org.springframework.data.repository.CrudRepository;

import com.tunnel.model.Role;

public interface RoleRepo extends CrudRepository<Role, String> {

}
