package br.com.renan.dao;

import br.com.renan.model.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoDao {

    @PersistenceContext(unitName = "ProjetoVendasPU")
    private EntityManager em;

    public void salvar(Produto produto) {
        em.persist(produto);
    }

    public void atualizar(Produto produto) {
        em.merge(produto);
    }

    public void remover(Long id) {
        Produto p = em.find(Produto.class, id);
        if (p != null) em.remove(p);
    }

    public Produto buscar(Long id) {
        return em.find(Produto.class, id);
    }

    public Produto buscarPorCodigo(String codigo) {
        return em.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo", Produto.class)
                 .setParameter("codigo", codigo)
                 .getResultStream().findFirst().orElse(null);
    }

    public List<Produto> listar() {
        return em.createQuery("SELECT p FROM Produto p ORDER BY p.nome", Produto.class)
                 .getResultList();
    }
}
