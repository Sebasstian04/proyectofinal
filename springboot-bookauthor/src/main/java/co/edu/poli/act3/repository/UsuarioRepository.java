package co.edu.poli.act3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.act3.model.Persona;
import co.edu.poli.act3.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, JpaSpecificationExecutor<Usuario> {
	
	@Query(nativeQuery = true, value =" SELECT p FROM usuario p WHERE login = ?1")
	List<Usuario> findByLogin(String login);

}
