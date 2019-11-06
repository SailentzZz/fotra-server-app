package com.fotra.database.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fotra.database.entities.PasswordReset;

public interface PasswordResetRepository extends CrudRepository<PasswordReset, Integer>{
	PasswordReset findByToken(String token);
}
