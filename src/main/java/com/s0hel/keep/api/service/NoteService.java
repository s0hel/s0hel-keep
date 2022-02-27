package com.s0hel.keep.api.service;

import com.s0hel.keep.api.adapter.NoteAdapter;
import com.s0hel.keep.api.exception.NoteNotFoundException;
import com.s0hel.keep.api.model.NoteModel;
import com.s0hel.keep.api.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

  private final NoteRepository noteRepository;

  private final static int USER_ID = 1;

  public NoteService(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  public NoteModel createNote(NoteModel note) {
    var entity = NoteAdapter.fromModel(note);
    // TODO: replace with real user id
    entity.setOwner(USER_ID);
    entity = noteRepository.save(entity);
    return NoteAdapter.fromEntity(entity);
  }

  public NoteModel updateNote(NoteModel note) {
    // retrieve existing record
    var existing = noteRepository.findById(note.getNoteId()).orElseThrow(NoteNotFoundException::new);

    // update note
    existing.setNote(note.getNote());

    // save it
    existing = noteRepository.save(existing);

    // return model
    return NoteAdapter.fromEntity(existing);
  }

  public Iterable<NoteModel> getAllNotes() {
    return NoteAdapter.fromEntityCollection(noteRepository.findAll());
  }

  public NoteModel getNote(Integer noteId) {
    var entity = noteRepository.findById(noteId).orElseThrow(NoteNotFoundException::new);
    return NoteAdapter.fromEntity(entity);
  }

  public void deleteNote(Integer noteId) {
    noteRepository.deleteById(noteId);
  }
}
