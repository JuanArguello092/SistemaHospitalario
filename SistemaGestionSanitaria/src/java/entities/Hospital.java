/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h")
    , @NamedQuery(name = "Hospital.findByCodhospital", query = "SELECT h FROM Hospital h WHERE h.codhospital = :codhospital")
    , @NamedQuery(name = "Hospital.findByNombre", query = "SELECT h FROM Hospital h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Hospital.findByCiudad", query = "SELECT h FROM Hospital h WHERE h.ciudad = :ciudad")
    , @NamedQuery(name = "Hospital.findByTelefono", query = "SELECT h FROM Hospital h WHERE h.telefono = :telefono")
    , @NamedQuery(name = "Hospital.findByNombreDirector", query = "SELECT h FROM Hospital h WHERE h.nombreDirector = :nombreDirector")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codhospital")
    private Integer codhospital;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "nombre_director")
    private String nombreDirector;
    @OneToMany(mappedBy = "codHospital")
    private List<ConsultaMedica> consultaMedicaList;
    @OneToMany(mappedBy = "codHospital")
    private List<Medico> medicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital")
    private List<HospitalServicio> hospitalServicioList;

    public Hospital() {
    }

    public Hospital(Integer codhospital) {
        this.codhospital = codhospital;
    }

    public Hospital(Integer codhospital, String nombre, String ciudad, String telefono) {
        this.codhospital = codhospital;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public Integer getCodhospital() {
        return codhospital;
    }

    public void setCodhospital(Integer codhospital) {
        this.codhospital = codhospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    @XmlTransient
    public List<ConsultaMedica> getConsultaMedicaList() {
        return consultaMedicaList;
    }

    public void setConsultaMedicaList(List<ConsultaMedica> consultaMedicaList) {
        this.consultaMedicaList = consultaMedicaList;
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @XmlTransient
    public List<HospitalServicio> getHospitalServicioList() {
        return hospitalServicioList;
    }

    public void setHospitalServicioList(List<HospitalServicio> hospitalServicioList) {
        this.hospitalServicioList = hospitalServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codhospital != null ? codhospital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.codhospital == null && other.codhospital != null) || (this.codhospital != null && !this.codhospital.equals(other.codhospital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hospital[ codhospital=" + codhospital + " ]";
    }
    
}
