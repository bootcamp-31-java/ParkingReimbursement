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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "reimbursement_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReimbursementStatus.findAll", query = "SELECT r FROM ReimbursementStatus r")
    , @NamedQuery(name = "ReimbursementStatus.findByIdReimbursestatus", query = "SELECT r FROM ReimbursementStatus r WHERE r.idReimbursestatus = :idReimbursestatus")
    , @NamedQuery(name = "ReimbursementStatus.findByName", query = "SELECT r FROM ReimbursementStatus r WHERE r.name = :name")})
public class ReimbursementStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reimbursestatus")
    private Integer idReimbursestatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "id_reimbursestatus", referencedColumnName = "reimbursement_status", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ReimburseHistory reimburseHistory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status", fetch = FetchType.LAZY)
    private List<Reimbursement> reimbursementList;

    public ReimbursementStatus() {
    }

    public ReimbursementStatus(Integer idReimbursestatus) {
        this.idReimbursestatus = idReimbursestatus;
    }

    public ReimbursementStatus(Integer idReimbursestatus, String name) {
        this.idReimbursestatus = idReimbursestatus;
        this.name = name;
    }

    public Integer getIdReimbursestatus() {
        return idReimbursestatus;
    }

    public void setIdReimbursestatus(Integer idReimbursestatus) {
        this.idReimbursestatus = idReimbursestatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReimburseHistory getReimburseHistory() {
        return reimburseHistory;
    }

    public void setReimburseHistory(ReimburseHistory reimburseHistory) {
        this.reimburseHistory = reimburseHistory;
    }

    @XmlTransient
    public List<Reimbursement> getReimbursementList() {
        return reimbursementList;
    }

    public void setReimbursementList(List<Reimbursement> reimbursementList) {
        this.reimbursementList = reimbursementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReimbursestatus != null ? idReimbursestatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReimbursementStatus)) {
            return false;
        }
        ReimbursementStatus other = (ReimbursementStatus) object;
        if ((this.idReimbursestatus == null && other.idReimbursestatus != null) || (this.idReimbursestatus != null && !this.idReimbursestatus.equals(other.idReimbursestatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.SpringSecurity.entities.ReimbursementStatus[ idReimbursestatus=" + idReimbursestatus + " ]";
    }
    
}
