package jielin.snapshot.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pfgold_data", schema = "wade", catalog = "")
public class PfgoldDataEntity {
    private int id;
    private String title;
    private String taskState;
    private Timestamp createDate;
    private Timestamp approvedDate;
    private Timestamp lastChangeDate;
    private String lastChangePerson;
    private Double spendTime;
    private String tag;
    private Timestamp updateTime;

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
    @Column(name = "TaskState", nullable = true, length = 40)
    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
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
    @Column(name = "ApprovedDate", nullable = true)
    public Timestamp getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }

    @Basic
    @Column(name = "LastChangeDate", nullable = true)
    public Timestamp getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Timestamp lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    @Basic
    @Column(name = "LastChangePerson", nullable = true, length = 40)
    public String getLastChangePerson() {
        return lastChangePerson;
    }

    public void setLastChangePerson(String lastChangePerson) {
        this.lastChangePerson = lastChangePerson;
    }

    @Basic
    @Column(name = "SpendTime", nullable = true, precision = 2)
    public Double getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Double spendTime) {
        this.spendTime = spendTime;
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
    @Column(name = "UpdateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PfgoldDataEntity that = (PfgoldDataEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (taskState != null ? !taskState.equals(that.taskState) : that.taskState != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (approvedDate != null ? !approvedDate.equals(that.approvedDate) : that.approvedDate != null) return false;
        if (lastChangeDate != null ? !lastChangeDate.equals(that.lastChangeDate) : that.lastChangeDate != null)
            return false;
        if (lastChangePerson != null ? !lastChangePerson.equals(that.lastChangePerson) : that.lastChangePerson != null)
            return false;
        if (spendTime != null ? !spendTime.equals(that.spendTime) : that.spendTime != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (taskState != null ? taskState.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (approvedDate != null ? approvedDate.hashCode() : 0);
        result = 31 * result + (lastChangeDate != null ? lastChangeDate.hashCode() : 0);
        result = 31 * result + (lastChangePerson != null ? lastChangePerson.hashCode() : 0);
        result = 31 * result + (spendTime != null ? spendTime.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
