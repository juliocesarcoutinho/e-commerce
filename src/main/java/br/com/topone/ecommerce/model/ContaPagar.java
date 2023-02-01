package br.com.topone.ecommerce.model;

import br.com.topone.ecommerce.enums.StatusContaPagar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "conta_pagar")
@SequenceGenerator(name = "seq_conta_pagar", sequenceName = "seq_conta_pagar", allocationSize = 1, initialValue = 1)
public class ContaPagar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_pagar")
    private Long id;

    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private BigDecimal valorTotal;

    private BigDecimal valorDesconto;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Temporal(TemporalType.DATE)
    private Date dtPagamento;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StatusContaPagar status;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
            name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_forn_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
            name = "pessoa_forn_fk"))
    private Pessoa pessoa_fornecedor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContaPagar that = (ContaPagar) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
