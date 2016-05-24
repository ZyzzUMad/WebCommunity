/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebComm;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\contursi2667
 */
@Entity
@Table(name = "ARTISTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artisti.findAll", query = "SELECT a FROM Artisti a"),
    @NamedQuery(name = "Artisti.findById", query = "SELECT a FROM Artisti a WHERE a.id = :id"),
    @NamedQuery(name = "Artisti.findByNomeDArte", query = "SELECT a FROM Artisti a WHERE a.nomeDArte = :nomeDArte")})
public class Artisti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "NomeDArte")
    private String nomeDArte;
    @ManyToMany(mappedBy = "artistiCollection")
    private Collection<Eventi> eventiCollection;

    public Artisti() {
    }

    public Artisti(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDArte() {
        return nomeDArte;
    }

    public void setNomeDArte(String nomeDArte) {
        this.nomeDArte = nomeDArte;
    }

    @XmlTransient
    public Collection<Eventi> getEventiCollection() {
        return eventiCollection;
    }

    public void setEventiCollection(Collection<Eventi> eventiCollection) {
        this.eventiCollection = eventiCollection;
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
        if (!(object instanceof Artisti)) {
            return false;
        }
        Artisti other = (Artisti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Artisti[ id=" + id + " ]";
    }
    
}