package com.venko.prueba.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.venko.prueba.model.Paciente;
import com.venko.prueba.repository.MedicoRepository;
import com.venko.prueba.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;

	public String SavePaciente(Paciente paciente) {
		if (pacienteRepository.findByNumeroDocumentoAndTipoDocumento(paciente.getNumeroDocumento(),
				paciente.getTipoDocumento()) != null) {
			return "Ya se encuentra registrado un paciente con el tipo y número de documento proporcionados.";
		} else {
			if (pacienteRepository.findByNumeroDocumento(paciente.getNumeroDocumento()) != null) {
				return "Ya se encuentra registrado un paciente con el número de documento proporcionados.";

			} else {
				pacienteRepository.save(paciente);
				return "Paciente registrado Exitosamente";
			}
		}
	}

	public String UpdatePacienteByCc(String cc, Paciente paciente) {
		if (pacienteRepository.findByNumeroDocumento(cc) != null) {
			Paciente pacienteUpdate = pacienteRepository.findByNumeroDocumento(cc);
			pacienteUpdate.setPrimerNombre(paciente.getPrimerNombre());
			pacienteUpdate.setSegundoNombre(paciente.getSegundoNombre());
			pacienteUpdate.setPrimerApellido(paciente.getPrimerApellido());
			pacienteUpdate.setSegundoApellido(paciente.getSegundoApellido());
			pacienteUpdate.setFechaExpedicionDoc(paciente.getFechaExpedicionDoc());
			pacienteRepository.save(pacienteUpdate);
			return "Paciente registrado Exitosamente";

		} else {

			return "El paciente no existe";
		}

	}

	public Paciente findPacienteByCc(String cc) {
		Paciente paciente = pacienteRepository.findByNumeroDocumento(cc);
		return paciente;
	}

	public String DeletePacienteByCc(String cc) {
		Paciente paciente = pacienteRepository.findByNumeroDocumento(cc);
		if (paciente == null) {
			return "No se pudo eliminar por que el paciente no existe";
		} else {
			pacienteRepository.delete(paciente);
			return "Paciente eliminado satisfactoriamente";
		}
	}

	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	public List<Paciente> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return pacienteRepository.findAllById(ids);
	}

	public <S extends Paciente> S save(S entity) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(entity);
	}

	public Optional<Paciente> findById(Long id) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id);
	}

	public List<Paciente> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

}
