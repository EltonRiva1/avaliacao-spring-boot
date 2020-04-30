package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import br.com.tokiomarine.seguradora.avaliacao.service.exception.ObjectDoesNotExist;
import br.com.tokiomarine.seguradora.avaliacao.service.exception.ObjectNotFoundException;

@Service
public class EstudanteService {
	@Autowired
	EstudanteRepository estudanteRepository;

	public List<Estudante> findAll() {
		// TODO Auto-generated method stub
		List<Estudante> estudantes = this.estudanteRepository.findAll();
		if (estudantes.isEmpty()) {
			throw new ObjectNotFoundException();
		}
		return estudantes;
	}

	public Estudante findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Estudante> optional = this.estudanteRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException());
	}

	public Estudante save(@Valid Estudante estudante) {
		// TODO Auto-generated method stub
		Estudante novoEstudante = this.estudanteRepository.save(estudante);
		return novoEstudante;
	}

	public Estudante update(Long id, @Valid Estudante estudante) {
		// TODO Auto-generated method stub
		Estudante estudanteExistente = this.estudanteRepository.findById(id)
				.orElseThrow(() -> new ObjectDoesNotExist());
		BeanUtils.copyProperties(estudante, estudanteExistente, "id");
		this.estudanteRepository.save(estudanteExistente);
		return estudanteExistente;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		try {
			this.estudanteRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ObjectDoesNotExist();
		}
	}

}
