package events.huhackathon2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intentToWithMap = new Intent(this, WithMapActivity.class);

        AppDataBase db = Room.databaseBuilder(this, AppDataBase.class, "User").build();
        UserDao userDao = db.userDao();

        double[][] deliverPoints = {{12.321, 45.395}, {65.598, 65.279}, {23.798, 17.984}, };

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditText etUserName         = findViewById(R.id.etUserName);
                        EditText etUserEmailOrPhone = findViewById(R.id.etUserEmailOrPhone);
                        EditText etUserLatitude     = findViewById(R.id.etUserLatitude);
                        EditText etUserLongitude    = findViewById(R.id.etUserLongitude);

                        String userName         = etUserName.getText().toString().trim();
                        String userEmailOrPhone = etUserEmailOrPhone.getText().toString();
                        double userLatitude     = Double.parseDouble(etUserLatitude.getText().toString());
                        double userLongitude    = Double.parseDouble(etUserLongitude.getText().toString());

                        if(userName.length() != 0 && userEmailOrPhone.length() != 0){

                            int deliverP = 0;
                            double distance = Math.pow((userLatitude - deliverPoints[0][0]), 2) + Math.pow((userLongitude - deliverPoints[0][1]), 2);

                            for(int i = 0 ; i < deliverPoints.length; i++){
                                double d = Math.pow((userLatitude - deliverPoints[i][0]), 2) + Math.pow((userLongitude - deliverPoints[i][1]), 2);

                                if(d < distance){
                                    deliverP = i;
                                    distance = d;
                                }
                            }

                            int finalDeliverP = deliverP;
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    userDao.insert(new User(0, userName, userEmailOrPhone, userLatitude, userLongitude, finalDeliverP));
                                }
                            });

                            intentToWithMap.putExtra("deliver_point", deliverP);

                            startActivity(intentToWithMap);
                        }
                    }
                }
        );

    }
}
