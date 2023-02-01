package br.com.topone.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1)
public class Acesso implements GrantedAuthority  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long Id;
    @Column(nullable = false, length = 120)
    private String descricao; /*Exemplo Role_admin*/

    @Override
    public String getAuthority() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acesso acesso = (Acesso) o;

        return Id.equals(acesso.Id);
    }

    @Override
    public int hashCode() {
        return Id.hashCode();
    }
}
