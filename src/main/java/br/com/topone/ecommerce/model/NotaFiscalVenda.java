package br.com.topone.ecommerce.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "nota_fiscal_venda")
@SequenceGenerator(name = "seq_nota_fiscal_venda", sequenceName = "seq_nota_fiscal_venda",
        allocationSize = 1, initialValue = 1)
public class NotaFiscalVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_venda")
    private Long id;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String serie;
    @Column(nullable = false)
    private String tipo;

    @Column(columnDefinition = "text", nullable = false)
    private String xml;

    @Column(columnDefinition = "text", nullable = false)
    private String pdf;

    @OneToOne
    @JoinColumn(name = "venda_compra_loja_virt_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_virt_fk"))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaFiscalVenda that = (NotaFiscalVenda) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
