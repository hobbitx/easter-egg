package com.senai.easteregg.activity;

import java.util.Calendar;

import com.senai.easteregg.R;
import com.senai.easteregg.R.id;
import com.senai.easteregg.R.layout;
import com.senai.easteregg.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ContagemRegressivaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (horaDoJogo()) {
			Toast.makeText(this, "Hora do jogo", Toast.LENGTH_LONG).show();
		}else {
			Toast.makeText(this, "Ainda não é hora do jogo", Toast.LENGTH_LONG).show();
			setContentView(R.layout.activity_contagem_regressiva);
		}
	}
	
	private boolean horaDoJogo() {
		 // Get calendar set to the current date and time
		Calendar cal = Calendar.getInstance();

		// Set time of calendar to 18:00
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		// Check if current time is after 18:00 today
		return Calendar.getInstance().after(cal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_contagem_regressiva, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
