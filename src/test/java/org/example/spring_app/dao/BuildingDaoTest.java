package org.example.spring_app.dao;

import org.assertj.core.api.Assertions;
import org.example.spring_app.model.Building;
import org.example.spring_app.model.Heater;
import org.example.spring_app.model.Room;
import org.example.spring_app.model.Window;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)

@DataJpaTest
class BuildingDaoTest {


    @Autowired
    private BuildingDao buildingDao;


    @Test
    public void findBuilding() {
        Building building = buildingDao.getReferenceById(1L);
        Assertions.assertThat(building.getName()).isEqualTo("MA GROSSE MAISON");
    }

    @Test
    public void findRooms() {
        List<Room> rooms = buildingDao.findBuildingRooms(1L);
        Assertions.assertThat(rooms).hasSize(18).extracting("id").containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L);
    }

    @Test
    public void findWindows() {
        List<Window> windows = buildingDao.findBuildingWindows(1L);
        Assertions.assertThat(windows).hasSize(4).extracting("id").containsExactly(1L, 2L, 3L, 4L);
    }

    @Test
    public void findHeaters() {
        List<Heater> heaters = buildingDao.findBuildingHeaters(1L);
        Assertions.assertThat(heaters).hasSize(2).extracting("id").containsExactly(1L, 2L);
    }
}
