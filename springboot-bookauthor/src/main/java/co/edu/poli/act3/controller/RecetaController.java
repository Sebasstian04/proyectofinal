package co.edu.poli.act3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import co.edu.poli.act3.repository.RecetaRepository;

import co.edu.poli.act3.model.Receta;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class RecetaController {

	@Autowired
	private RecetaRepository recetaRepository;

	@GetMapping("/Receta")
	public List<Receta> getRecetas() {
		return recetaRepository.findAll();
	}

	@GetMapping("/Receta/{id}")
	public ResponseEntity<Receta> getRecetas(@PathVariable Integer id) {
		if (recetaRepository.existsById(id)) {
			Receta rec = recetaRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(rec);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}

	@PostMapping("/Receta")
	public Receta saveReceta(@RequestBody Receta receta) {
		recetaRepository.save(receta);
		return receta;
	}

	@PostMapping("/Recetas")
	public String saveRecetas(@RequestBody List<Receta> List) {
		recetaRepository.saveAll(List);
		return "done";
	}

	@PutMapping("/Receta/{id}")
	public Receta putReceta(@PathVariable Integer id, @RequestBody Receta receta) {

		Receta db = recetaRepository.findById(id).get();
		
		db.setNombre(receta.getNombre());
		db.setCantidad(receta.getCantidad());
		db.setIngredientes(receta.getIngredientes());
		db.setDescripcion(receta.getDescripcion());

		recetaRepository.save(db);
		return db;
	}

	@DeleteMapping("/Receta/{id}")
	public Receta deleteReceta(@PathVariable Integer id) {
		Receta a = recetaRepository.findById(id).get();
		recetaRepository.deleteById(id);
		return a;
	}

}
