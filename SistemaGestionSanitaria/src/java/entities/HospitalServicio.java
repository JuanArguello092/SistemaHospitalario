/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "hospital_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HospitalServicio.findAll", query = "SELECT h FROM HospitalServicio h")
    , @NamedQuery(name = "HospitalServicio.findByCodhospital", query = "SELECT h FROM HospitalServicio h WHERE h.hospitalServicioPK.codhospital = :codhospital")
    , @NamedQuery(name = "HospitalServicio.findByIdservicio", query = "SELECT h FROM HospitalServicio h WHERE h.hospitalServicioPK.idservicio = :idservicio")
    , @NamedQuery(name = "HospitalServicio.findByNroCama", query = "SELECT h FROM HospitalServicio h WHERE h.nroCama = :nroCama")})
public class HospitalServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HospitalServicioPK hospitalServicioPK;
    @Column(name = "nro_cama")
    private Integer nroCama;
    @JoinColumn(name = "codhospital", referencedColumnName = "codhospital", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hospital hospital;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;

    public HospitalServicio() {
    }

    public HospitalServicio(HospitalServicioPK hospitalServicioPK) {
        this.hospitalServicioPK = hospitalServicioPK;
    }

    public HospitalServicio(int codhospital, int idservicio) {
        this.hospitalServicioPK = new HospitalServicioPK(codhospital, idservicio);
    }

    public HospitalServicioPK getHospitalServicioPK() {
        return hospitalServicioPK;
    }

    public void setHospitalServicioPK(HospitalServicioPK hospitalServicioPK) {
        this.hospitalServicioPK = hospitalServicioPK;
    }

    public Integer getNroCama() {
        return nroCama;
    }

    public void setNroCama(Integer nroCama) {
        this.nroCama = nroCama;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospitalServicioPK != null ? hospitalServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HospitalServicio)) {
            return false;
        }
        HospitalServicio other = (HospitalServicio) object;
        if ((this.hospitalServicioPK == null && other.hospitalServicioPK != null) || (this.hospitalServicioPK != null && !this.hospitalServicioPK.equals(other.hospitalServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HospitalServicio[ hospitalServicioPK=" + hospitalServicioPK + " ]";
    }
    
}
