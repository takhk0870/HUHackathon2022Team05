package events.huhackathon2022;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE userID IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE user_name = :userName AND email_address = :emailAddress")
    User findByNameAndEmailAddress(String userName, String emailAddress);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}