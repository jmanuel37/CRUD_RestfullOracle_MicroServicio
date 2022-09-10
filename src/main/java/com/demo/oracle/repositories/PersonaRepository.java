package com.demo.oracle.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.demo.oracle.model.Persona;



public interface PersonaRepository extends CrudRepository<Persona, Integer>{
	public abstract ArrayList<Persona> findByedad(Integer edad);

}
