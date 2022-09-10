package com.demo.oracle.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.demo.oracle.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	public abstract ArrayList<Usuario> findByPrioridad(Integer prioridad);


}
