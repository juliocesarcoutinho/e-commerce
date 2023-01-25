package br.com.topone.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name ="pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa {


    @Column(nullable = false, length = 18)
    private String cnpj;
    @Column(nullable = false, length = 15)
    private String inscEstadual;
    private String inscMunicipal;
    @Column(length = 120)
    private String nomeFantasia;
    @Column(nullable = false, length = 120)
    private String razaoSocial;
    private String categoria;


}
