package events.huhackathon2022;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DeliverPointsDao {
    @Query("SELECT * FROM deliverpoints")
    List<DeliverPoints> getAll();

    @Query("SELECT point_latitude, point_longitude FROM deliverpoints WHERE deliverPointID = (:deliverPoint)")
    List<Double> loadAllByIds(int deliverPoint);

    @Insert
    void insertAll(DeliverPoints... deliverPoints);

    @Delete
    void delete(DeliverPoints deliverPoint);
}
