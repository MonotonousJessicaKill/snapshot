package jielin.snapshot.dao;

import jielin.snapshot.domain.WarmDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarmDao extends JpaRepository<WarmDataEntity,Integer> {
}
