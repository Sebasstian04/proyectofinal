package co.edu.poli.act3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.poli.act3.repository.PersonaRepository;
import co.edu.poli.act3.repository.UsuarioRepository;

import co.edu.poli.act3.model.Persona;
import co.edu.poli.act3.model.Receta;
import co.edu.poli.act3.model.Usuario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	// @Autowired
	// private EmpresaRepository empresaRepository;


	@GetMapping("/UsuarioPer/{id}")
	public List<Usuario> getusuariologin(@PathVariable String id) {
		System.out.println(id);
		return usuarioRepository.findByLogin(id);
	}

	@GetMapping("/UsuarioPersona/{id}")
	public ResponseEntity<Persona> getPersona(@PathVariable Integer id) {
		if (personaRepository.existsById(id)) {
			Persona rec = personaRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(rec);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}

	@PostMapping("/UsuarioPersona")
	public Persona savePersona(@RequestBody Persona persona) {
		personaRepository.save(persona);
		return persona;
	}

	@PutMapping("/UsuarioPersona/{id}")
	public Persona putPersona(@PathVariable Integer id, @RequestBody Persona pernew) {
		Persona db = personaRepository.findById(id).get();

		db.setId(pernew.getId());
		db.setNombre(pernew.getNombre());
		db.setApellido(pernew.getApellido());
		db.setMunicipio(pernew.getMunicipio());
		db.setCorreo(pernew.getCorreo());
		db.setCedula(pernew.getCedula());
		db.setLogin(pernew.getLogin());
		db.setPassword(pernew.getPassword());

		personaRepository.save(db);
		return db;
	}

	// @PostMapping("/UsuarioEmpresa")
	// public Empresa saveEmpresa(@RequestBody Empresa empresa) {
	// personaRepository.save(empresa);
	// return empresa;
	// }

}
