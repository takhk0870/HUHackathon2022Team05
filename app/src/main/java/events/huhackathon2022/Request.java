package events.huhackathon2022;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity
public class Request {
    @PrimaryKey
    public int userID;

    @ColumnInfo(name = "user_name")
    public String userName;

    @ColumnInfo(name = "email_address")
    public String emailAddress;

    @ColumnInfo(name = "what_want")
    public String whatWant;

    @ColumnInfo(name = "day_want")
    public String dayWant;

    @ColumnInfo(name = "deliver_point")
    public int deliverPoint;
}