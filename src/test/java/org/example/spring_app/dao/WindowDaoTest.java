package org.example.spring_app.dao;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.example.spring_app.model.Room;
import org.example.spring_app.model.Window;
import org.example.spring_app.model.WindowStatus;
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
class WindowDaoTest {

    @Autowired
    private WindowDao windowDao;
    @Autowired
    private RoomDao roomDao;

    @Test
    public void findWindow() {
        Window window = windowDao.getReferenceById(1L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
    }

    @Test
    public void deleteWindowsRoom() {
        Room room = roomDao.getReferenceById(1L);
        Set<Window> windows = room.getWindows();
        List<Long> windowIds = windows.stream().map(w -> w.getId()).collect(Collectors.toList());
        Assertions.assertThat(windowIds.size()).isEqualTo(2);

        windowDao.deleteByRoom(1L);

        List<Window> result = windowDao.findAllById(windowIds);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void findRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(2L);
        Assertions.assertThat(result).hasSize(1).extracting("id", "windowStatus").containsExactly(Tuple.tuple(4L, WindowStatus.OPEN));
    }

    @Test
    public void notFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(1L);
        Assertions.assertThat(result).isEmpty();
    }
}
