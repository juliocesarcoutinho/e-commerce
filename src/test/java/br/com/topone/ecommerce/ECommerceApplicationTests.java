package br.com.topone.ecommerce;

import br.com.topone.ecommerce.controller.AcessoController;
import br.com.topone.ecommerce.model.Acesso;
import br.com.topone.ecommerce.repository.AcessoRepository;
import br.com.topone.ecommerce.services.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ECommerceApplication.class)
class ECommerceApplicationTests extends TestCase {

    @Autowired
    private AcessoController acessoController;

    @Test
    public void testCadastroAcesso() {
        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_DIRETOR");

        assertEquals(true, acesso.getId() == null);
        /*Grava no Banco */
        acessoController.salvarAcesso(acesso).getBody();

        assertEquals(true, acesso.getId() > 0); /*Verifica se tem um id no banco*/

        /*Verifca se veio o que foi gravado*/
        assertEquals("ROLE_DIRETOR", acesso.getDescricao());

    }

}
