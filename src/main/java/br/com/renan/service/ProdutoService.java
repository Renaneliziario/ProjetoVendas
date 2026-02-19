package br.com.renan.service;

import br.com.renan.dao.ProdutoDao;
import br.com.renan.exception.NegocioException;
import br.com.renan.model.Produto;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@Stateless
public class ProdutoService {

    @Inject
    private ProdutoDao dao;

    public void salvar(Produto produto) throws NegocioException {
        validar(produto);
        dao.salvar(produto);
    }

    public void atualizar(Produto produto) throws NegocioException {
        validar(produto);
        dao.atualizar(produto);
    }

    public void remover(Long id) {
        dao.remover(id);
    }

    public List<Produto> listar() {
        return dao.listar();
    }

    public Produto buscar(Long id) {
        return dao.buscar(id);
    }

    private void validar(Produto p) throws NegocioException {
        if (p.getCodigo() == null || p.getCodigo().isEmpty()) {
            throw new NegocioException("O código do produto é obrigatório.");
        }

        Produto produtoExistente = dao.buscarPorCodigo(p.getCodigo());
        if (produtoExistente != null && (p.getId() == null || !produtoExistente.getId().equals(p.getId()))) {
            throw new NegocioException("Já existe um produto com o código informado.");
        }

        if (p.getNome() == null || p.getNome().isEmpty()) {
            throw new NegocioException("O nome do produto é obrigatório.");
        }
        if (p.getPrecoVenda() == null || p.getPrecoVenda().compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegocioException("O preço deve ser maior que zero.");
        }
    }
}
