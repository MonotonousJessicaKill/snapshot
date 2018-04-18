package jielin.snapshot.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "deployment_data_prod", schema = "wade", catalog = "")
public class DeploymentDataProdEntity {
    private int id;
    private String title;
    private String starter;
    private String finisher;
    private Timestamp startDate;
    private String taskState;
    private Timestamp finishDate;
    private String effort;
    private String diguid;
    private String diEngine;
    private String location;
    private String parentDeploymentId;
    private String type;
    private String buildNumber;
    private String buildPath;
    private String deploymentRoot;
    private String toolset;
    private String templateName;
    private String settingsFile;
    private String tenantId;
    private String serviceTreeGuid;
    private String approvedBy;
    private String submittedBy;
    private String buildReplicationId;
    private String rtoid;
    private String rtoApprovedBy;
    private String rtoSubmittedBy;
    private String updatedTime;



    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Starter", nullable = true, length = 255)
    public String getStarter() {
        return starter;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }

    @Basic
    @Column(name = "Finisher", nullable = true, length = 255)
    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = finisher;
    }

    @Basic
    @Column(name = "StartDate", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "TaskState", nullable = true, length = 255)
    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    @Basic
    @Column(name = "FinishDate", nullable = true)
    public Timestamp getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "Effort", nullable = true, length = 255)
    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    @Basic
    @Column(name = "DIGUID", nullable = true, length = 255)
    public String getDiguid() {
        return diguid;
    }

    public void setDiguid(String diguid) {
        this.diguid = diguid;
    }

    @Basic
    @Column(name = "DIEngine", nullable = true, length = 255)
    public String getDiEngine() {
        return diEngine;
    }

    public void setDiEngine(String diEngine) {
        this.diEngine = diEngine;
    }

    @Basic
    @Column(name = "Location", nullable = true, length = 255)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "ParentDeploymentID", nullable = true, length = 255)
    public String getParentDeploymentId() {
        return parentDeploymentId;
    }

    public void setParentDeploymentId(String parentDeploymentId) {
        this.parentDeploymentId = parentDeploymentId;
    }

    @Basic
    @Column(name = "Type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "BuildNumber", nullable = true, length = 255)
    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    @Basic
    @Column(name = "BuildPath", nullable = true, length = 255)
    public String getBuildPath() {
        return buildPath;
    }

    public void setBuildPath(String buildPath) {
        this.buildPath = buildPath;
    }

    @Basic
    @Column(name = "DeploymentRoot", nullable = true, length = 255)
    public String getDeploymentRoot() {
        return deploymentRoot;
    }

    public void setDeploymentRoot(String deploymentRoot) {
        this.deploymentRoot = deploymentRoot;
    }

    @Basic
    @Column(name = "Toolset", nullable = true, length = 255)
    public String getToolset() {
        return toolset;
    }

    public void setToolset(String toolset) {
        this.toolset = toolset;
    }

    @Basic
    @Column(name = "TemplateName", nullable = true, length = 255)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "SettingsFile", nullable = true, length = 255)
    public String getSettingsFile() {
        return settingsFile;
    }

    public void setSettingsFile(String settingsFile) {
        this.settingsFile = settingsFile;
    }

    @Basic
    @Column(name = "TenantID", nullable = true, length = 255)
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "ServiceTreeGUID", nullable = true, length = 255)
    public String getServiceTreeGuid() {
        return serviceTreeGuid;
    }

    public void setServiceTreeGuid(String serviceTreeGuid) {
        this.serviceTreeGuid = serviceTreeGuid;
    }

    @Basic
    @Column(name = "ApprovedBy", nullable = true, length = 255)
    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Basic
    @Column(name = "SubmittedBy", nullable = true, length = 255)
    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    @Basic
    @Column(name = "BuildReplicationID", nullable = true, length = 255)
    public String getBuildReplicationId() {
        return buildReplicationId;
    }

    public void setBuildReplicationId(String buildReplicationId) {
        this.buildReplicationId = buildReplicationId;
    }

    @Basic
    @Column(name = "RTOID", nullable = true, length = 255)
    public String getRtoid() {
        return rtoid;
    }

    public void setRtoid(String rtoid) {
        this.rtoid = rtoid;
    }

    @Basic
    @Column(name = "RTOApprovedBy", nullable = true, length = 255)
    public String getRtoApprovedBy() {
        return rtoApprovedBy;
    }

    public void setRtoApprovedBy(String rtoApprovedBy) {
        this.rtoApprovedBy = rtoApprovedBy;
    }

    @Basic
    @Column(name = "RTOSubmittedBy", nullable = true, length = 255)
    public String getRtoSubmittedBy() {
        return rtoSubmittedBy;
    }

    public void setRtoSubmittedBy(String rtoSubmittedBy) {
        this.rtoSubmittedBy = rtoSubmittedBy;
    }

    @Basic
    @Column(name = "UpdatedTime", nullable = true, length = 255)
    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public DeploymentMiddleObj toMiddle(){
        DeploymentMiddleObj obj= new DeploymentMiddleObj();
        obj.id = ""+this.id;
        obj.approvedBy = this.approvedBy;
        obj.buildNumber =this.buildNumber;
        obj.buildPath = this.buildPath;
        obj.buildReplicationId = this.buildReplicationId;
        obj.deploymentRoot = this.deploymentRoot;
        obj.diEngine =this.diEngine;
        obj.diguid = this.diguid;
        obj.effort = this.effort;
        obj.finishDate=this.finishDate.toString();
        obj.finisher = this.finisher;
        obj.location=this.location;
        obj.parentDeploymentId = this.parentDeploymentId;
        obj.rtoApprovedBy = this.rtoApprovedBy;
        obj.rtoid = this.rtoid;
        obj.rtoSubmittedBy = this.rtoSubmittedBy;
        obj.serviceTreeGuid=this.serviceTreeGuid;
        obj.settingsFile = this.settingsFile;
        obj.startDate = this.startDate.toString();
        obj.starter=this.starter;
        obj.submittedBy = this.submittedBy;
        obj.taskState = this.taskState;
        obj.templateName = this.templateName;
        obj.tenantId = this.tenantId;
        obj.title = this.title;
        obj.toolset = this.toolset;
        obj.type = this.type;
        obj.updatedTime = this.updatedTime;
        return obj;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeploymentDataProdEntity that = (DeploymentDataProdEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (starter != null ? !starter.equals(that.starter) : that.starter != null) return false;
        if (finisher != null ? !finisher.equals(that.finisher) : that.finisher != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (taskState != null ? !taskState.equals(that.taskState) : that.taskState != null) return false;
        if (finishDate != null ? !finishDate.equals(that.finishDate) : that.finishDate != null) return false;
        if (effort != null ? !effort.equals(that.effort) : that.effort != null) return false;
        if (diguid != null ? !diguid.equals(that.diguid) : that.diguid != null) return false;
        if (diEngine != null ? !diEngine.equals(that.diEngine) : that.diEngine != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (parentDeploymentId != null ? !parentDeploymentId.equals(that.parentDeploymentId) : that.parentDeploymentId != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (buildNumber != null ? !buildNumber.equals(that.buildNumber) : that.buildNumber != null) return false;
        if (buildPath != null ? !buildPath.equals(that.buildPath) : that.buildPath != null) return false;
        if (deploymentRoot != null ? !deploymentRoot.equals(that.deploymentRoot) : that.deploymentRoot != null)
            return false;
        if (toolset != null ? !toolset.equals(that.toolset) : that.toolset != null) return false;
        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (settingsFile != null ? !settingsFile.equals(that.settingsFile) : that.settingsFile != null) return false;
        if (tenantId != null ? !tenantId.equals(that.tenantId) : that.tenantId != null) return false;
        if (serviceTreeGuid != null ? !serviceTreeGuid.equals(that.serviceTreeGuid) : that.serviceTreeGuid != null)
            return false;
        if (approvedBy != null ? !approvedBy.equals(that.approvedBy) : that.approvedBy != null) return false;
        if (submittedBy != null ? !submittedBy.equals(that.submittedBy) : that.submittedBy != null) return false;
        if (buildReplicationId != null ? !buildReplicationId.equals(that.buildReplicationId) : that.buildReplicationId != null)
            return false;
        if (rtoid != null ? !rtoid.equals(that.rtoid) : that.rtoid != null) return false;
        if (rtoApprovedBy != null ? !rtoApprovedBy.equals(that.rtoApprovedBy) : that.rtoApprovedBy != null)
            return false;
        if (rtoSubmittedBy != null ? !rtoSubmittedBy.equals(that.rtoSubmittedBy) : that.rtoSubmittedBy != null)
            return false;
        if (updatedTime != null ? !updatedTime.equals(that.updatedTime) : that.updatedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (starter != null ? starter.hashCode() : 0);
        result = 31 * result + (finisher != null ? finisher.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (taskState != null ? taskState.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (effort != null ? effort.hashCode() : 0);
        result = 31 * result + (diguid != null ? diguid.hashCode() : 0);
        result = 31 * result + (diEngine != null ? diEngine.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (parentDeploymentId != null ? parentDeploymentId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (buildNumber != null ? buildNumber.hashCode() : 0);
        result = 31 * result + (buildPath != null ? buildPath.hashCode() : 0);
        result = 31 * result + (deploymentRoot != null ? deploymentRoot.hashCode() : 0);
        result = 31 * result + (toolset != null ? toolset.hashCode() : 0);
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        result = 31 * result + (settingsFile != null ? settingsFile.hashCode() : 0);
        result = 31 * result + (tenantId != null ? tenantId.hashCode() : 0);
        result = 31 * result + (serviceTreeGuid != null ? serviceTreeGuid.hashCode() : 0);
        result = 31 * result + (approvedBy != null ? approvedBy.hashCode() : 0);
        result = 31 * result + (submittedBy != null ? submittedBy.hashCode() : 0);
        result = 31 * result + (buildReplicationId != null ? buildReplicationId.hashCode() : 0);
        result = 31 * result + (rtoid != null ? rtoid.hashCode() : 0);
        result = 31 * result + (rtoApprovedBy != null ? rtoApprovedBy.hashCode() : 0);
        result = 31 * result + (rtoSubmittedBy != null ? rtoSubmittedBy.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }
}
