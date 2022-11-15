package org.example.spring_app.dao;

import org.assertj.core.api.Assertions;
import org.example.spring_app.model.Building;
import org.example.spring_app.model.Room;
import org.example.spring_app.model.Window;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@ExtendWith(SpringExtension.class)

@DataJpaTest
class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private BuildingDao buildingDao;

    @Autowired
    private WindowDao windowDao;

    @Autowired
    private HeaterDao heaterDao;

    @Test
    public void findRoom() {
        Room room = roomDao.getReferenceById(1L);
        Assertions.assertThat(room.getName()).isEqualTo("Room 1");
        Assertions.assertThat(room.getCurrent_temperature()).isEqualTo(22.3);
    }

    @Test
    public void deleteRoom() {
        Building building = buildingDao.getReferenceById(1L);
        Set<Room> rooms = building.getRooms();
        List<Long> roomsIds = rooms.stream().map(r -> r.getId()).collect(Collectors.toList());
        Assertions.assertThat(roomsIds.size()).isEqualTo(18);

        for (Long roomId : roomsIds){
            windowDao.deleteByRoom(roomId);
            heaterDao.deleteByRoom(roomId);
        }
        roomDao.deleteByBuilding(1L);

        List<Room> result = roomDao.findAllById(roomsIds);
        Assertions.assertThat(result).isEmpty();
    }
}
