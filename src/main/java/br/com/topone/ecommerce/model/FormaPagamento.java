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
    @Table(name = "forma_pagamento")
    @SequenceGenerator(name = "seq_forma_pagamento", sequenceName = "seq_forma_pagamento", allocationSize = 1,
            initialValue = 1)
    public class FormaPagamento implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_forma_pagamento")
        private Long Id;

        @Column(nullable = false)
        private String descricao;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FormaPagamento that = (FormaPagamento) o;

            return Id.equals(that.Id);
        }

        @Override
        public int hashCode() {
            return Id.hashCode();
        }
    }
