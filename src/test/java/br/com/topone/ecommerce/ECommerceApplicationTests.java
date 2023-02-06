package br.com.topone.ecommerce;

import br.com.topone.ecommerce.controller.AcessoController;
import br.com.topone.ecommerce.model.Acesso;
import br.com.topone.ecommerce.repository.AcessoRepository;
import br.com.topone.ecommerce.services.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@SpringBootTest(classes = ECommerceApplication.class)
class ECommerceApplicationTests extends TestCase {

    @Autowired
    private AcessoController acessoController;

    @Autowired
    private AcessoRepository acessoRepository;

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

        //Teste de Carregamento testando os repositorios
        Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();

        assertEquals(acesso.getId(), acesso2.getId());

        //Teste de delete da camada de persistencia
        acessoRepository.deleteById(acesso2.getId());
        acessoRepository.flush(); /*Roda o sql no banco*/
        Acesso acesso3 = acessoRepository.findById(acesso.getId()).orElse(null);

        assertEquals(true, acesso3 == null);

        /*Teste de query*/
        acesso =new Acesso();
        acesso.setDescricao("ROLE_TESTE");
        acesso = acessoController.salvarAcesso(acesso).getBody();

        List<Acesso> acessos = acessoRepository.buscarAcessoDesc("TESTE".trim().toUpperCase());

        assertEquals(1, acessos.size());
        acessoRepository.deleteById(acesso.getId());

    }

}
