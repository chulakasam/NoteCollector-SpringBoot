package lk.ijse.gdse.aad67.NoteCollector_v2.util;


import lk.ijse.gdse.aad67.NoteCollector_v2.dto.NoteDTO;
import lk.ijse.gdse.aad67.NoteCollector_v2.dto.UserDTO;
import lk.ijse.gdse.aad67.NoteCollector_v2.entity.impl.NoteEntity;
import lk.ijse.gdse.aad67.NoteCollector_v2.entity.impl.UserEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //for user mapping;
    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<UserDTO> asUserDTOList(List<UserEntity> userEntityList){
        return modelMapper.map(userEntityList, new TypeToken<List<UserDTO>>(){}.getType());
    }
    public NoteDTO toNoteDto(NoteEntity noteEntity){
        return modelMapper.map(noteEntity, NoteDTO.class);
    }
    public NoteEntity toNoteEntity(NoteDTO noteDTO){
        return modelMapper.map(noteDTO,NoteEntity.class);
    }
    public List<NoteDTO> asNoteDtoList(List<NoteEntity>noteEntities){
        return modelMapper.map(noteEntities, new TypeToken<List<NoteDTO>>() {}.getType());
    }
}
