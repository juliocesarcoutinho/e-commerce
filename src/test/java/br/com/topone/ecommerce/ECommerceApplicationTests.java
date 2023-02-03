package br.com.topone.ecommerce;

import br.com.topone.ecommerce.model.Acesso;
import br.com.topone.ecommerce.repository.AcessoRepository;
import br.com.topone.ecommerce.services.AcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ECommerceApplication.class)
class ECommerceApplicationTests {

    @Autowired
    private AcessoService acessoService;

    @Test
    public void testCadastroAcesso() {
        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_DIRETOR");
        acessoService.save(acesso);
    }

}
