package marceloferracin.autocifra.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.controls.SharedPreferencesControl;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.login_title));

        initComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cifra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initComponents() {
        Button signUpButton = (Button) findViewById(R.id.signUpButton);
        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(setLoginClick());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private View.OnClickListener setLoginClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesControl sharedPreferencesControl = new SharedPreferencesControl(LoginActivity.this);
                sharedPreferencesControl.setIsLogged(true);

                MainActivity.getInstance().updateProfileInfo();
                finish();
            }
        };
    }
}