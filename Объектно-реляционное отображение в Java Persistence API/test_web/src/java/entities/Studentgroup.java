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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "studentgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentgroup.findAll", query = "SELECT s FROM Studentgroup s")
    , @NamedQuery(name = "Studentgroup.findById", query = "SELECT s FROM Studentgroup s WHERE s.id = :id")
    , @NamedQuery(name = "Studentgroup.findName", query = "SELECT s FROM Studentgroup s WHERE  s.name = :name")
    , @NamedQuery(name = "Studentgroup.findBySpecId", query = "SELECT s FROM Studentgroup s WHERE s.specialityId.id = :specialityId")
    , @NamedQuery(name = "Studentgroup.findByName", query = "SELECT s FROM Studentgroup s WHERE s.name = :name")
})
public class Studentgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "groupsId")
    private List<Student> studentList;
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    @ManyToOne
    private Speciality specialityId;

    public Studentgroup() {
    }

    public Studentgroup(Integer id) {
        this.id = id;
    }

    public Studentgroup(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Speciality getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Speciality specialityId) {
        this.specialityId = specialityId;
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
        if (!(object instanceof Studentgroup)) {
            return false;
        }
        Studentgroup other = (Studentgroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Studentgroup[ id=" + id + " ]";
    }

}
