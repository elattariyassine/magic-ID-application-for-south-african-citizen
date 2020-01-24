package com.isi.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etID;
    private Button btnSubmit;
    private TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = (EditText) findViewById(R.id.editText);
        btnSubmit = (Button) findViewById(R.id.button);
        tvResults = (TextView) findViewById(R.id.textView);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = etID.getText().toString().trim();
                String dob = idNumber.substring(0, 6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;

                if (gender < 5)
                {
                    sGender = getString(R.string.female);
                }
                else
                {
                    sGender = getString(R.string.male);
                }

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;

                if (nationality == 0)
                {
                    sNationality = getString(R.string.Citizen);
                }
                else
                {
                    sNationality = getString(R.string.pResident);
                }
                String text = getString(R.string.dob) + dob + "\n" +
                        getString(R.string.gender) + sGender + "\n" +
                        getString(R.string.nationality) + sNationality;
                tvResults.setText(text);

                tvResults.setVisibility(View.VISIBLE);
            }
        });


    }
}
