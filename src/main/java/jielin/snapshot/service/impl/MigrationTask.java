package jielin.snapshot.service.impl;

import jielin.snapshot.dao.DeploymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MigrationTask {

    @Autowired
    private DeploymentDao dao;
    @Scheduled(cron="0 30 * * * *")
    public void executeDataSyncTask() {
        dao.

    }
}
