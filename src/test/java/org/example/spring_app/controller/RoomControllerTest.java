package org.example.spring_app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.spring_app.dao.BuildingDao;
import org.example.spring_app.dao.HeaterDao;
import org.example.spring_app.dao.RoomDao;
import org.example.spring_app.dao.WindowDao;
import org.example.spring_app.dto.RoomDto;
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


@WebMvcTest(RoomController.class)
public class RoomControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RoomDao roomDao;
    @MockBean
    private BuildingDao buildingDao;
    @MockBean
    private HeaterDao heaterDao;
    @MockBean
    private WindowDao windowDao;


    @Test
    void loadRoom() throws Exception {
        given(roomDao.findAll()).willReturn(List.of(
                createRoom("room 1"),
                createRoom("room 2")
        ));
    }

    @Test
    void returnNullIfRoomNotFound() throws Exception {
        given(roomDao.findById(69L)).willReturn(Optional.empty());
    }


    @Test
    void createRoom() throws Exception {
        Room room = createRoom("room 1");
        given(roomDao.save(any())).willReturn(room);
    }

    @Test
    void updateHeater() throws Exception {
        Room room = createRoom("room 1");
        room.setId(1L);
        given(roomDao.getReferenceById(anyLong())).willReturn(room);
    }


    private Room createRoom(String name) {
        return new Room(name, 10L, 0, new Building());
    }
}
