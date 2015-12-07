package marceloferracin.autocifra.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import marceloferracin.autocifra.R;
import marceloferracin.autocifra.utils.Resources;
import marceloferracin.autocifra.utils.Validations;

public class SignUpActivity extends AppCompatActivity {
    private EditText mSignUpEmailEditText;
    private EditText mSignUpPasswordEditText;
    private EditText mSignUpConfirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
        toolbarTitle.setText(getString(R.string.sign_up_title));

        initComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_default, menu);
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
        mSignUpEmailEditText = (EditText) findViewById(R.id.signUpEmailEditText);
        mSignUpPasswordEditText = (EditText) findViewById(R.id.signUpPasswordEditText);
        mSignUpConfirmPasswordEditText = (EditText) findViewById(R.id.signUpConfirmPasswordEditText);
        Button signUpFinishButton = (Button) findViewById(R.id.signUpFinishButton);
        Spinner mainInstrumentSpinner = (Spinner) findViewById(R.id.mainInstrumentSpinner);

        signUpFinishButton.setOnClickListener(setSignUpClick());
        CharSequence instruments[] = getResources().getStringArray(R.array.instrumentOptions);
        mainInstrumentSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, instruments));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private View.OnClickListener setSignUpClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int validationId = validateFields();

                if (validationId == -1) {
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, Resources.getStringById(SignUpActivity.this,
                            validationId), Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    private int validateFields() {
        if (!Validations.emailValidation(mSignUpEmailEditText.getText().toString())) {
            return R.string.sign_up_email_invalid;
        } else if (mSignUpPasswordEditText.getText().length() > 5) {
            if (!Validations.passwordConfirmation(mSignUpPasswordEditText.getText().toString(),
                    mSignUpConfirmPasswordEditText.getText().toString())) {
                return R.string.sign_up_password_invalid;
            }
        } else {
            return R.string.sign_up_confirm_password_invalid;
        }

        return -1;
    }
}