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
@Table(name = "tr_reimburse_vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrReimburseVehicle.findAll", query = "SELECT t FROM TrReimburseVehicle t")
    , @NamedQuery(name = "TrReimburseVehicle.findByIdTrReimbursementVehicle", query = "SELECT t FROM TrReimburseVehicle t WHERE t.idTrReimbursementVehicle = :idTrReimbursementVehicle")
    , @NamedQuery(name = "TrReimburseVehicle.findBySum", query = "SELECT t FROM TrReimburseVehicle t WHERE t.sum = :sum")})
public class TrReimburseVehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_tr_reimbursement_vehicle")
    private String idTrReimbursementVehicle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sum")
    private int sum;
    @JoinColumn(name = "reimbursement", referencedColumnName = "id_reimbursement")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reimbursement reimbursement;
    @JoinColumn(name = "vehicle", referencedColumnName = "id_vehicle")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehicle vehicle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trReimburse", fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    public TrReimburseVehicle() {
    }

    public TrReimburseVehicle(String idTrReimbursementVehicle) {
        this.idTrReimbursementVehicle = idTrReimbursementVehicle;
    }

    public TrReimburseVehicle(String idTrReimbursementVehicle, int sum) {
        this.idTrReimbursementVehicle = idTrReimbursementVehicle;
        this.sum = sum;
    }

    public String getIdTrReimbursementVehicle() {
        return idTrReimbursementVehicle;
    }

    public void setIdTrReimbursementVehicle(String idTrReimbursementVehicle) {
        this.idTrReimbursementVehicle = idTrReimbursementVehicle;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Reimbursement getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Reimbursement reimbursement) {
        this.reimbursement = reimbursement;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrReimbursementVehicle != null ? idTrReimbursementVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrReimburseVehicle)) {
            return false;
        }
        TrReimburseVehicle other = (TrReimburseVehicle) object;
        if ((this.idTrReimbursementVehicle == null && other.idTrReimbursementVehicle != null) || (this.idTrReimbursementVehicle != null && !this.idTrReimbursementVehicle.equals(other.idTrReimbursementVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.SpringSecurity.entities.TrReimburseVehicle[ idTrReimbursementVehicle=" + idTrReimbursementVehicle + " ]";
    }
    
}
