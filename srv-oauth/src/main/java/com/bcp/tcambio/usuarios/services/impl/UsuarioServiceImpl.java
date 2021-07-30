package com.bcp.tcambio.usuarios.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bcp.tcambio.usuarios.dao.UsuarioDao;
import com.bcp.tcambio.usuarios.model.Usuario;
import com.bcp.tcambio.usuarios.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	private Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			log.error("Error en el login");
			throw new UsernameNotFoundException("Error en el login");
		}
		
		List<GrantedAuthority> autorities = 
				usuario.getRols().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());
		
		return new User(username, usuario.getPassword(), true, true, true, true, autorities);
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

}
