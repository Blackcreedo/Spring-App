package org.example.spring_app.dao;

import org.example.spring_app.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomDao extends JpaRepository<Room, Long> {

    @Modifying
    @Query("delete from Room r where r.building.id=:id")
    void deleteByBuilding(@Param("id") long id);
}
