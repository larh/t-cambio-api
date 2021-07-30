package com.bcp.tcambio.usuarios.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bcp.tcambio.usuarios.model.Usuario;

@Repository
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);
}
