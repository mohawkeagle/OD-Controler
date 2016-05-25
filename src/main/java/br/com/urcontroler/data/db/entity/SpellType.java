/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaciano Ghelere
 */
@Entity
@Table(name = "spell_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpellType.findAll", query = "SELECT s FROM SpellType s"),
    @NamedQuery(name = "SpellType.findByIdspellType", query = "SELECT s FROM SpellType s WHERE s.idspellType = :idspellType"),
    @NamedQuery(name = "SpellType.findByName", query = "SELECT s FROM SpellType s WHERE s.name = :name")})
public class SpellType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspell_type")
    private Long idspellType;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspellType")
    private Collection<Spell> spellCollection;

    public SpellType() {
    }

    public SpellType(Long idspellType) {
        this.idspellType = idspellType;
    }

    public SpellType(Long idspellType, String name) {
        this.idspellType = idspellType;
        this.name = name;
    }

    public Long getIdspellType() {
        return idspellType;
    }

    public void setIdspellType(Long idspellType) {
        this.idspellType = idspellType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Spell> getSpellCollection() {
        return spellCollection;
    }

    public void setSpellCollection(Collection<Spell> spellCollection) {
        this.spellCollection = spellCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspellType != null ? idspellType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpellType)) {
            return false;
        }
        SpellType other = (SpellType) object;
        if ((this.idspellType == null && other.idspellType != null) || (this.idspellType != null && !this.idspellType.equals(other.idspellType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.SpellType[ idspellType=" + idspellType + " ]";
    }

}
