package br.com.topone.ecommerce.controller;

import br.com.topone.ecommerce.model.Acesso;
import br.com.topone.ecommerce.repository.AcessoRepository;
import br.com.topone.ecommerce.services.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class AcessoController {
    @Autowired
    private AcessoService acessoService;
    @Autowired
    private AcessoRepository acessoRepository;

    @ResponseBody
    @PostMapping(value = "/salvarAcesso")
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso){

        Acesso acessoSalvo = acessoService.save(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/deleteAcesso")
    public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso){

        acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity<>("Acesso Removido",HttpStatus.OK);

    }

    @ResponseBody
    @DeleteMapping(value = "/deleteAcessoPorId/{id}")
    public ResponseEntity<?> deleteAcessoPorId(@PathVariable("id") Long id){

        acessoRepository.deleteById(id);
        return new ResponseEntity<>("Acesso Removido",HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/listarAcessoDesc/{desc}")
    public ResponseEntity<List<Acesso>> listarAcessoPorDesc(@PathVariable("desc") String desc){

        List<Acesso> acessos = acessoRepository.buscarAcessoDesc(desc);
        return new ResponseEntity<List<Acesso>>(acessos, HttpStatus.OK);

    }

    @ResponseBody
    @GetMapping(value = "/listarAcessoPorId/{id}")
    public ResponseEntity<?> listarAcessoPorId(@PathVariable("id") Long id){

        Acesso acesso = acessoRepository.findById(id).get();
        return new ResponseEntity<>(acesso,HttpStatus.OK);

    }

}
