package events.huhackathon2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        Intent intentToCheckRequest = new Intent(this, CheckRequestActivity.class);
        Intent intentToBackMain     = new Intent(this, MainActivity.class);
        Intent intent = getIntent();
        String userName     = intent.getStringExtra("user_name");
        String emailAddress = intent.getStringExtra("email_address");
        int deliverPoint    = intent.getIntExtra("deliver_point", -1);

        Button requestButton    = findViewById(R.id.requestButton);
        Button buttonToBackMain = findViewById(R.id.buttonToBackMain);
        EditText etDayWant   = findViewById(R.id.etDayWant);
        EditText etWhatWant  = findViewById(R.id.etWhatWant);
        TextView tvShowError = findViewById(R.id.tvShowErrorAtR);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dayWant  = etDayWant.getText().toString();
                String whatWant = etWhatWant.getText().toString();

                if(dayWant.length() != 0 && whatWant.length() != 0){
                    intentToCheckRequest.putExtra("day_want", dayWant);
                    intentToCheckRequest.putExtra("what_want", whatWant);
                    intentToCheckRequest.putExtra("user_name", userName);
                    intentToCheckRequest.putExtra("deliver_point", deliverPoint);
                    intentToCheckRequest.putExtra("email_address", emailAddress);

                    startActivity(intentToCheckRequest);
                }else{
                    tvShowError.setText("必要な情報が入力されていません");
                }
            }
        });

        buttonToBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentToBackMain.putExtra("user_name", userName);
                intentToBackMain.putExtra("email_address", emailAddress);
                intentToBackMain.putExtra("deliver_point", deliverPoint);

                startActivity(intentToBackMain);
            }
        });
    }
}
