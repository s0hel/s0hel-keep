package com.s0hel.keep.api.adapter;

import com.s0hel.keep.api.entity.NoteEntity;
import com.s0hel.keep.api.model.NoteModel;

import java.util.ArrayList;

public class NoteAdapter {

    public static NoteEntity fromModel(NoteModel model) {
        return NoteEntity.builder()
                .noteId(model.getNoteId())
                .title(model.getTitle())
                .note(model.getNote())
                .owner(model.getOwnedBy())
                .build();
    }

    public static NoteModel fromEntity(NoteEntity entity) {
        return NoteModel.builder()
                .noteId(entity.getNoteId())
                .title(entity.getTitle())
                .note(entity.getNote())
                .ownedBy(entity.getOwner())
                .build();
    }

    public static Iterable<NoteModel> fromEntityCollection(Iterable<NoteEntity> entities) {
        var results = new ArrayList<NoteModel>();
        entities.forEach(entity -> { results.add(fromEntity(entity)); });
        return results;
    }

}
