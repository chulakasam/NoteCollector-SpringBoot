package lk.ijse.gdse.aad67.NoteCollector_v2.service;


import lk.ijse.gdse.aad67.NoteCollector_v2.dto.UserDTO;
import lk.ijse.gdse.aad67.NoteCollector_v2.dto.UserStatus;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserStatus getUser(String userId);
    boolean updateUser(String userId,UserDTO userDTO);
    void deleteUser(String userId);
}
