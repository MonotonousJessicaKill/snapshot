package jielin.snapshot.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "warm_data", schema = "wade", catalog = "")
public class WarmDataEntity {
    private int id;
    private String title;
    private String description;
    private String type;
    private Timestamp approvedDate;
    private Timestamp createdDate;
    private Double kpi;
    private String tag;
    private Timestamp updatetime;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 80)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 40)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Type", nullable = true, length = 80)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "ApprovedDate", nullable = true)
    public Timestamp getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "KPI", nullable = true, precision = 3)
    public Double getKpi() {
        return kpi;
    }

    public void setKpi(Double kpi) {
        this.kpi = kpi;
    }

    @Basic
    @Column(name = "Tag", nullable = true, length = 40)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "Updatetime", nullable = true)
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarmDataEntity that = (WarmDataEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (approvedDate != null ? !approvedDate.equals(that.approvedDate) : that.approvedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (kpi != null ? !kpi.equals(that.kpi) : that.kpi != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (updatetime != null ? !updatetime.equals(that.updatetime) : that.updatetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (approvedDate != null ? approvedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (kpi != null ? kpi.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (updatetime != null ? updatetime.hashCode() : 0);
        return result;
    }
}
