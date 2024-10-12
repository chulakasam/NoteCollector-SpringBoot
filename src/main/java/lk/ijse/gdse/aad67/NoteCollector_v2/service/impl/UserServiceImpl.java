package lk.ijse.gdse.aad67.NoteCollector_v2.service.impl;


import lk.ijse.gdse.aad67.NoteCollector_v2.Dao.UserDao;
import lk.ijse.gdse.aad67.NoteCollector_v2.customStatusCodes.SelectedUserErrorStatus;
import lk.ijse.gdse.aad67.NoteCollector_v2.dto.UserDTO;
import lk.ijse.gdse.aad67.NoteCollector_v2.dto.UserStatus;
import lk.ijse.gdse.aad67.NoteCollector_v2.entity.impl.UserEntity;
import lk.ijse.gdse.aad67.NoteCollector_v2.exceotion.DataPersistException;
import lk.ijse.gdse.aad67.NoteCollector_v2.exceotion.UserNotFoundException;
import lk.ijse.gdse.aad67.NoteCollector_v2.service.UserService;
import lk.ijse.gdse.aad67.NoteCollector_v2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service//component annotation eka meta anotate wela tiyenwa..
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        // mapping.toUserDTO(SaveUser);
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> all = userDao.findAll();
        return mapping.asUserDTOList(all);
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDao.existsById(userId)){
            UserEntity selectedUser = userDao.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedUserErrorStatus(2, "User with id " + userId + " not found");
        }
    }


    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {//204 - no content
        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if(tmpUser.isPresent()){
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
        return false;
    }


    @Override
    public void deleteUser(String userId) {//204 - no content
        Optional<UserEntity> existedUser = userDao.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }else {
            userDao.deleteById(userId);
        }
    }
}

