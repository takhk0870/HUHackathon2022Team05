package events.huhackathon2022;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User2.class, Request2.class}, version = 1, exportSchema = false)
public abstract class AppDatabase2 extends RoomDatabase {
    public abstract UserDao2 userDao();
    public abstract RequestDao2 requestDao();
}