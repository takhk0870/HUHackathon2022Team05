package events.huhackathon2022;

import androidx.annotation.NonNull;
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

    @NonNull
    public String toString(){
        return "希望日: " + dayWant + ", 依頼: " + whatWant;
    }

    public Request(){}

    public Request(int i, String un, String ea, String ww, String dw, int dp){
        this.userID = i;
        this.userName = un;
        this.emailAddress = ea;
        this.whatWant = ww;
        this.dayWant = dw;
        this.deliverPoint = dp;
    }
}