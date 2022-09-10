package com.demo.oracle.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.oracle.model.Usuario;
import com.demo.oracle.services.UsuarioService;



@RestController
@RequestMapping("/ws_usuario")     // localhost:8080/ws_usuario
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<Usuario> obtenerUsuario(){
		return usuarioService.obtenerUsuarios();
	}
	/*
	 metodo get
	 http://localhost:8080/ws_usuario
	 */
	
	@PostMapping()
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.guardarUsuario(usuario);
	}
	/* metodo post  para insertar y actualizar
	 http://localhost:8080/ws_usuario
	 {
	"id": 1,
	"nombre":"rosa ",
	"email":"rosa@gmail.com",
	"prioridad":2
     }
	 */
	
	 @GetMapping( path = "/{id}")   
	    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id) {
	        return this.usuarioService.obtenerPorId(id);
	    }
	 /*
	  * en el metodo get
	  * // localhost:8080/ws_usuario/1
	  * 1 seria el campo id de la tabla
	  */
	 

	    @GetMapping("/query")    // localhost:8080/ws_usuario/1
	    public ArrayList<Usuario> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
	        return this.usuarioService.obtenerPorPrioridad(prioridad);
	    }
	    /*
		  * en el metodo get
		  * // localhost:8080/ws_usuario/query?prioridad=1
		  * 
		  * 
		  * 1 seria el campo prioridad de la tabla
		  */

	    @DeleteMapping( path = "/{id}")
	    public String eliminarPorId(@PathVariable("id") Long id){
	        boolean ok = this.usuarioService.eliminarUsuario(id);
	        if (ok){
	            return "Se eliminó el usuario con id " + id;
	        }else{
	            return "No pudo eliminar el usuario con id" + id;
	        }
	    }
	    /*
		  * en el metodo delete
		  * // localhost:8080/ws_usuario/1
		  * 1 seria el campo id de la tabla
		  */

}
