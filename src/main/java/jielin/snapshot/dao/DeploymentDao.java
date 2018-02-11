package jielin.snapshot.dao;

import jielin.snapshot.domain.DeploymentDataProdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DeploymentDao extends JpaRepository<DeploymentDataProdEntity,Integer>,
        JpaSpecificationExecutor<DeploymentDataProdEntity>{
}

