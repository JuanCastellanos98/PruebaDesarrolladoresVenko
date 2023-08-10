package com.venko.prueba.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venko.prueba.model.Paciente;
import com.venko.prueba.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteRest {

	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	private ResponseEntity<List<Paciente>> getAllPacientes(){
		return ResponseEntity.ok(pacienteService.findAll());
	}
	
	//Eliminar pacientes por las cedulas 
		@DeleteMapping("/eliminarPaciente/{cc}")
		private String DeletePacienteBycc(@PathVariable("cc") String ccPaciente) {
			return pacienteService.DeletePacienteByCc(ccPaciente);
		}
		
		
		//Guardar y validar medico por tipo de documento y cedula y tambien solo por cedula
		@PostMapping
		private ResponseEntity<String> savePaciente(@RequestBody Paciente paciente){
			String mensaje=pacienteService.SavePaciente(paciente);
			if (mensaje.contains("Paciente registrado Exitosamente")) {
	            return ResponseEntity.ok(mensaje);
	        } else {
	            return ResponseEntity.badRequest().body(mensaje);
	        }
		}
		//Editar por cedula del paciente
		@PutMapping("{cc}")
		private String updatePaciente(@PathVariable("cc") String ccPaciente,@RequestBody Paciente paciente){
			return pacienteService.UpdatePacienteByCc(ccPaciente, paciente);
		}
		
		//Mostrar la informacion del medico por cedula
		@GetMapping("{cc}")
		private ResponseEntity<?> findPacientebyCc(@PathVariable("cc") String ccPaciente){
			Paciente paciente = pacienteService.findPacienteByCc(ccPaciente);
			if(paciente==null) {
				return ResponseEntity.badRequest().body("El Paciente no existe");
			}else {
				return ResponseEntity.ok(paciente);
			}
		}
	
}
