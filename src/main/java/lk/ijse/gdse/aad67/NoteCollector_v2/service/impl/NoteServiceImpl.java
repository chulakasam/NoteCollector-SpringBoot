package lk.ijse.gdse.aad67.NoteCollector_v2.service.impl;


import lk.ijse.gdse.aad67.NoteCollector_v2.Dao.NoteDao;
import lk.ijse.gdse.aad67.NoteCollector_v2.customStatusCodes.SelectedUserErrorStatus;
import lk.ijse.gdse.aad67.NoteCollector_v2.dto.NoteDTO;
import lk.ijse.gdse.aad67.NoteCollector_v2.dto.NoteStatus;
import lk.ijse.gdse.aad67.NoteCollector_v2.entity.impl.NoteEntity;
import lk.ijse.gdse.aad67.NoteCollector_v2.exceotion.DataPersistException;
import lk.ijse.gdse.aad67.NoteCollector_v2.exceotion.UserNotFoundException;
import lk.ijse.gdse.aad67.NoteCollector_v2.service.NoteService;
import lk.ijse.gdse.aad67.NoteCollector_v2.util.AppUtil;
import lk.ijse.gdse.aad67.NoteCollector_v2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;
    @Autowired
    private Mapping noteMapping;



    @Override
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        NoteEntity savedNote =
                noteDao.save(noteMapping.toNoteEntity(noteDTO));
        if(savedNote == null){
            throw new DataPersistException("Note not saved");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteMapping.asNoteDtoList(noteDao.findAll());
    }

    @Override
    public NoteStatus getNote(String noteId) {
        if(noteDao.existsById(noteId)){
            var selectedUser = noteDao.getReferenceById(noteId);
            return noteMapping.toNoteDto(selectedUser);
        }else {
            return new SelectedUserErrorStatus(2,"Selected note not found");
        }
    }

    @Override
    public boolean updateNote(String noteId,NoteDTO noteDTO) {
        Optional<NoteEntity> tmpUser = noteDao.findById(noteId);
        if(tmpUser.isPresent()){
            tmpUser.get().setNoteTitle(noteDTO.getNoteTitle());
            tmpUser.get().setNoteDesc(noteDTO.getNoteDesc());
            tmpUser.get().setCreatedDate(noteDTO.getCreatedDate());
            tmpUser.get().setPriorityLevel(noteDTO.getPriorityLevel());
        }
        return false;
    }

    @Override
    public void deleteNote(String noteId) {
        Optional<NoteEntity> existedNote = noteDao.findById(noteId);
        if(!existedNote.isPresent()){
            throw new UserNotFoundException("Note with id " + noteId + " not found");
        }else {
            noteDao.deleteById(noteId);
        }
    }
}
