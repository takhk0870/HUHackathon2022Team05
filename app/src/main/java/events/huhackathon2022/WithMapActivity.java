package events.huhackathon2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class WithMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withmap);

        Intent intentToMain = new Intent(this, MainActivity.class);

        double[][] deliverPoints = {{12.321, 45.395}, {65.598, 65.279}, {23.798, 17.984},};

        Intent intent    = getIntent();
        int deliverPoint = intent.getIntExtra("deliver_point", -1);
        String userName  = intent.getStringExtra("user_name");
        String emailAddress = intent.getStringExtra("email_address");
        TextView tvShowDeliverPoint = findViewById(R.id.tvShowDeliverPoint);
        Button   buttonToMain       = findViewById(R.id.buttonToMain);

        String str = "あなた宛ての荷物は\n" + deliverPoint + "番の地点に送られます";
        tvShowDeliverPoint.setText(str);

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
