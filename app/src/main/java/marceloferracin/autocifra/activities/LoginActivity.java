package marceloferracin.autocifra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.controls.SharedPreferencesControl;
import marceloferracin.autocifra.utils.Validations;

public class LoginActivity extends AppCompatActivity {
    private EditText mLoginEmailEditText;
    private EditText mLoginPasswordEditText;

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
        mLoginEmailEditText = (EditText) findViewById(R.id.loginEmailEditText);
        mLoginPasswordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
        Button signUpButton = (Button) findViewById(R.id.signUpButton);
        Button loginButton = (Button) findViewById(R.id.loginButton);

        signUpButton.setOnClickListener(setSignUpClick());
        loginButton.setOnClickListener(setLoginClick());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private View.OnClickListener setSignUpClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener setLoginClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields() != -1) {
                    SharedPreferencesControl sharedPreferencesControl = new SharedPreferencesControl(LoginActivity.this);
                    sharedPreferencesControl.setIsLogged(true);

                    MainActivity.getInstance().updateProfileInfo();
                    finish();
                } else {
                    //TODO Trocar Toast
                    Toast.makeText(LoginActivity.this, "Erro de validação", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    private int validateFields() {
        if (!Validations.emailValidation(mLoginEmailEditText.getText().toString())) {
            return 0;
        } else if (mLoginPasswordEditText.getText().length() < 6) {
            return 1;
        }

        return -1;
    }
}