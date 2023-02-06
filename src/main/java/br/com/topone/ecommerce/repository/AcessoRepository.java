package br.com.topone.ecommerce.repository;

import br.com.topone.ecommerce.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long> {
    @Query("SELECT A FROM Acesso A WHERE UPPER(TRIM(A.descricao)) LIKE %?1%")
    List<Acesso> buscarAcessoDesc(String desc);
}
