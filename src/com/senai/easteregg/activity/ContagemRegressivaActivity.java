package com.senai.easteregg.activity;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.senai.easteregg.R;

public class ContagemRegressivaActivity extends Activity {

	@SuppressWarnings("unused")
	private TextView tv_contador, tv_jogar;
	private String data = "Não";
	
	private Calendar cal = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contagem_regressiva);
		tv_contador = (TextView) findViewById(R.id.tv_contador);
		tv_jogar = (TextView) findViewById(R.id.tv_jogar);

		if (horaDoJogo()) {
			Toast.makeText(this, "Hora do jogo", Toast.LENGTH_LONG).show();
			Intent i = new Intent(this, CheckpointActivity.class);
			startActivity(i);
		} else {
			Toast.makeText(this, "Ainda não é hora do jogo", Toast.LENGTH_LONG)
					.show();
			
			tv_jogar.setEnabled(false);
			
			hora();
			
		}
		
		}
	

	private void hora() {
		try {
			Calendar c = Calendar.getInstance();

			int dia, hora, min, seg;
			long aux1, aux;
			String sDia, sHora, sMin, sSeg;

			long mil = c.getTimeInMillis();
			long mils = cal.getTimeInMillis();

			long total = (mils - mil);
			
			if (total / 86400000 > 0) {

				seg = (int) ((total / 1000) % 60);
				min = (int) ((total / 60000) % 60); // 60000 = 60 * 1000
				hora = (int) ((total / 3600000) % 24); // 3600000 = 60 * 60 *
														// 1000
				dia = (int) (total / 86400000); // 86400000 = 24 * 60 * 60 *
												// 1000

				sDia = dia < 10 ? "0" + dia : "" + dia;
				sHora = hora < 10 ? "0" + hora : "" + hora;
				sMin = min < 10 ? "0" + min : "" + min;
				sSeg = seg < 10 ? "0" + seg : "" + seg;
				data = "" + sDia + "D- " + sHora + "H- " + sMin + "M";
				

			} else {
				seg = (int) ((total / 1000) % 60);
				min = (int) ((total / 60000) % 60); // 60000 = 60 * 1000
				hora = (int) (total / 3600000); // 3600000 = 60 * 60 * 1000
				sHora = hora < 10 ? "0" + hora : "" + hora;
				sMin = min < 10 ? "0" + min : "" + min;
				sSeg = seg < 10 ? "0" + seg : "" + seg;
				data = "00D- " + sHora + "H- " + sMin + "M";
			}
			tv_contador.setText("" + data);
			
		} catch (NullPointerException e) {
			Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(this, "Fail2", Toast.LENGTH_LONG).show();
		}
		
		

	}

	public void hora(View v) {
		hora();

	}


	private boolean horaDoJogo() {

		// Set time of calendar to 18:00
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 11);
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
	private void instrucoes() {
		Intent intent = new Intent(this, InstrucoesActivity.class);
		startActivity(intent);
	}
	private void regras() {
		Intent intent = new Intent(this, RegrasActivity.class);
		startActivity(intent);
	}
	private void creditos() {
		Intent i = new Intent(this, CreditosActivity.class);
		startActivity(i);

	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_instrucoes) {
			instrucoes();
			return true;
		}
		else if (id == R.id.action_creditos) {
			creditos();
			return true;
		}
		else if (id == R.id.action_regras) {
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

