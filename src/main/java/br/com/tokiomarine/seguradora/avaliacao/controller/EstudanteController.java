package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@CrossOrigin("*")
@Api(value = "API REST Estudantes")
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	private EstudanteService estudanteService;

	@ApiOperation(value = "Retorna uma lista de estudantes")
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Estudante> estudantes = this.estudanteService.findAll();
		return ResponseEntity.ok(estudantes);
	}

	@ApiOperation(value = "Pesquisar estudante por id")
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Estudante estudante = this.estudanteService.findById(id);
		return ResponseEntity.ok(estudante);
	}

	@ApiOperation(value = "Salva um estudante")
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Estudante estudante) {
		Estudante novoEstudante = this.estudanteService.save(estudante);
		return ResponseEntity.ok(novoEstudante);
	}

	@ApiOperation(value = "Atualiza estudante por id")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Estudante estudante) {
		Estudante estudanteExistente = this.estudanteService.update(id, estudante);
		return ResponseEntity.ok(estudanteExistente);
	}

	@ApiOperation(value = "Deleta um estudante por id")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.estudanteService.delete(id);
	}
}
