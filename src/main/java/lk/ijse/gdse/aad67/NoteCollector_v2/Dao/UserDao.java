package lk.ijse.gdse.aad67.NoteCollector_v2.Dao;


import lk.ijse.gdse.aad67.NoteCollector_v2.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository//dao layer ekata adala bawa penwanna.
public interface UserDao extends JpaRepository<UserEntity,String> {
    //UserEntity saveUser(UserDTO userDTO);

}
