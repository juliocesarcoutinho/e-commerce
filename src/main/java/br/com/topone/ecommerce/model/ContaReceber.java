package br.com.topone.ecommerce.model;

import br.com.topone.ecommerce.enums.StatusContaReceber;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "conta_receber")
@SequenceGenerator(name = "seq_conta_receber", sequenceName = "seq_conta_receber", allocationSize = 1, initialValue = 1)
public class ContaReceber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
    private Long id;

    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusContaReceber status;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Temporal(TemporalType.DATE)
    private Date dtPagamento;
    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private BigDecimal valorDesconto;

    @ManyToOne(targetEntity = Pessoa.class) /* Muitas contas para uma pessoa*/
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
            name = "pessoa_fk"))
    private Pessoa pessoa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContaReceber that = (ContaReceber) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
