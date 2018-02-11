package jielin.snapshot.dao;

import jielin.snapshot.domain.IcmWadeProdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcmDao extends JpaRepository<IcmWadeProdEntity,Integer> {
}
