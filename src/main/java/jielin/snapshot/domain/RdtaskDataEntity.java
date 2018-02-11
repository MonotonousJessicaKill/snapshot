package jielin.snapshot.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rdtask_data", schema = "wade", catalog = "")
public class RdtaskDataEntity {
    private int id;
    private String title;
    private Integer priority;
    private String taskState;
    private String keywords;
    private String createdPerson;
    private Timestamp createdDate;
    private String approvedPerson;
    private Timestamp approvedDate;
    private String resolvedPerson;
    private Timestamp resolvedDate;
    private Integer completedWork;
    private String type;
    private Timestamp updatedTime;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 320)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Priority", nullable = true)
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
    @Column(name = "Keywords", nullable = true, length = 80)
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "CreatedPerson", nullable = true, length = 80)
    public String getCreatedPerson() {
        return createdPerson;
    }

    public void setCreatedPerson(String createdPerson) {
        this.createdPerson = createdPerson;
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
    @Column(name = "ApprovedPerson", nullable = true, length = 40)
    public String getApprovedPerson() {
        return approvedPerson;
    }

    public void setApprovedPerson(String approvedPerson) {
        this.approvedPerson = approvedPerson;
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
    @Column(name = "ResolvedPerson", nullable = true, length = 80)
    public String getResolvedPerson() {
        return resolvedPerson;
    }

    public void setResolvedPerson(String resolvedPerson) {
        this.resolvedPerson = resolvedPerson;
    }

    @Basic
    @Column(name = "ResolvedDate", nullable = true)
    public Timestamp getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Timestamp resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    @Basic
    @Column(name = "CompletedWork", nullable = true)
    public Integer getCompletedWork() {
        return completedWork;
    }

    public void setCompletedWork(Integer completedWork) {
        this.completedWork = completedWork;
    }

    @Basic
    @Column(name = "Type", nullable = true, length = 40)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "UpdatedTime", nullable = true)
    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RdtaskDataEntity that = (RdtaskDataEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (taskState != null ? !taskState.equals(that.taskState) : that.taskState != null) return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null) return false;
        if (createdPerson != null ? !createdPerson.equals(that.createdPerson) : that.createdPerson != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (approvedPerson != null ? !approvedPerson.equals(that.approvedPerson) : that.approvedPerson != null)
            return false;
        if (approvedDate != null ? !approvedDate.equals(that.approvedDate) : that.approvedDate != null) return false;
        if (resolvedPerson != null ? !resolvedPerson.equals(that.resolvedPerson) : that.resolvedPerson != null)
            return false;
        if (resolvedDate != null ? !resolvedDate.equals(that.resolvedDate) : that.resolvedDate != null) return false;
        if (completedWork != null ? !completedWork.equals(that.completedWork) : that.completedWork != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (updatedTime != null ? !updatedTime.equals(that.updatedTime) : that.updatedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (taskState != null ? taskState.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (createdPerson != null ? createdPerson.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (approvedPerson != null ? approvedPerson.hashCode() : 0);
        result = 31 * result + (approvedDate != null ? approvedDate.hashCode() : 0);
        result = 31 * result + (resolvedPerson != null ? resolvedPerson.hashCode() : 0);
        result = 31 * result + (resolvedDate != null ? resolvedDate.hashCode() : 0);
        result = 31 * result + (completedWork != null ? completedWork.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }
}
