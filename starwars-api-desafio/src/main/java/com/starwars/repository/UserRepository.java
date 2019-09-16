package com.starwars.repository;

import org.springframework.data.repository.CrudRepository;

import com.starwars.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Integer> {

}
