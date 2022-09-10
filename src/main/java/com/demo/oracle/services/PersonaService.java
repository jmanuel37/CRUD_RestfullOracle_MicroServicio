package com.demo.oracle.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.oracle.model.Persona;
import com.demo.oracle.repositories.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	public ArrayList<Persona> obtenerPersonas(){
		return (ArrayList<Persona>) personaRepository.findAll();
	}
	
	public Persona guardarPersona(Persona persona) {
		return personaRepository.save(persona);
		
		
	}
	public Optional<Persona>obtenerPorId(Integer id)
	{
		return personaRepository.findById(id);
	}
	
	public ArrayList<Persona> obtenerPorEdad(Integer edad){
		return  personaRepository.findByedad(edad);
	}
	
	public boolean eliminarPersona(Integer id) {
	try {
		personaRepository.deleteById(id);
		return true;
	}catch(Exception err) {
		return false;
	}
	}

}
