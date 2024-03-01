package br.com.topone.backend.exception;

public class EntidadeEmUsoException extends RuntimeException{
    public EntidadeEmUsoException(String mensagem){
        super(mensagem);
    }
}
