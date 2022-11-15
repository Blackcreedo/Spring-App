package org.example.spring_app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.example.spring_app.dao.RoomDao;
import org.example.spring_app.dao.WindowDao;
import org.example.spring_app.dto.WindowDto;
import org.example.spring_app.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(WindowController.class)
public class WindowControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private WindowDao windowDao;

    @MockBean
    private RoomDao roomDao;

    @Test
    void loadWindows() throws Exception {
        given(windowDao.findAll()).willReturn(List.of(
                createWindow("window 1"),
                createWindow("window 2")
        ));
    }

    @Test
    void returnNullIfWindowNotFound() throws Exception {
        given(windowDao.findById(69L)).willReturn(Optional.empty());
    }

    @Test
    void createWindow() throws Exception {
        Window window = createWindow("window 1");

        given(roomDao.getReferenceById(anyLong())).willReturn(window.getRoom());
        given(windowDao.save(any())).willReturn(window);
    }

    @Test
    void updateWindow() throws Exception {
        Window window = createWindow("window 1");
        window.setId(1L);

        given(roomDao.getReferenceById(anyLong())).willReturn(window.getRoom());
        given(windowDao.getReferenceById(anyLong())).willReturn(window);
    }

    @Test
    void switchWindow() throws Exception {
        Window window = createWindow("window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);

        given(windowDao.findById(69L)).willReturn(Optional.of(window));
    }



    private Window createWindow(String name) {
        Room room = new Room("window 1", 1L, 0, new Building());
        return new Window(name,  WindowStatus.CLOSED, room);
    }
}
