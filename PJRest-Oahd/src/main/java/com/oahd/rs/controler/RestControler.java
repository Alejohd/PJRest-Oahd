package com.oahd.rs.controler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oahd.rs.model.services.DatosServices;
import com.oahd.rs.model.vo.Usuario;

@Controller
@RequestMapping("/usuario")
public class RestControler {

	@Autowired
	DatosServices datosServices;

	static final Logger logger = Logger.getLogger(RestControler.class);

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE , method= RequestMethod.GET, value = "/{nombre}/{contrasenia}" )
	public @ResponseBody
	Usuario getusuario(@PathVariable("nombre") String nombre, @PathVariable("contrasenia") String contrasenia) {
		Usuario usuario = null;
		try {
			usuario = datosServices.getPorUsuario(nombre, contrasenia);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Usuario getusuario(@PathVariable("id") Long id) {
		Usuario usuario = null;
		try {
			usuario = datosServices.getPorId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody
	List<Usuario> getUsuarios() {

		List<Usuario> usuarioList = null;
		try {
			usuarioList = datosServices.getLista();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarioList;
	}
}
