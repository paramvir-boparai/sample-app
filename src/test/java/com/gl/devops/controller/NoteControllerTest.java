package com.gl.devops.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.gl.devops.model.Note;
import com.gl.devops.repository.NoteRepository;
public class NoteControllerTest {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteController noteController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
     @Test
        public void testFindAll() {
          List<Note> notes = new ArrayList<>();
          notes.add(new Note());
            when(noteRepository.findAll()).thenReturn(notes);
            assertEquals(notes, noteController.getAllNotes());
        }
}
