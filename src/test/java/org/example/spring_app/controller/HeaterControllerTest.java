package org.example.spring_app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.example.spring_app.dao.HeaterDao;
import org.example.spring_app.dao.RoomDao;
import org.example.spring_app.dto.HeaterDto;
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


@WebMvcTest(HeaterController.class)
public class HeaterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HeaterDao heaterDao;

    @MockBean
    private RoomDao roomDao;



    @Test
    void loadHeater() throws Exception {
        given(heaterDao.findAll()).willReturn(List.of(
                createHeater("heater 1"),
                createHeater("heater 2")
        ));
    }

    @Test
    void returnNullIfNotFound() throws Exception {
        given(heaterDao.findById(69L)).willReturn(Optional.empty());
    }

    @Test
    void createHeater() throws Exception {
        Heater heater = createHeater("heater 1");

        given(roomDao.getReferenceById(anyLong())).willReturn(heater.getRoom());
        given(heaterDao.save(any())).willReturn(heater);
    }

    @Test
    void updateHeater() throws Exception {
        Heater heater = createHeater("heater 1");
        heater.setId(1L);

        given(roomDao.getReferenceById(anyLong())).willReturn(heater.getRoom());
        given(heaterDao.getReferenceById(anyLong())).willReturn(heater);
    }

    @Test
    void switchHeater() throws Exception {
        Heater heater = createHeater("heater 1");
        Assertions.assertThat(heater.getHeater_status()).isEqualTo(HeaterStatus.ON);

        given(heaterDao.findById(69L)).willReturn(Optional.of(heater));
    }



    private Heater createHeater(String name) {
        Room room = new Room("room 1", 1L, 0, new Building());
        return new Heater(name, 5L, room, HeaterStatus.ON);
    }
}
