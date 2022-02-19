package events.huhackathon2022;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WithMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withmap);

        Intent intentToMap  = new Intent(this, WithMapsActivity.class);
        Intent intentToMain = new Intent(this, MainActivity.class);

        double[][] deliverPoints = {{43.0726, 141.3421}, {43.0685, 141.3507}, {43.448, 141.1953},};

        Intent intent    = getIntent();
        double userLatitude  = intent.getDoubleExtra("latitude", 0);
        double userLongitude = intent.getDoubleExtra("longitude", 0);
        int deliverPoint = intent.getIntExtra("deliver_point", -1);
        String userName  = intent.getStringExtra("user_name");
        String emailAddress = intent.getStringExtra("email_address");
        TextView tvShowDeliverPoint = findViewById(R.id.tvShowDeliverPoint);
        Button   buttonToMain       = findViewById(R.id.buttonToMain);
        Button   buttonToMap        = findViewById(R.id.buttonToMap);

        String str = "あなた宛ての荷物は\n" + deliverPoint + "番の地点に送られます";
        tvShowDeliverPoint.setText(str);

        buttonToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToMap.putExtra("user_latitude", userLatitude);
                intentToMap.putExtra("user_longitude", userLongitude);
                intentToMap.putExtra("latitude", deliverPoints[deliverPoint-1][0]);
                intentToMap.putExtra("longitude", deliverPoints[deliverPoint-1][1]);

                startActivity(intentToMap);
            }
        });

        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToMain.putExtra("user_name", userName);
                intentToMain.putExtra("email_address", emailAddress);
                intentToMain.putExtra("deliver_point", deliverPoint);
                startActivity(intentToMain);
            }
        });
    }
}