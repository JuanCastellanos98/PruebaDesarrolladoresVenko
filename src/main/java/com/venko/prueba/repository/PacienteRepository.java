package com.venko.prueba.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.venko.prueba.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long>{


}
