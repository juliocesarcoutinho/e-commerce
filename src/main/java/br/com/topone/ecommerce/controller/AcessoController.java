package br.com.topone.ecommerce.controller;

import br.com.topone.ecommerce.model.Acesso;
import br.com.topone.ecommerce.services.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AcessoController {
    @Autowired
    private AcessoService acessoService;

    public void salvarAcesso(Acesso acesso){
        acessoService.save(acesso);    }
}
