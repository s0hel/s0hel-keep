package com.s0hel.keep.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteModel {

    private Integer noteId;
    private String title;
    private String note;
    private Integer ownedBy;

}
