package com.oahd.rs.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oahd.rs.model.dao.DatosDao;
import com.oahd.rs.model.vo.Usuario;

public class DatosServicesImpl implements DatosServices {

	@Autowired
	DatosDao datosDao;
	
	@Override
	public Usuario getPorId(long id) throws Exception {
		return datosDao.getPorId(id);
	}

	@Override
	public List<Usuario> getLista() throws Exception {
		return datosDao.getLista();
	}

	
	@Override
	public Usuario getPorUsuario(String usuario, String contrasenia) throws Exception {
		Usuario usuario1 = new Usuario();
		usuario1.setContrasenia(contrasenia);
		usuario1.setUsuario(usuario);
		Usuario usuarioObj= new Usuario();
		 List<Usuario>  usuarioLista = datosDao.getPorUsuario(usuario1);
		if(usuarioLista.size()>0){
			usuarioObj = usuarioLista.get(0);	
			}else{
				usuarioObj.setContrasenia("No Existe");
				usuarioObj.setUsuario("No Existe");
			}
		return usuarioObj;
	}

}
