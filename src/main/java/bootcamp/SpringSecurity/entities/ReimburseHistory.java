/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lee Tae Yong
 */
@Entity
@Table(name = "reimburse_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReimburseHistory.findAll", query = "SELECT r FROM ReimburseHistory r")
    , @NamedQuery(name = "ReimburseHistory.findByIdReimburseHistory", query = "SELECT r FROM ReimburseHistory r WHERE r.idReimburseHistory = :idReimburseHistory")
    , @NamedQuery(name = "ReimburseHistory.findByReimbursementStatus", query = "SELECT r FROM ReimburseHistory r WHERE r.reimbursementStatus = :reimbursementStatus")
    , @NamedQuery(name = "ReimburseHistory.findByCreateDate", query = "SELECT r FROM ReimburseHistory r WHERE r.createDate = :createDate")})
public class ReimburseHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_reimburse_history")
    private String idReimburseHistory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reimbursement_status")
    private int reimbursementStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @JoinColumn(name = "reimbursement", referencedColumnName = "id_reimbursement")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reimbursement reimbursement;
    @JoinColumn(name = "employee", referencedColumnName = "id_employee")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reimburseHistory", fetch = FetchType.LAZY)
    private ReimbursementStatus reimbursementStatus1;

    public ReimburseHistory() {
    }

    public ReimburseHistory(String idReimburseHistory) {
        this.idReimburseHistory = idReimburseHistory;
    }

    public ReimburseHistory(String idReimburseHistory, int reimbursementStatus, Date createDate) {
        this.idReimburseHistory = idReimburseHistory;
        this.reimbursementStatus = reimbursementStatus;
        this.createDate = createDate;
    }

    public String getIdReimburseHistory() {
        return idReimburseHistory;
    }

    public void setIdReimburseHistory(String idReimburseHistory) {
        this.idReimburseHistory = idReimburseHistory;
    }

    public int getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(int reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Reimbursement getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Reimbursement reimbursement) {
        this.reimbursement = reimbursement;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ReimbursementStatus getReimbursementStatus1() {
        return reimbursementStatus1;
    }

    public void setReimbursementStatus1(ReimbursementStatus reimbursementStatus1) {
        this.reimbursementStatus1 = reimbursementStatus1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReimburseHistory != null ? idReimburseHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReimburseHistory)) {
            return false;
        }
        ReimburseHistory other = (ReimburseHistory) object;
        if ((this.idReimburseHistory == null && other.idReimburseHistory != null) || (this.idReimburseHistory != null && !this.idReimburseHistory.equals(other.idReimburseHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.SpringSecurity.entities.ReimburseHistory[ idReimburseHistory=" + idReimburseHistory + " ]";
    }
    
}
