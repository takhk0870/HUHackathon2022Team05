package events.huhackathon2022;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class WithMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withmap);

        double[][] deliverPoints = {{12.321, 45.395}, {65.598, 65.279}, {23.798, 17.984},};
    }
}
