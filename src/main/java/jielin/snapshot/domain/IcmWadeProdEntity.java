package jielin.snapshot.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "icm_wade_prod", schema = "wade", catalog = "")
public class IcmWadeProdEntity {
    private int id;
    private String severity;
    private String status;
    private String title;
    private String role;
    private String owner;
    private String environment;
    private String incidentType;
    private String effort;
    private Timestamp createDate;
    private String acknowledgeDate;
    private Timestamp modifiedDate;
    private String spendTime;
    private Timestamp updatetime;
    private String inQuery;
    private Timestamp reCreateDate;
    private String tta;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Severity", nullable = false, length = 5)
    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Basic
    @Column(name = "Status", nullable = false, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 2000)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Role", nullable = false, length = 10)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "Owner", nullable = true, length = 25)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "Environment", nullable = true, length = 15)
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Basic
    @Column(name = "IncidentType", nullable = true, length = 25)
    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    @Basic
    @Column(name = "Effort", nullable = true, length = 20)
    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    @Basic
    @Column(name = "CreateDate", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "AcknowledgeDate", nullable = true, length = 2000)
    public String getAcknowledgeDate() {
        return acknowledgeDate;
    }

    public void setAcknowledgeDate(String acknowledgeDate) {
        this.acknowledgeDate = acknowledgeDate;
    }

    @Basic
    @Column(name = "ModifiedDate", nullable = true)
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Basic
    @Column(name = "SpendTime", nullable = true, length = 15)
    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    @Basic
    @Column(name = "Updatetime", nullable = true)
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Basic
    @Column(name = "InQuery", nullable = false, length = 15)
    public String getInQuery() {
        return inQuery;
    }

    public void setInQuery(String inQuery) {
        this.inQuery = inQuery;
    }

    @Basic
    @Column(name = "ReCreateDate", nullable = true)
    public Timestamp getReCreateDate() {
        return reCreateDate;
    }

    public void setReCreateDate(Timestamp reCreateDate) {
        this.reCreateDate = reCreateDate;
    }

    @Basic
    @Column(name = "TTA", nullable = false, length = 2000)
    public String getTta() {
        return tta;
    }

    public void setTta(String tta) {
        this.tta = tta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IcmWadeProdEntity that = (IcmWadeProdEntity) o;

        if (id != that.id) return false;
        if (severity != null ? !severity.equals(that.severity) : that.severity != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (environment != null ? !environment.equals(that.environment) : that.environment != null) return false;
        if (incidentType != null ? !incidentType.equals(that.incidentType) : that.incidentType != null) return false;
        if (effort != null ? !effort.equals(that.effort) : that.effort != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (acknowledgeDate != null ? !acknowledgeDate.equals(that.acknowledgeDate) : that.acknowledgeDate != null)
            return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (spendTime != null ? !spendTime.equals(that.spendTime) : that.spendTime != null) return false;
        if (updatetime != null ? !updatetime.equals(that.updatetime) : that.updatetime != null) return false;
        if (inQuery != null ? !inQuery.equals(that.inQuery) : that.inQuery != null) return false;
        if (reCreateDate != null ? !reCreateDate.equals(that.reCreateDate) : that.reCreateDate != null) return false;
        if (tta != null ? !tta.equals(that.tta) : that.tta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (severity != null ? severity.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (environment != null ? environment.hashCode() : 0);
        result = 31 * result + (incidentType != null ? incidentType.hashCode() : 0);
        result = 31 * result + (effort != null ? effort.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (acknowledgeDate != null ? acknowledgeDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (spendTime != null ? spendTime.hashCode() : 0);
        result = 31 * result + (updatetime != null ? updatetime.hashCode() : 0);
        result = 31 * result + (inQuery != null ? inQuery.hashCode() : 0);
        result = 31 * result + (reCreateDate != null ? reCreateDate.hashCode() : 0);
        result = 31 * result + (tta != null ? tta.hashCode() : 0);
        return result;
    }
}
