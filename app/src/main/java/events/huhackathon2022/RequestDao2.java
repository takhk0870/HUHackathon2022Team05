package events.huhackathon2022;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RequestDao2 {
    @Query("SELECT * FROM request2")
    List<Request2> getAll();

    @Query("SELECT * FROM request2 WHERE userID IN (:userIds)")
    List<Request2> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM request2 WHERE user_name = (:userName) AND email_address = (:emailAddress)")
    List<Request2> loadAllByNameAndEmailAddress(String userName, String emailAddress);

    @Insert
    void insert(Request2 request);

    @Delete
    void delete(Request2 request);
}