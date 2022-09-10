package com.demo.oracle.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.oracle.model.Persona;

import com.demo.oracle.services.PersonaService;

//import antlr.collections.List;



@RestController
@RequestMapping("/ws_persona")     // localhost:8080/ws_persona/listar
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	
	@GetMapping("/listar")
	public ArrayList<Persona> obtenerPersona(){
		return personaService.obtenerPersonas();
	}
	
	/*
	 metodo get
	 http://localhost:8080/ws_persona/listar
	 */
	
	@PostMapping("/guardar") // localhost:8080/ws_persona/guardar
	public void guardarPersona(@RequestBody Persona persona) {
		personaService.guardarPersona(persona);
	}
	/*
	@PostMapping()
	public Persona guardarUsuario(@RequestBody Persona persona) {
		return personaService.guardarPersona(persona);
	}
	*/
	/* metodo post  para insertar y actualizar
	 http://localhost:8080/ws_persona/guardar
	 {
	"id": 1,
	"nombre":"rosa ",
	"apellido":"alvares",
	"edad":5

      }
	 */
	
	 @GetMapping( path = "/{id}")   
	    public Optional<Persona> obtenerPersonaPorId(@PathVariable("id") Integer id) {
	        return this.personaService.obtenerPorId(id);
	    }
	 /*
	  * en el metodo get
	  * // localhost:8080/ws_persona/1
	  * 1 seria el campo id de la tabla
	  */
	 

	    @GetMapping("/query")    // lhttp://localhost:8080/ws_persona/query?edad=20
	    public ArrayList<Persona> obtenerUsuarioPorEdad(@RequestParam("edad") Integer edad){
	        return this.personaService.obtenerPorEdad(edad);
	    }
	    /*
		  * en el metodo get
		  * // 
		  * http://localhost:8080/ws_persona/query?edad=20

		  *
		  * 
		  * 1 seria el campo prioridad de la tabla
		  */
	    
		@PutMapping("/actualizar") // localhost:8080/ws_persona/actualizar
		public void actualizar(@RequestBody Persona persona) {
			personaService.guardarPersona(persona);
			
		}
		/* metodo post  para insertar y actualizar
		 http://localhost:8080/ws_persona/actualizar
		 {
		{
		"id": 1,
		"nombre":"rosa ",
		"apellido":"alvares",
		"edad":5
	
	       }
		 */
		
		
	    @DeleteMapping("/eliminar/{id}")
	    public String eliminarPorId(@PathVariable("id") Integer id){
	        boolean ok = this.personaService.eliminarPersona(id);
	        if (ok){
	            return "Se eliminó el usuario con id " + id;
	        }else{
	            return "No pudo eliminar el usuario con id" + id;
	        }
	    }
	    /*
		  * en el metodo delete
		  * // localhost:8080/ws_persona/eliminar/1
		  * 1 seria el campo id de la tabla
		  */


}
