/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author Lee Tae Yong
 */
@Entity
@Table(name = "vehicles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findByIdVehicle", query = "SELECT v FROM Vehicle v WHERE v.idVehicle = :idVehicle")
    , @NamedQuery(name = "Vehicle.findByName", query = "SELECT v FROM Vehicle v WHERE v.name = :name")
    , @NamedQuery(name = "Vehicle.findByPlatNumber", query = "SELECT v FROM Vehicle v WHERE v.platNumber = :platNumber")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehicle")
    private Integer idVehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "plat_number")
    private String platNumber;
    @Lob
    @Column(name = "file")
    private byte[] file;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<TrReimburseVehicle> trReimburseVehicleList;
    @JoinColumn(name = "employee", referencedColumnName = "id_employee")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Vehicle() {
    }

    public Vehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public Vehicle(Integer idVehicle, String name, String platNumber) {
        this.idVehicle = idVehicle;
        this.name = name;
        this.platNumber = platNumber;
    }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatNumber() {
        return platNumber;
    }

    public void setPlatNumber(String platNumber) {
        this.platNumber = platNumber;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @XmlTransient
    public List<TrReimburseVehicle> getTrReimburseVehicleList() {
        return trReimburseVehicleList;
    }

    public void setTrReimburseVehicleList(List<TrReimburseVehicle> trReimburseVehicleList) {
        this.trReimburseVehicleList = trReimburseVehicleList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicle != null ? idVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.idVehicle == null && other.idVehicle != null) || (this.idVehicle != null && !this.idVehicle.equals(other.idVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.SpringSecurity.entities.Vehicle[ idVehicle=" + idVehicle + " ]";
    }
    
}
