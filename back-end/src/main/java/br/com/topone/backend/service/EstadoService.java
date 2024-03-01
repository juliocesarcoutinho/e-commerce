package br.com.topone.backend.service;

import br.com.topone.backend.exception.EntidadeEmUsoException;
import br.com.topone.backend.exception.EntidadeNaoEncontradaException;
import br.com.topone.backend.model.Estado;
import br.com.topone.backend.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

    public Optional<Estado> buscar(Long id) {
        return estadoRepository.findById(id);
    }

    public void atualizar(Long id, Estado estadoAtual){
        Optional<Estado> estado = estadoRepository.findById(id);
        if (estado.isEmpty()){
            throw new EntidadeNaoEncontradaException(String.format("Estado com id %d não encontrado", id));
        } else {
            BeanUtils.copyProperties(estadoAtual, estado.get(), "id", "dataCriacao");
            estadoRepository.save(estado.get());
        }
    }


    public Estado adicionar(Estado estado){
        estado.setDataCriacao(new Date());
        return estadoRepository.save(estado);
    }

    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.save(estado);
    }

    public void remover(Long id){
        try {
            estadoRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Estado com código %d não encontrada", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Estado de código %d não pode ser removida, pois esta em uso", id));
        }
    }
    
}
