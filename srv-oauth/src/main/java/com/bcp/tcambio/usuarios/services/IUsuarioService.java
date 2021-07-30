package com.bcp.tcambio.usuarios.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bcp.tcambio.usuarios.model.Usuario;

public interface IUsuarioService extends UserDetailsService{
	Usuario findByUsername(String username);
}
