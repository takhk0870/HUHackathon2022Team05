package events.huhackathon2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        Intent intentToRequest  = new Intent(this, RequestActivity.class);
        Intent intentToChangeRQ = new Intent(this, ChangeRequestActivity.class);
        Intent intentToChangeDP = new Intent(this, ChangeDPActivity.class);
        Intent intentToStart    = new Intent(this, StartActivity.class);
        AppDatabase2 db = Room.databaseBuilder(this, AppDatabase2.class, "Request2").build();
        RequestDao2 requestDao = db.requestDao();

        TextView tvShowName     = findViewById(R.id.tvShowName);
        TextView tvShowRequest  = findViewById(R.id.tvShowRequest);
        Button buttonToRequest  = findViewById(R.id.buttonToRequest);
        Button buttonToChangeRQ = findViewById(R.id.buttonToChangeRQ);
        Button buttonToChangeDP = findViewById(R.id.buttonToChangeDP);
        Button logoutButton     = findViewById(R.id.logoutButton);

        Intent intent = getIntent();
        String userName     = intent.getStringExtra("user_name");
        String emailAddress = intent.getStringExtra("email_address");
        int deliverPoint    = intent.getIntExtra("deliver_point", -1);

        String setName = userName + "さんの依頼画面";
        tvShowName.setText(setName);

        new Thread(new Runnable() {
            @Override
            public void run() {
                if(requestDao.loadAllByNameAndEmailAddress(userName, emailAddress) != null){
                    for(Request2 request : requestDao.loadAllByNameAndEmailAddress(userName, emailAddress)){
                        String str = tvShowRequest.getText() + "\n " + request.toString();
                        tvShowRequest.setText(str);
                    }
                }
            }
        }).start();

        //button挙動
        buttonToRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToRequest.putExtra("user_name", userName);
                intentToRequest.putExtra("email_address", emailAddress);
                intentToRequest.putExtra("deliver_point", deliverPoint);
                startActivity(intentToRequest);
            }
        });

        buttonToChangeRQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToChangeRQ.putExtra("user_name", userName);
                intentToChangeRQ.putExtra("email_address", emailAddress);
                startActivity(intentToChangeRQ);
            }
        });

        buttonToChangeDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToChangeDP.putExtra("user_name", userName);
                intentToChangeDP.putExtra("deliver_point", deliverPoint);
                startActivity(intentToChangeDP);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentToStart);
            }
        });
    }
}
