package com.geo.ignite.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CInventory implements Cloneable,Serializable {

    @QuerySqlField(index = true)
    private String id;

    @QuerySqlField(index = true)
    private String schedulenoka;

    private String tripid;

    private LocalDate tripdate;

    private String stopid;

    private String stasiuncode;

    private int stoporder;

    private String stamformdetid;

    private String stamformdetcode;

    private int stamformdetorder;

    private BigInteger wagondetid;

    private int wagondetrow;

    private String wagondetcol;

    private BigInteger subclassid;

    private String subclasscode;

    private String bookstat;

    private String status;

    private BigInteger domain;

    private BigInteger modifiedby;


    private LocalDateTime modifiedon;

    private int wagondetcolnum;

    private BigInteger createdby;


    private LocalDateTime createdon;

    private String bookcode;

    private Integer transactiondetorder;

    private String transactiondetticketnum;

    private String seatopen;

    private String blockstat;

    private String errorDescription;

    public CInventory() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchedulenoka() {
        return this.schedulenoka;
    }

    public void setSchedulenoka(String schedulenoka) {
        this.schedulenoka = schedulenoka;
    }

    public String getTripid() {
        return this.tripid;
    }

    public void setTripid(String tripid) {
        this.tripid = tripid;
    }

    public LocalDate getTripdate() {
        return this.tripdate;
    }

    public void setTripdate(LocalDate tripdate) {
        this.tripdate = tripdate;
    }

    public String getStopid() {
        return this.stopid;
    }

    public void setStopid(String stopid) {
        this.stopid = stopid;
    }

    public String getStasiuncode() {
        return this.stasiuncode;
    }

    public void setStasiuncode(String stasiuncode) {
        this.stasiuncode = stasiuncode;
    }

    public int getStoporder() {
        return this.stoporder;
    }

    public void setStoporder(int stoporder) {
        this.stoporder = stoporder;
    }

    public String getStamformdetid() {
        return this.stamformdetid;
    }

    public void setStamformdetid(String stamformdetid) {
        this.stamformdetid = stamformdetid;
    }

    public String getStamformdetcode() {
        return this.stamformdetcode;
    }

    public void setStamformdetcode(String stamformdetcode) {
        this.stamformdetcode = stamformdetcode;
    }

    public int getStamformdetorder() {
        return this.stamformdetorder;
    }

    public void setStamformdetorder(int stamformdetorder) {
        this.stamformdetorder = stamformdetorder;
    }

    public BigInteger getWagondetid() {
        return this.wagondetid;
    }

    public void setWagondetid(BigInteger wagondetid) {
        this.wagondetid = wagondetid;
    }

    public int getWagondetrow() {
        return this.wagondetrow;
    }

    public void setWagondetrow(int wagondetrow) {
        this.wagondetrow = wagondetrow;
    }

    public String getWagondetcol() {
        return this.wagondetcol;
    }

    public void setWagondetcol(String wagondetcol) {
        this.wagondetcol = wagondetcol;
    }

    public BigInteger getSubclassid() {
        return this.subclassid;
    }

    public void setSubclassid(BigInteger subclassid) {
        this.subclassid = subclassid;
    }

    public String getSubclasscode() {
        return this.subclasscode;
    }

    public void setSubclasscode(String subclasscode) {
        this.subclasscode = subclasscode;
    }

    public String getBookstat() {
        return this.bookstat;
    }

    public void setBookstat(String bookstat) {
        this.bookstat = bookstat;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getDomain() {
        return this.domain;
    }

    public void setDomain(BigInteger domain) {
        this.domain = domain;
    }

    public BigInteger getModifiedby() {
        return this.modifiedby;
    }

    public void setModifiedby(BigInteger modifiedby) {
        this.modifiedby = modifiedby;
    }

    public LocalDateTime getModifiedon() {
        return this.modifiedon;
    }

    public void setModifiedon(LocalDateTime modifiedon) {
        this.modifiedon = modifiedon;
    }

    public int getWagondetcolnum() {
        return this.wagondetcolnum;
    }

    public void setWagondetcolnum(int wagondetcolnum) {
        this.wagondetcolnum = wagondetcolnum;
    }

    public BigInteger getCreatedby() {
        return this.createdby;
    }

    public void setCreatedby(BigInteger createdby) {
        this.createdby = createdby;
    }

    public LocalDateTime getCreatedon() {
        return this.createdon;
    }

    public void setCreatedon(LocalDateTime createdon) {
        this.createdon = createdon;
    }

    public String getBookcode() {
        return this.bookcode;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public Integer getTransactiondetorder() {
        return this.transactiondetorder;
    }

    public void setTransactiondetorder(Integer transactiondetorder) {
        this.transactiondetorder = transactiondetorder;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getSeatopen() {
        return this.seatopen;
    }

    public void setSeatopen(String seatopen) {
        this.seatopen = seatopen;
    }

    public String getTransactiondetticketnum() {
        return this.transactiondetticketnum;
    }

    public void setTransactiondetticketnum(String transactiondetticketnum) {
        this.transactiondetticketnum = transactiondetticketnum;
    }

    public String getBlockstat() {
        return this.blockstat;
    }

    public void setBlockstat(String blockstat) {
        this.blockstat = blockstat;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            CInventory CInventory = (CInventory)o;
            if (!this.schedulenoka.equals(CInventory.schedulenoka)) {
                return false;
            } else {
                return !this.stamformdetcode.equals(CInventory.stamformdetcode) ? false : this.wagondetid.equals(CInventory.wagondetid);
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.schedulenoka.hashCode();
        result = 31 * result + this.stamformdetcode.hashCode();
        result = 31 * result + this.wagondetid.hashCode();
        return result;
    }

    public String toString() {
        return String.format("Stamformddetcode: %s , Wgondet row: %d, Wagondet col: %s, subclasscode: %s", this.stamformdetcode, this.wagondetrow, this.wagondetcol, this.subclasscode);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException var2) {
            throw new InternalError();
        }
    }
}
