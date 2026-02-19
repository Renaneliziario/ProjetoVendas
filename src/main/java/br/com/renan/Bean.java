package br.com.renan;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("bean")
@ViewScoped
public class Bean implements Serializable {
    private String mensagem;
    private String resultado = "";

    public String enviar() {
        resultado = "Você digitou: " + (mensagem != null ? mensagem : "");
        return null;
    }

    // Getters e Setters
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getResultado() {
        return resultado;
    }
}
