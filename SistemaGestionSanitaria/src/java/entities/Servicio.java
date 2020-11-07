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
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByIdservicio", query = "SELECT s FROM Servicio s WHERE s.idservicio = :idservicio")
    , @NamedQuery(name = "Servicio.findByAcronimoServicio", query = "SELECT s FROM Servicio s WHERE s.acronimoServicio = :acronimoServicio")
    , @NamedQuery(name = "Servicio.findByNombreServicio", query = "SELECT s FROM Servicio s WHERE s.nombreServicio = :nombreServicio")
    , @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idservicio")
    private Integer idservicio;
    @Basic(optional = false)
    @Column(name = "acronimo_servicio")
    private String acronimoServicio;
    @Basic(optional = false)
    @Column(name = "nombre_servicio")
    private String nombreServicio;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idServicio")
    private List<ConsultaMedica> consultaMedicaList;
    @OneToMany(mappedBy = "idServicio")
    private List<Medico> medicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
    private List<HospitalServicio> hospitalServicioList;

    public Servicio() {
    }

    public Servicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public Servicio(Integer idservicio, String acronimoServicio, String nombreServicio) {
        this.idservicio = idservicio;
        this.acronimoServicio = acronimoServicio;
        this.nombreServicio = nombreServicio;
    }

    public Integer getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public String getAcronimoServicio() {
        return acronimoServicio;
    }

    public void setAcronimoServicio(String acronimoServicio) {
        this.acronimoServicio = acronimoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Servicio[ idservicio=" + idservicio + " ]";
    }
    
}
