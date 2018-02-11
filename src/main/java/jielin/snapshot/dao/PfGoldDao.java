package jielin.snapshot.dao;

import jielin.snapshot.domain.PfgoldDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PfGoldDao extends JpaRepository<PfgoldDataEntity,Integer> {
}
