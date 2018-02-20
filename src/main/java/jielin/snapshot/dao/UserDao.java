package jielin.snapshot.dao;

import jielin.snapshot.domain.UserEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<UserEntity,Integer>,
        JpaSpecificationExecutor<UserEntity> {
    @Override
    UserEntity findOne(Specification<UserEntity> specification);
}
