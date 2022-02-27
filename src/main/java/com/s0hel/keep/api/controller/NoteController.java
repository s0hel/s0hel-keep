package com.s0hel.keep.api.controller;

import com.s0hel.keep.api.model.NoteModel;
import com.s0hel.keep.api.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

  private final NoteService noteService;

  public NoteController(NoteService noteService) {
    this.noteService = noteService;
  }

  @GetMapping("/note")
  public Iterable<NoteModel> getAllNotes() {
    return noteService.getAllNotes();
  }

  @PostMapping("/note")
  public NoteModel createNote(@RequestBody NoteModel input) {
    return noteService.createNote(input);
  }

  @PutMapping("/note/{id}")
  public NoteModel updateNote(@RequestBody NoteModel input) {
    return noteService.updateNote(input);
  }

  @GetMapping("/note/{id}")
  public NoteModel getNote(@PathVariable("id") Integer noteId) {
    return noteService.getNote(noteId);
  }

  @DeleteMapping("/note/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void deleteNote(@PathVariable("id") Integer noteId) {
    noteService.deleteNote(noteId);
  }
}
