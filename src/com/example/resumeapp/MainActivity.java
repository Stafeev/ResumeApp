package com.example.resumeapp;



import java.util.Calendar;

import com.example.myfirstapp.R;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

	//private Spinner gender_spinner;
	static EditText mEdit;
	public final static String NAME = "com.example.myfirstapp.NAME_MESSAGE";
	public final static String DATE = "com.example.myfirstapp.DATE_MESSAGE";
	public final static String GENDER = "com.example.myfirstapp.GENDER_MESSAGE";
	public final static String POSITION = "com.example.myfirstapp.POSITION_MESSAGE";
	public final static String SALARY = "com.example.myfirstapp.SALARY_MESSAGE";
	public final static String PHONE = "com.example.myfirstapp.PHONE_MESSAGE";
	public final static String EMAIL = "com.example.myfirstapp.EMAIL_MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//addItemsOnSpinner();
	}
	
	@Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null) {return;}
	    String response = data.getStringExtra("MESSAGE");
	    // Create the text view
	    TextView responseView = new TextView(this);
	    responseView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	    responseView.setGravity(Gravity.TOP | Gravity.LEFT);
	    responseView.setText(response);
	    responseView.setTextSize(20);
	    LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mylayout);
	    linearLayout.addView(responseView);
	    TextView vT = (TextView) findViewById(R.id.visibleText);
	    vT.setVisibility(View.VISIBLE);
	  }
	
	/** Called when the user clicks the SendResume button */
	public void sendResume(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		//add name
		EditText nameEditText = (EditText) findViewById(R.id.name);
		String nameString = nameEditText.getText().toString();
		intent.putExtra(NAME, nameString);
		//add date
		EditText dateEditText = (EditText) findViewById(R.id.date);
		String dateString = dateEditText.getText().toString();
		intent.putExtra(DATE, dateString);
		//add gender
		Spinner genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
		String genderString = genderSpinner.getItemAtPosition(genderSpinner.getSelectedItemPosition()).toString();
		intent.putExtra(GENDER, genderString);
		//add position
		EditText positionEditText = (EditText) findViewById(R.id.position);
		String positionString = positionEditText.getText().toString();
		intent.putExtra(POSITION, positionString);
		//add salary
		EditText salaryEditText = (EditText) findViewById(R.id.salary);
		String salaryString = salaryEditText.getText().toString();
		intent.putExtra(SALARY, salaryString);
		//add phone
		EditText phoneEditText = (EditText) findViewById(R.id.phone);
		String phoneString = phoneEditText.getText().toString();
		intent.putExtra(PHONE, phoneString);
		//add email
		EditText emailEditText = (EditText) findViewById(R.id.email);
		String emailString = emailEditText.getText().toString();
		intent.putExtra(EMAIL, emailString);
		
		startActivityForResult(intent,1);
	}
	
	
	 /*public void addItemsOnSpinner() {
		 gender_spinner = (Spinner) findViewById(R.id.gender_spinner);
		 final List<String> items = new ArrayList<String>();
		 items.add("Укажите пол");
		 items.add("Мужской");
		 items.add("Женский");
		 final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		            android.R.layout.simple_spinner_item, items);
		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 gender_spinner.setAdapter(adapter);
		 gender_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			 @Override
			 public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				//removing the first element
				 if (items.size()==3){
					 items.remove(0);
					 final List<String> new_items = new ArrayList<String>();
					 new_items.add("Мужской");
					 new_items.add("Женский");
					 final ArrayAdapter<String> new_adapter = new ArrayAdapter<String>(getBaseContext(),
					            android.R.layout.simple_spinner_item, new_items);
					 new_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					 gender_spinner.setAdapter(new_adapter);
					 }
				 if (position==0){
					 gender_spinner.setSelection(position);
					 }
				 }
			 @Override
			 public void onNothingSelected(AdapterView<?> arg0) {
				 
			 }
			 });
		 }*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void selectDate(View view) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "DatePicker");
		}
	
	public static class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
			}
		public void onDateSet(DatePicker view, int year, int month, int day) {
			mEdit = (EditText)getActivity().findViewById(R.id.date);
			mEdit.setText(day+"/"+month+"/"+year);
			}
		}
}
