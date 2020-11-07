/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "historial_clinico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialClinico.findAll", query = "SELECT h FROM HistorialClinico h")
    , @NamedQuery(name = "HistorialClinico.findByCodhistorial", query = "SELECT h FROM HistorialClinico h WHERE h.codhistorial = :codhistorial")})
public class HistorialClinico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codhistorial")
    private Integer codhistorial;
    @JoinColumn(name = "id_consulta", referencedColumnName = "id")
    @ManyToOne
    private ConsultaMedica idConsulta;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo")
    @ManyToOne
    private Paciente codigoPaciente;

    public HistorialClinico() {
    }

    public HistorialClinico(Integer codhistorial) {
        this.codhistorial = codhistorial;
    }

    public Integer getCodhistorial() {
        return codhistorial;
    }

    public void setCodhistorial(Integer codhistorial) {
        this.codhistorial = codhistorial;
    }

    public ConsultaMedica getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(ConsultaMedica idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codhistorial != null ? codhistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialClinico)) {
            return false;
        }
        HistorialClinico other = (HistorialClinico) object;
        if ((this.codhistorial == null && other.codhistorial != null) || (this.codhistorial != null && !this.codhistorial.equals(other.codhistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HistorialClinico[ codhistorial=" + codhistorial + " ]";
    }
    
}
