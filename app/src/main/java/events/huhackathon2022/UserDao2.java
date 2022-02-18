package events.huhackathon2022;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao2 {
    @Query("SELECT * FROM user2")
    List<User2> getAll();

    @Query("SELECT * FROM user2 WHERE userID IN (:userIds)")
    List<User2> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user2 WHERE user_name = (:userName) AND email_address = (:emailAddress) LIMIT 1")
    User2 findByNameAndEmailAddress(String userName, String emailAddress);

    @Insert
    void insert(User2 user);

    @Query("DELETE FROM user2")
    void reset();

    @Delete
    void delete(User2 user);
}