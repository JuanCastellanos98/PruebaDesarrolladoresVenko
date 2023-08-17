package com.venko.prueba.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.venko.prueba.model.Medico;
import com.venko.prueba.repository.MedicoRepository;

@Service
public class MedicoService {
	//private final MedicoRepository medicoRepository;
    private final PasswordEncoder passwordEncoder;

    public MedicoService(MedicoRepository MedicoRepository, PasswordEncoder passwordEncoder) {
        this.medicoRepository = medicoRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
	@Autowired
	private MedicoRepository medicoRepository;

	public String SaveMedico(Medico medico) {
		if (medicoRepository.findByNumeroDocumentoAndTipoDocumento(medico.getNumeroDocumento(),
				medico.getTipoDocumento()) != null) {
			return "Ya se encuentra registrado un medico con el tipo y número de documento proporcionados.";
		} else {
			if (medicoRepository.findByNumeroDocumento(medico.getNumeroDocumento()) != null) {
				return "Ya se encuentra registrado un medico con el número de documento proporcionados.";

			} else {
				String encodedPassword = passwordEncoder.encode(medico.getContraseña());
				medico.setContraseña(encodedPassword);
				medicoRepository.save(medico);
				return "Medico registrado Exitosamente";
			}
		}
	}

	public String UpdateMedicoByCc(String cc, Medico medico) {
		if (medicoRepository.findByNumeroDocumento(cc) != null) {
			Medico medicoUpdate = medicoRepository.findByNumeroDocumento(cc);
			medicoUpdate.setPrimerNombre(medico.getPrimerNombre());
			medicoUpdate.setSegundoNombre(medico.getSegundoNombre());
			medicoUpdate.setPrimerApellido(medico.getPrimerApellido());
			medicoUpdate.setSegundoApellido(medico.getSegundoApellido());
			medicoUpdate.setFechaExpedicionDoc(medico.getFechaExpedicionDoc());
			medicoRepository.save(medicoUpdate);
			return "Medico registrado Exitosamente";

		} else {

			return "El medico no existe";
		}

	}

	public Medico findMedicoByCc(String cc) {
		Medico medico = medicoRepository.findByNumeroDocumento(cc);
		return medico;
	}

	public String DeleteMedicoByCc(String cc) {
		Medico medico = medicoRepository.findByNumeroDocumento(cc);
		if (medico == null) {
			return "No se pudo eliminar por que el medico no existe";
		} else {
			medicoRepository.delete(medico);
			return "Medico eliminado satisfactoriamente";
		}
	}


	public List<Medico> findAll() {
		// TODO Auto-generated method stub
		return medicoRepository.findAll();
	}

	public List<Medico> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return medicoRepository.findAllById(ids);
	}

	public <S extends Medico> S save(S entity) {
		// TODO Auto-generated method stub
		
		return medicoRepository.save(entity);
	}

	public Optional<Medico> findById(Long id) {
		// TODO Auto-generated method stub
		return medicoRepository.findById(id);
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	public void delete(Medico entity) {
		// TODO Auto-generated method stub

	}

	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	public void deleteAll(Iterable<? extends Medico> entities) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public List<Medico> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Medico> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Medico> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Medico> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Medico> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends Medico> boolean exists(Medico medico) {
		// TODO Auto-generated method stub
		return false;
	}

	public <S extends Medico, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
