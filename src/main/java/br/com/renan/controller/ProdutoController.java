package br.com.renan.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.renan.exception.NegocioException;
import br.com.renan.model.Produto;
import br.com.renan.service.ProdutoService;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

    @Inject
    private ProdutoService service;

    private Produto produto = new Produto();
    private List<Produto> produtos;

    public void salvar() {
        try {
            service.salvar(produto);
            produto = new Produto();
            produtos = null;
            addMensagem("Produto salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (NegocioException e) {
            addMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void remover(Long id) {
        service.remover(id);
        produtos = null;
        addMensagem("Produto removido!", FacesMessage.SEVERITY_INFO);
    }

    public void prepararEdicao(Produto p) {
        this.produto = p;
    }

    public void cancelarEdicao() {
        this.produto = new Produto();
    }

    public void atualizar() {
        try {
            service.atualizar(produto);
            produto = new Produto();
            produtos = null;
            addMensagem("Produto atualizado!", FacesMessage.SEVERITY_INFO);
        } catch (NegocioException e) {
            addMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<Produto> getProdutos() {
        if (produtos == null) {
            produtos = service.listar();
        }
        return produtos;
    }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    private void addMensagem(String msg, FacesMessage.Severity tipo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, msg, null));
    }
}
