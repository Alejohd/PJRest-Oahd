package com.oahd.rs.model.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

import com.oahd.rs.model.vo.Usuario;

public class DatosDaoImpl implements DatosDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;


	@Override
	public Usuario getPorId(long id) throws Exception {
		session = sessionFactory.openSession();
		Usuario usuario = (Usuario) session.load(Usuario.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return usuario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getLista() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Usuario> usuarioList = session.createCriteria(Usuario.class)
				.list();
		tx.commit();
		session.close();
		return usuarioList;
	}

	@Override
	public List<Usuario> getPorUsuario(Usuario usuario) throws Exception {
		session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Usuario> usuarioLista = session.createCriteria(Usuario.class)
	    .add(Example.create(usuario)).list();
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return usuarioLista;
	}	

}
