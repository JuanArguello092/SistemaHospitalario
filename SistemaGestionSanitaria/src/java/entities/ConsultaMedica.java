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
@Table(name = "consulta_medica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaMedica.findAll", query = "SELECT c FROM ConsultaMedica c")
    , @NamedQuery(name = "ConsultaMedica.findById", query = "SELECT c FROM ConsultaMedica c WHERE c.id = :id")
    , @NamedQuery(name = "ConsultaMedica.findByFecha", query = "SELECT c FROM ConsultaMedica c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "ConsultaMedica.findByHoraIngreso", query = "SELECT c FROM ConsultaMedica c WHERE c.horaIngreso = :horaIngreso")
    , @NamedQuery(name = "ConsultaMedica.findByHoraSalida", query = "SELECT c FROM ConsultaMedica c WHERE c.horaSalida = :horaSalida")
    , @NamedQuery(name = "ConsultaMedica.findByDiagnostico", query = "SELECT c FROM ConsultaMedica c WHERE c.diagnostico = :diagnostico")
    , @NamedQuery(name = "ConsultaMedica.findByTratamiento", query = "SELECT c FROM ConsultaMedica c WHERE c.tratamiento = :tratamiento")
    , @NamedQuery(name = "ConsultaMedica.findByNroHabitacion", query = "SELECT c FROM ConsultaMedica c WHERE c.nroHabitacion = :nroHabitacion")})
public class ConsultaMedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora_ingreso")
    @Temporal(TemporalType.TIME)
    private Date horaIngreso;
    @Basic(optional = false)
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "tratamiento")
    private String tratamiento;
    @Column(name = "nro_habitacion")
    private Integer nroHabitacion;
    @JoinColumn(name = "cod_hospital", referencedColumnName = "codhospital")
    @ManyToOne
    private Hospital codHospital;
    @JoinColumn(name = "dni_medico", referencedColumnName = "dni")
    @ManyToOne
    private Medico dniMedico;
    @JoinColumn(name = "id_servicio", referencedColumnName = "idservicio")
    @ManyToOne
    private Servicio idServicio;
    @OneToMany(mappedBy = "idConsulta")
    private List<HistorialClinico> historialClinicoList;

    public ConsultaMedica() {
    }

    public ConsultaMedica(Integer id) {
        this.id = id;
    }

    public ConsultaMedica(Integer id, Date fecha, Date horaIngreso, Date horaSalida) {
        this.id = id;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Integer getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(Integer nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public Hospital getCodHospital() {
        return codHospital;
    }

    public void setCodHospital(Hospital codHospital) {
        this.codHospital = codHospital;
    }

    public Medico getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(Medico dniMedico) {
        this.dniMedico = dniMedico;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @XmlTransient
    public List<HistorialClinico> getHistorialClinicoList() {
        return historialClinicoList;
    }

    public void setHistorialClinicoList(List<HistorialClinico> historialClinicoList) {
        this.historialClinicoList = historialClinicoList;
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
        if (!(object instanceof ConsultaMedica)) {
            return false;
        }
        ConsultaMedica other = (ConsultaMedica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ConsultaMedica[ id=" + id + " ]";
    }
    
}
