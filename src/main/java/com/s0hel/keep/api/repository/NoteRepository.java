package com.s0hel.keep.api.repository;

import com.s0hel.keep.api.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<NoteEntity, Integer> {
}
