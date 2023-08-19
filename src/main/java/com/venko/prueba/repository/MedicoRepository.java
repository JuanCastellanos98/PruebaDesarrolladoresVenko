package com.venko.prueba.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.venko.prueba.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
	Medico findByNumeroDocumento(String cc); 
	Optional<Medico> findOneByNumeroDocumento(String cc); 

	Medico findByNumeroDocumentoAndTipoDocumento(String cc, String TipoDoc);
	
	
}
