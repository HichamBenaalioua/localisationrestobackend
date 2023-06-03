package com.restau.localisationRes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restau.localisationRes.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Integer>{
	Role findById(int ind);
}
