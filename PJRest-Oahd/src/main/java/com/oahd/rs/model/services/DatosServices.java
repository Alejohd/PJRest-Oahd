package com.oahd.rs.model.services;

import java.util.List;

import com.oahd.rs.model.vo.Usuario;

public interface DatosServices {
	public Usuario getPorId(long id) throws Exception;
	public Usuario getPorUsuario(String usuario,String contrasenia) throws Exception;
	public List<Usuario> getLista() throws Exception;
}
