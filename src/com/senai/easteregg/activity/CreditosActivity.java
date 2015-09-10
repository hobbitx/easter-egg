package com.senai.easteregg.activity;

import com.senai.easteregg.R;
import com.senai.easteregg.R.id;
import com.senai.easteregg.R.layout;
import com.senai.easteregg.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CreditosActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_creditos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.creditos, menu);
		return true;
	}
	private void instrucoes() {
		Intent intent = new Intent(this, InstrucoesActivity.class);
		startActivity(intent);
	}
	private void regras() {
		Intent intent = new Intent(this, InstrucoesActivity.class);
		startActivity(intent);
	}
	private void creditos() {
		Intent i = new Intent(this, CreditosActivity.class);
		startActivity(i);

	}
	private void voltar() {
		Intent i = new Intent(this, CheckpointActivity.class);
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
		else if (id == R.id.action_voltar) {
			voltar();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
