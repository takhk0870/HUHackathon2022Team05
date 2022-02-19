package events.huhackathon2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        System.out.println(this.getDatabasePath("Request.db").getParent());

        Intent intentToRegister = new Intent(this, RegisterActivity.class);
        Intent intentToLogIn    = new Intent(this, LogInActivity.class);

        Button toRegisterButton = findViewById(R.id.toRegisterButton);
        Button toLogInButton    = findViewById(R.id.toLogInButton);

        toRegisterButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentToRegister);
                    }
                }
        );

        toLogInButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intentToLogIn);
                    }
                }
        );
    }
}