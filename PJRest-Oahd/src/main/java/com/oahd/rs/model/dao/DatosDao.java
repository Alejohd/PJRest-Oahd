package com.oahd.rs.model.dao;

import java.util.List;

import com.oahd.rs.model.vo.Usuario;

public interface DatosDao {

	public Usuario getPorId(long id) throws Exception;
	public List<Usuario> getPorUsuario(Usuario usuario) throws Exception;
	public List<Usuario> getLista() throws Exception;
}
