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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\contursi2667
 */
@Entity
@Table(name = "UTENTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utenti.findAll", query = "SELECT u FROM Utenti u"),
    @NamedQuery(name = "Utenti.findByNickname", query = "SELECT u FROM Utenti u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "Utenti.findByNome", query = "SELECT u FROM Utenti u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utenti.findByCognome", query = "SELECT u FROM Utenti u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "Utenti.findByEmail", query = "SELECT u FROM Utenti u WHERE u.email = :email")})
public class Utenti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Nickname")
    private String nickname;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Cognome")
    private String cognome;
    @Column(name = "Email")
    private String email;
    @JoinTable(name = "INTERESSI", joinColumns = {
        @JoinColumn(name = "Nickname", referencedColumnName = "Nickname")}, inverseJoinColumns = {
        @JoinColumn(name = "Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Categorie> categorieCollection;
    @OneToMany(mappedBy = "nickname")
    private Collection<Eventi> eventiCollection;
    @OneToMany(mappedBy = "nickname")
    private Collection<Commenti> commentiCollection;

    public Utenti() {
    }

    public Utenti(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Categorie> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categorie> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    @XmlTransient
    public Collection<Eventi> getEventiCollection() {
        return eventiCollection;
    }

    public void setEventiCollection(Collection<Eventi> eventiCollection) {
        this.eventiCollection = eventiCollection;
    }

    @XmlTransient
    public Collection<Commenti> getCommentiCollection() {
        return commentiCollection;
    }

    public void setCommentiCollection(Collection<Commenti> commentiCollection) {
        this.commentiCollection = commentiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utenti)) {
            return false;
        }
        Utenti other = (Utenti) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Utenti[ nickname=" + nickname + " ]";
    }
    
}
