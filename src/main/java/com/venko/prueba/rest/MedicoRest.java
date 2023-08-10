package com.venko.prueba.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.venko.prueba.model.Medico;
import com.venko.prueba.repository.MedicoRepository;
import com.venko.prueba.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoRest {
	@Autowired
	private MedicoService medicoService;
	
	//Obtener todos los medicos registrados
	@GetMapping
	private ResponseEntity<List<Medico>> getAllMedico(){
		return ResponseEntity.ok(medicoService.findAll());
	}
	
	//Eliminar medicos por las cedulas 
	@DeleteMapping("/eliminarMedico/{cc}")
	private String DeleteMedicoBycc(@PathVariable("cc") String ccMedico) {
		return medicoService.DeleteMedicoByCc(ccMedico);
	}
	
	
	//Guardar y validar medico por tipo de documento y cedula y tambien solo por cedula
	@PostMapping
	private ResponseEntity<String> saveMedico(@RequestBody Medico medico){
		String mensaje=medicoService.SaveMedico(medico);
		if (mensaje.contains("Medico registrado Exitosamente")) {
            return ResponseEntity.ok(mensaje);
        } else {
            return ResponseEntity.badRequest().body(mensaje);
        }
	}
	//Editar por cedula del paciente
	@PutMapping("{cc}")
	private String updateMedico(@PathVariable("cc") String ccMedico,@RequestBody Medico medico){
		return medicoService.UpdateMedicoByCc(ccMedico, medico);
	}
	
	//Mostrar la informacion del medico por cedula
	@GetMapping("{cc}")
	private ResponseEntity<?> findMedicobyCc(@PathVariable("cc") String ccMedico){
		Medico medico = medicoService.findMedicoByCc(ccMedico);
		if(medico==null) {
			return ResponseEntity.badRequest().body("El Medico no existe");
		}else {
			return ResponseEntity.ok(medico);
		}
	}
	//prueba
}
