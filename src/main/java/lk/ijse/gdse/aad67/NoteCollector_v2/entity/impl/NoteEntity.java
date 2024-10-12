package lk.ijse.gdse.aad67.NoteCollector_v2.entity.impl;


import jakarta.persistence.*;
import lk.ijse.gdse.aad67.NoteCollector_v2.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="note")
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createdDate;
    private String priorityLevel;
    @ManyToOne
    @JoinColumn(name="userId",nullable = false)
    private UserEntity user;
}
