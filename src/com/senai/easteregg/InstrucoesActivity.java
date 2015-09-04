package com.senai.easteregg;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InstrucoesActivity extends Activity {
	private ArrayList<String> instrucoes = new ArrayList<String>();
	private Instrucoes ins;
	private String texto;
	private int a=0;
	private TextView tv_instrucao;
	private ImageView iv_01,iv_02,iv_03,iv_04,iv_05;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instrucoes);
		
		tv_instrucao = (TextView)findViewById(R.id.tv_instrucao);
		iv_01 = (ImageView) findViewById(R.id.iv_01);
		iv_02 = (ImageView) findViewById(R.id.iv_02);
		iv_03 = (ImageView) findViewById(R.id.iv_03);
		iv_04 = (ImageView) findViewById(R.id.iv_04);
		iv_05 = (ImageView) findViewById(R.id.iv_05);
		ins =  new Instrucoes();
		instrucoes = ins.instrucoes;
		texto = instrucoes.get(a)+ instrucoes.get(a+1);
		a = 1;
		tv_instrucao.setText(texto);
		
	}

	public void next(View v) {
		if(a==5){
			//chamar outra tela
		}
		else{
		texto = instrucoes.get(a+1);
		tv_instrucao.setText(texto);
		a++;
		mudarImagens(a);
		}
	}
	
	
	private void mudarImagens(int i) {
		if(i==2){
			iv_01.setImageResource(R.drawable.branco);
			iv_02.setImageResource(R.drawable.negra);
			
		}
		else if(i==3){
			iv_02.setImageResource(R.drawable.branco);
			iv_03.setImageResource(R.drawable.negra);
		}
		else if(i==4){
			iv_03.setImageResource(R.drawable.branco);
			iv_04.setImageResource(R.drawable.negra);
		}
		else if(i==5){
			iv_04.setImageResource(R.drawable.branco);
			iv_05.setImageResource(R.drawable.negra);
}
		else{
			
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.instrucoes, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
