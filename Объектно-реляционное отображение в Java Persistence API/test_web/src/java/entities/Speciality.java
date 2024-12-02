/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ang
 */
@Entity
@Table(name = "speciality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Speciality.findAll", query = "SELECT s FROM Speciality s"),
     @NamedQuery(name = "Speciality.getAll", query = "SELECT s FROM Speciality s")
    , @NamedQuery(name = "Speciality.findById", query = "SELECT s FROM Speciality s WHERE s.id = :id")
    , @NamedQuery(name = "Speciality.findByName", query = "SELECT s FROM Speciality s WHERE s.name = :name")
    , @NamedQuery(name = "Speciality.findByAbbrev", query = "SELECT s FROM Speciality s WHERE s.abbrev = :abbrev")})
public class Speciality implements Serializable {

    private static final long serialVersionUID = 1L;    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "abbrev")
    private String abbrev;
    @OneToMany(mappedBy = "specialityId")
    private List<Studentgroup> studentgroupList;

    public Speciality() {}

    public Speciality(Integer id) {
        this.id = id;
    }

    public Speciality(Integer id, String name, String abbrev) {
        this.id = id;
        this.name = name;
        this.abbrev = abbrev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    @XmlTransient
    public List<Studentgroup> getStudentgroupList() {
        return studentgroupList;
    }

    public void setStudentgroupList(List<Studentgroup> studentgroupList) {
        this.studentgroupList = studentgroupList;
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
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Speciality[ id=" + id + " ]";
    }
    
}
