package com.example.resumeapp;

import com.example.myfirstapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.util.Linkify;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayMessageActivity extends Activity {

	public final static String MESSAGE = "com.example.myfirstapp.MESSAGE";
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get messages from the intent
	    Intent intent = getIntent();
	    String nameString = intent.getStringExtra(MainActivity.NAME);
	    String dateString = intent.getStringExtra(MainActivity.DATE);
	    String genderString = intent.getStringExtra(MainActivity.GENDER);
	    String positionString = intent.getStringExtra(MainActivity.POSITION);
	    String salaryString = intent.getStringExtra(MainActivity.SALARY);
	    String phoneString = intent.getStringExtra(MainActivity.PHONE);
	    String emailString = intent.getStringExtra(MainActivity.EMAIL);

	    setContentView(R.layout.activity_display_message);
	    // Set text views
	    TextView name = (TextView) findViewById(R.id.candidate_name);
	    name.setText(nameString);
	    TextView date = (TextView) findViewById(R.id.candidate_date);
	    date.setText("Дата рождения: "+dateString);
	    TextView gender = (TextView) findViewById(R.id.candidate_gender);
	    gender.setText("Пол: "+genderString);
	    TextView position = (TextView) findViewById(R.id.candidate_position);
	    position.setText("Должность: "+positionString);
	    TextView salary = (TextView) findViewById(R.id.candidate_salary);
	    salary.setText("Уровень зарплаты: "+salaryString);
	    TextView phone = (TextView) findViewById(R.id.candidate_phone);
	    phone.setText(phoneString);
	    Linkify.addLinks(phone, Linkify.PHONE_NUMBERS);
	    TextView email = (TextView) findViewById(R.id.candidate_email);
	    email.setText(emailString);
	    Linkify.addLinks(email, Linkify.EMAIL_ADDRESSES);

	}
	
	public void sendMessage(View view) {
	    // Send message
		Intent intent = new Intent();
		EditText letter = (EditText) findViewById(R.id.letter);
		String letterString = letter.getText().toString();
	    intent.putExtra("MESSAGE", letterString);
	    setResult(RESULT_OK, intent);
	    finish();
	}
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
