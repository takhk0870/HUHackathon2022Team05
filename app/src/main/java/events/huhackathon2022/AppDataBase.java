package events.huhackathon2022;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Request.class, DeliverPoints.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract RequestDao requestDao();
    public abstract DeliverPointsDao deliverPointsDao();
}
