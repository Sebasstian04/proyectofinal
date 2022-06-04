package co.edu.poli.act3.controller;

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

import co.edu.poli.act3.model.Persona;
import co.edu.poli.act3.repository.PersonaRepository;


@RestController
@RequestMapping("/aplicativo/v1")
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/Persona")
	public List<Persona> getAllvehiculos() {
		// The BookRepository is already injected and you can use it
		return personaRepository.findAll();
	}

	@GetMapping("/Persona/{id}")
	public ResponseEntity<Persona> getpersonaById(@PathVariable Integer id) { 
		
		if (personaRepository.existsById(id)) {
			Persona per = personaRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(per);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@PostMapping("/Personalist")
	public String createList(@RequestBody List<Persona> veh) {
		personaRepository.saveAll(veh);
		return "done";
	}
	
	@PostMapping("/Persona")
	public Persona createpersona(@RequestBody Persona per) {
		return personaRepository.save(per);
	}

	@PutMapping("/Persona/{id}")
	public Persona updatevehiculo(@PathVariable Integer id, @RequestBody Persona pernew) {
		Persona db = personaRepository.findById(id).get();
		
		db.setId(pernew.getId());
		db.setNombre(pernew.getNombre());
		db.setApellido(pernew.getApellido());
		db.setMunicipio(pernew.getMunicipio());
		db.setCorreo(pernew.getCorreo());
		db.setCedula(pernew.getCedula());
        
		personaRepository.save(db);
		return db;
	}
	
	@DeleteMapping("/Persona/{id}")
	public Persona deleteVehiculo(@PathVariable Integer id) {
		Persona db = personaRepository.findById(id).get();
		personaRepository.delete(db);
		return db;
	}


}
