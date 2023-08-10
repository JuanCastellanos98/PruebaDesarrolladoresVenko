package com.venko.prueba.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
}
