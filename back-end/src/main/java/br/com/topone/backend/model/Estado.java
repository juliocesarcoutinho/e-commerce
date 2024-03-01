package br.com.topone.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "estado")
public class Estado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @NotNull
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
    
    @Column
    @NotNull
    @NotBlank(message = "O campo sigla é obrigatório")
    private String sigla;
    
    @Column(columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
}
