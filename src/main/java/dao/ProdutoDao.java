package dao;

import entities.ProdutoEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Stateless
public class ProdutoDao {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public List<ProdutoEntity> getProdutos() {
        return (List<ProdutoEntity>) em.createNamedQuery("Produto.findAll").getResultList();
    }

    public List<ProdutoEntity> getProdutosCategoria(String categoria) {
        return (List<ProdutoEntity>) em.createNamedQuery("Produto.findAllCategory").setParameter("categoria", categoria).getResultList();
    }

    public List<String> getCategoriasDisponiveis() {
        return (List<String>) em.createQuery("SELECT DISTINCT(p.categoria) FROM ProdutoEntity  p").getResultList();
    }

    public ProdutoEntity criarProduto(ProdutoEntity produtoEntity) {
        em.persist(produtoEntity);
        return produtoEntity;
    }

    public ProdutoEntity getProdutoId(String id) {
        try {
            ProdutoEntity temp = (ProdutoEntity) em.createNamedQuery("Produto.findById").setParameter("id", id).getSingleResult();
            return temp;
        } catch (Exception e) {
            return null;
        }

    }

    public ProdutoEntity getProdutoModelo(String modelo) {
        try {
            ProdutoEntity temp = (ProdutoEntity) em.createNamedQuery("Produto.findByModelo").setParameter("modelo", modelo).getSingleResult();
            return temp;
        } catch (Exception e) {
            return null;
        }

    }

}