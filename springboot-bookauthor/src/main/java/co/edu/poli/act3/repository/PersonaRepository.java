package co.edu.poli.act3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act3.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>  {
	

}
