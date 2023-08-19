package com.venko.prueba.ConfigSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.venko.prueba.model.Medico;
import com.venko.prueba.repository.MedicoRepository;

public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String cc) throws UsernameNotFoundException{
		Medico medico= medicoRepository
		.findOneByNumeroDocumento(cc)
		.orElseThrow((()-> new UsernameNotFoundException("El usuario "+cc+" no existe")));
		return new UserDetailsImpl(medico);
	}

}
