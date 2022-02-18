package events.huhackathon2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intentToMain = new Intent(this, MainActivity.class);
        AppDatabase2 db = Room.databaseBuilder(this, AppDatabase2.class, "User2").build();
        UserDao2 userDao = db.userDao();

        EditText etUserNameLogin         = findViewById(R.id.etUserNameLogin);
        EditText etUserEmailOrPhoneLogin = findViewById(R.id.etUserEmailOrPhoneLogin);
        TextView tvShowError             = findViewById(R.id.tvShowError);
        Button   loginButton             = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameLogin  = etUserNameLogin.getText().toString();
                String userEmailLogin = etUserEmailOrPhoneLogin.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(userDao.findByNameAndEmailAddress(userNameLogin, userEmailLogin) != null) {
                            User2 user = userDao.findByNameAndEmailAddress(userNameLogin, userEmailLogin);
                            intentToMain.putExtra("user_name", user.userName);
                            intentToMain.putExtra("deliver_point", user.deliverPoint);
                            intentToMain.putExtra("email_address", user.emailAddress);

                            startActivity(intentToMain);
                        }else{
                            tvShowError.setText("名前またはメールアドレス(電話番号)が間違っています");
                        }
                    }
                }).start();
            }
        });
    }
}
