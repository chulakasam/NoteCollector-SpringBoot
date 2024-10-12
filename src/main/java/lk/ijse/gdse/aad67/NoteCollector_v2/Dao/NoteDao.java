package lk.ijse.gdse.aad67.NoteCollector_v2.Dao;




import lk.ijse.gdse.aad67.NoteCollector_v2.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                  //<entity name eka,adala table eke primary key eke data type eka>
public interface NoteDao  extends JpaRepository<NoteEntity,String> {
}
