/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lee Tae Yong
 */
@Entity
@Table(name = "reimbursement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reimbursement.findAll", query = "SELECT r FROM Reimbursement r")
    , @NamedQuery(name = "Reimbursement.findByIdReimbursement", query = "SELECT r FROM Reimbursement r WHERE r.idReimbursement = :idReimbursement")
    , @NamedQuery(name = "Reimbursement.findByPeriode", query = "SELECT r FROM Reimbursement r WHERE r.periode = :periode")
    , @NamedQuery(name = "Reimbursement.findByTotal", query = "SELECT r FROM Reimbursement r WHERE r.total = :total")})
public class Reimbursement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_reimbursement")
    private String idReimbursement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periode")
    @Temporal(TemporalType.DATE)
    private Date periode;
    @Column(name = "total")
    private Integer total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reimbursement", fetch = FetchType.LAZY)
    private List<TrReimburseVehicle> trReimburseVehicleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reimbursement", fetch = FetchType.LAZY)
    private List<ReimburseHistory> reimburseHistoryList;
    @JoinColumn(name = "status", referencedColumnName = "id_reimbursestatus")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReimbursementStatus status;
    @JoinColumn(name = "employee", referencedColumnName = "id_employee")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Reimbursement() {
    }

    public Reimbursement(String idReimbursement) {
        this.idReimbursement = idReimbursement;
    }

    public Reimbursement(String idReimbursement, Date periode) {
        this.idReimbursement = idReimbursement;
        this.periode = periode;
    }

    public String getIdReimbursement() {
        return idReimbursement;
    }

    public void setIdReimbursement(String idReimbursement) {
        this.idReimbursement = idReimbursement;
    }

    public Date getPeriode() {
        return periode;
    }

    public void setPeriode(Date periode) {
        this.periode = periode;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @XmlTransient
    public List<TrReimburseVehicle> getTrReimburseVehicleList() {
        return trReimburseVehicleList;
    }

    public void setTrReimburseVehicleList(List<TrReimburseVehicle> trReimburseVehicleList) {
        this.trReimburseVehicleList = trReimburseVehicleList;
    }

    @XmlTransient
    public List<ReimburseHistory> getReimburseHistoryList() {
        return reimburseHistoryList;
    }

    public void setReimburseHistoryList(List<ReimburseHistory> reimburseHistoryList) {
        this.reimburseHistoryList = reimburseHistoryList;
    }

    public ReimbursementStatus getStatus() {
        return status;
    }

    public void setStatus(ReimbursementStatus status) {
        this.status = status;
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
        hash += (idReimbursement != null ? idReimbursement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reimbursement)) {
            return false;
        }
        Reimbursement other = (Reimbursement) object;
        if ((this.idReimbursement == null && other.idReimbursement != null) || (this.idReimbursement != null && !this.idReimbursement.equals(other.idReimbursement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.SpringSecurity.entities.Reimbursement[ idReimbursement=" + idReimbursement + " ]";
    }
    
}
