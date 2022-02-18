package events.huhackathon2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class CheckRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkrequest);

        Intent intentToMain    = new Intent(this, MainActivity.class);
        Intent intentToRequest = new Intent(this, RequestActivity.class);
        AppDatabase2 db = Room.databaseBuilder(this, AppDatabase2.class, "Request2").build();
        RequestDao2 requestDao = db.requestDao();

        Intent intent = getIntent();
        String userName     = intent.getStringExtra("user_name");
        String emailAddress = intent.getStringExtra("email_address");
        int deliverPoint    = intent.getIntExtra("deliver_point", -1);
        String dayWant      = intent.getStringExtra("day_want");
        String whatWant     = intent.getStringExtra("what_want");

        TextView tvDP       = findViewById(R.id.tvDP);
        TextView tvDayWant  = findViewById(R.id.tvDayWant);
        TextView tvWhatWant = findViewById(R.id.tvWhatWant);
        Button checkButton = findViewById(R.id.checkButton);
        Button buttonToBackRequest = findViewById(R.id.buttonToBackRequest);

        String setDP = tvDP.getText() + " " + deliverPoint + "番";
        tvDP.setText(setDP);
        String setDayWant = tvDayWant.getText() + " " + dayWant;
        tvDayWant.setText(setDayWant);
        String setWhatWant = tvWhatWant.getText() + "\n　" + whatWant;
        tvWhatWant.setText(setWhatWant);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        requestDao.insert(new Request2(0, userName, emailAddress, whatWant, dayWant, deliverPoint));
                    }
                }).start();

                intentToMain.putExtra("user_name", userName);
                intentToMain.putExtra("email_address", emailAddress);
                intentToMain.putExtra("deliver_point", deliverPoint);
                startActivity(intentToMain);
            }
        });

        buttonToBackRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToRequest.putExtra("user_name", userName);
                intentToRequest.putExtra("email_address", emailAddress);
                intentToRequest.putExtra("deliver_point", deliverPoint);
                startActivity(intentToRequest);
            }
        });
    }
}
