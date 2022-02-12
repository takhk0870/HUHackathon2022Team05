package events.huhackathon2022;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DeliverPoints {
    @PrimaryKey
    public int deliverPointID;

    @ColumnInfo(name = "point_latitude")
    public double pointLatitude;

    @ColumnInfo(name = "point_longitude")
    public double pointLongitude;
}
