package com.s0hel.keep.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteEntity {

    @Id @GeneratedValue
    private Integer noteId;
    private String title;
    private String note;
    private Integer owner;
}
