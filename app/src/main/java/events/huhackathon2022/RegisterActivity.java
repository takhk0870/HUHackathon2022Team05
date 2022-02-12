package events.huhackathon2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Intent intentToWithMap = new Intent(this, WithMapActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText etUserName         = findViewById(R.id.etUserName);
        EditText etUserEmailOrPhone = findViewById(R.id.etUserEmailOrPhone);
        EditText etUserLatitude     = findViewById(R.id.etUserLatitude);
        EditText etUserLongitude    = findViewById(R.id.etUserLongitude);

        String userName         = etUserName.getText().toString();
        String userEmailOrPhone = etUserEmailOrPhone.getText().toString();
        double userLatitude = Double.parseDouble(etUserLatitude.getText().toString());
        double userLongitude = Double.parseDouble(etUserLongitude.getText().toString());

        if(userName.length() != 0 && userEmailOrPhone.length() != 0){
            intentToWithMap.putExtra("user_name", userName);
            intentToWithMap.putExtra("user_emailOrPhone", userEmailOrPhone);
            intentToWithMap.putExtra("user_latitude", userLatitude);
            intentToWithMap.putExtra("user_longitude", userLongitude);

            startActivity(intentToWithMap);
        }

    }
}
