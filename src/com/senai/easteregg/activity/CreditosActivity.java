package com.senai.easteregg.activity;

import java.util.ArrayList;
import java.util.Arrays;

import com.senai.easteregg.R;
import com.senai.easteregg.R.id;
import com.senai.easteregg.R.layout;
import com.senai.easteregg.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CreditosActivity extends Activity {
	private ListView lv_lista,lv_list;
	private ArrayList<String> listaCreditos = new ArrayList<String>(Arrays.asList(
			"Alex Oliveira",
			"Fabio Alves",
			"Fabricio Diniz",
			"Isabelle Patrocinio",
			"Marcos Assis",
			"Robert Cristiam"
			));
	private  ArrayList<String> listaCreditos2 = new ArrayList<String>(Arrays.asList(
			"Bruno Eustaquio",
			"Fabio Nelson",
			"Glaycon Gomes",
			"Juan Luiz",
			"Marcello Fadul"
			));
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_creditos);
		lv_list = (ListView) findViewById(R.id.lv_list);
		lv_lista = (ListView) findViewById(R.id.lv_lista);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCreditos);
		lv_list.setAdapter(adapter);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCreditos2);
		lv_lista.setAdapter(adapter2);
		
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
		Intent intent = new Intent(this, RegrasActivity.class);
		startActivity(intent);
	}
	private void creditos() {
		Intent i = new Intent(this, CreditosActivity.class);
		startActivity(i);

	}
	private void voltar() {
		Intent i = new Intent(this, ContagemRegressivaActivity.class);
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
			regras();
			return true;
		}
		else if (id == R.id.action_voltar) {
			voltar();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
