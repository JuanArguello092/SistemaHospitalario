/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class HospitalServicioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codhospital")
    private int codhospital;
    @Basic(optional = false)
    @Column(name = "idservicio")
    private int idservicio;

    public HospitalServicioPK() {
    }

    public HospitalServicioPK(int codhospital, int idservicio) {
        this.codhospital = codhospital;
        this.idservicio = idservicio;
    }

    public int getCodhospital() {
        return codhospital;
    }

    public void setCodhospital(int codhospital) {
        this.codhospital = codhospital;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codhospital;
        hash += (int) idservicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HospitalServicioPK)) {
            return false;
        }
        HospitalServicioPK other = (HospitalServicioPK) object;
        if (this.codhospital != other.codhospital) {
            return false;
        }
        if (this.idservicio != other.idservicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HospitalServicioPK[ codhospital=" + codhospital + ", idservicio=" + idservicio + " ]";
    }
    
}
