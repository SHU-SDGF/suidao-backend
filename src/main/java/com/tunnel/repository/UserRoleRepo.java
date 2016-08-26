package com.tunnel.repository;

import org.springframework.data.repository.CrudRepository;

import com.tunnel.model.MLoginRolePK;
import com.tunnel.model.UserRole;

public interface UserRoleRepo extends CrudRepository<UserRole, MLoginRolePK> {

}
