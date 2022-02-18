package events.huhackathon2022;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User2 {
    @PrimaryKey(autoGenerate = true)
    public int userID;

    @ColumnInfo(name = "user_name")
    public String userName;

    @ColumnInfo(name = "email_address")
    public String emailAddress;

    @ColumnInfo(name = "latitude")
    public double latitude;

    @ColumnInfo(name = "longitude")
    public double longitude;

    @ColumnInfo(name = "deliver_point")
    public int deliverPoint;

    public User2(){
    }

    public User2(int i, String userName, String userEmailOrPhone, double userLatitude, double userLongitude, int deliverP) {
        this.userID = i;
        this.userName = userName;
        this.emailAddress = userEmailOrPhone;
        this.latitude = userLatitude;
        this.longitude = userLongitude;
        this.deliverPoint = deliverP;
    }
}