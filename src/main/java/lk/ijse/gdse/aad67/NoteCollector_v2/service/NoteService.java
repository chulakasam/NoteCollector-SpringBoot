package lk.ijse.gdse.aad67.NoteCollector_v2.service;


import lk.ijse.gdse.aad67.NoteCollector_v2.dto.NoteDTO;
import lk.ijse.gdse.aad67.NoteCollector_v2.dto.NoteStatus;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote(String noteId);
    boolean updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote(String noteId);

}
