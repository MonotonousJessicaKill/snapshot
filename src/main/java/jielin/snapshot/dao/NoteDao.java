package jielin.snapshot.dao;

import jielin.snapshot.domain.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoteDao extends JpaRepository<NoteEntity,Integer>,
        JpaSpecificationExecutor<NoteEntity> {
}
