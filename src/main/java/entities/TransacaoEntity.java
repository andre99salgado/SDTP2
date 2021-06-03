package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transacao", schema = "moveis")
@NamedQueries({
        @NamedQuery(name = "transacao.findAll", query = "SELECT t from TransacaoEntity t"),
        @NamedQuery(name = "transacao.findAllUserID", query = "SELECT t from TransacaoEntity t WHERE t.utilizadorId = :utilizadorId"),

})
public class TransacaoEntity {
    private Long id;
    private String tipo;
    private int quantidade;
    private Date data;
    private int produtoId;


    private int utilizadorId;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "quantidade")
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Basic
    @Column(name = "data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "produtoId")
    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Basic
    @Column(name = "utilizadorId")
    public int getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(int utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransacaoEntity that = (TransacaoEntity) o;

        if (quantidade != that.quantidade) return false;
        if (produtoId != that.produtoId) return false;
        if (utilizadorId != that.utilizadorId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = tipo != null ? tipo.hashCode() : 0;
        result = 31 * result + quantidade;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + produtoId;
        result = 31 * result + utilizadorId;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
