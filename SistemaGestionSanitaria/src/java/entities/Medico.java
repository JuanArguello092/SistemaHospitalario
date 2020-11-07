/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByDni", query = "SELECT m FROM Medico m WHERE m.dni = :dni")
    , @NamedQuery(name = "Medico.findByNombre", query = "SELECT m FROM Medico m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Medico.findByApellido", query = "SELECT m FROM Medico m WHERE m.apellido = :apellido")
    , @NamedQuery(name = "Medico.findByFechaNacimiento", query = "SELECT m FROM Medico m WHERE m.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Medico.findByOcupaDireccion", query = "SELECT m FROM Medico m WHERE m.ocupaDireccion = :ocupaDireccion")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private Integer dni;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "ocupa_direccion")
    private Boolean ocupaDireccion;
    @OneToMany(mappedBy = "dniMedico")
    private List<ConsultaMedica> consultaMedicaList;
    @JoinColumn(name = "cod_hospital", referencedColumnName = "codhospital")
    @ManyToOne
    private Hospital codHospital;
    @JoinColumn(name = "id_servicio", referencedColumnName = "idservicio")
    @ManyToOne
    private Servicio idServicio;

    public Medico() {
    }

    public Medico(Integer dni) {
        this.dni = dni;
    }

    public Medico(Integer dni, String nombre, String apellido, Date fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getOcupaDireccion() {
        return ocupaDireccion;
    }

    public void setOcupaDireccion(Boolean ocupaDireccion) {
        this.ocupaDireccion = ocupaDireccion;
    }

    @XmlTransient
    public List<ConsultaMedica> getConsultaMedicaList() {
        return consultaMedicaList;
    }

    public void setConsultaMedicaList(List<ConsultaMedica> consultaMedicaList) {
        this.consultaMedicaList = consultaMedicaList;
    }

    public Hospital getCodHospital() {
        return codHospital;
    }

    public void setCodHospital(Hospital codHospital) {
        this.codHospital = codHospital;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medico[ dni=" + dni + " ]";
    }
    
}
