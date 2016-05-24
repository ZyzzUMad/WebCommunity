/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebComm;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\contursi2667
 */
@Entity
@Table(name = "COMMENTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commenti.findAll", query = "SELECT c FROM Commenti c"),
    @NamedQuery(name = "Commenti.findById", query = "SELECT c FROM Commenti c WHERE c.id = :id"),
    @NamedQuery(name = "Commenti.findByTesto", query = "SELECT c FROM Commenti c WHERE c.testo = :testo"),
    @NamedQuery(name = "Commenti.findByVoto", query = "SELECT c FROM Commenti c WHERE c.voto = :voto")})
public class Commenti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Testo")
    private String testo;
    @Column(name = "Voto")
    private Integer voto;
    @JoinColumn(name = "IdEvento", referencedColumnName = "Id")
    @ManyToOne
    private Eventi idEvento;
    @JoinColumn(name = "Nickname", referencedColumnName = "Nickname")
    @ManyToOne
    private Utenti nickname;

    public Commenti() {
    }

    public Commenti(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public Eventi getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Eventi idEvento) {
        this.idEvento = idEvento;
    }

    public Utenti getNickname() {
        return nickname;
    }

    public void setNickname(Utenti nickname) {
        this.nickname = nickname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commenti)) {
            return false;
        }
        Commenti other = (Commenti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Commenti[ id=" + id + " ]";
    }
    
}
