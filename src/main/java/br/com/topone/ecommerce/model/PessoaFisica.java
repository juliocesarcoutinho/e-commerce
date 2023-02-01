package br.com.topone.ecommerce.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name ="pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa{
    @Column(nullable = false, length = 14)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(length = 10)
    private Date dataNacimento;



}
