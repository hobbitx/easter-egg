package com.senai.easteregg.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.senai.easteregg.R;
import com.senai.easteregg.modelo.Instrucoes;

public class InstrucoesActivity extends Activity {
	private ArrayList<String> textoInstrucoes = new ArrayList<String>();
	private ArrayList<String> tituloInstrucoes = new ArrayList<String>();
	private Instrucoes instrucoes;
	private Integer posicao = 0;
	private TextView tvInstrucao, tvTituloIstrucao, tvProximo;
	private ImageView iv01, iv02, iv03, iv04, iv05, ivBanner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instrucoes);

		tvInstrucao = (TextView) findViewById(R.id.tv_instrucao);
		tvTituloIstrucao = (TextView) findViewById(R.id.tv_titulo);
		tvProximo = (TextView) findViewById(R.id.tv_proximo);

		iv01 = (ImageView) findViewById(R.id.iv_01);
		iv02 = (ImageView) findViewById(R.id.iv_02);
		iv03 = (ImageView) findViewById(R.id.iv_03);
		iv04 = (ImageView) findViewById(R.id.iv_04);
		iv05 = (ImageView) findViewById(R.id.iv_05);
		
		ivBanner = (ImageView) findViewById(R.id.iv_banner);

		instrucoes = new Instrucoes();
		textoInstrucoes = instrucoes.instrucoes;
		tvInstrucao.setText(textoInstrucoes.get(posicao));
		
		tituloInstrucoes = instrucoes.tituloInstrucoes;
		tvTituloIstrucao.setText(tituloInstrucoes.get(posicao));
	}

	public void next(View v) {
		next();
	}
	
	public void next() {
		if (posicao >= 4) {
			Intent i = new Intent(this, ContagemRegressivaActivity.class);
			startActivity(i);
		} else {
			posicao++;
			tvInstrucao.setText(textoInstrucoes.get(posicao));
			tvTituloIstrucao.setText(tituloInstrucoes.get(posicao));
			mudarImagens(posicao);
		}
	}

	private void mudarImagens(int i) {
		if (i == 1) {
			iv01.setImageResource(R.drawable.marcador_branco);
			iv02.setImageResource(R.drawable.marcador_azul);
			ivBanner.setImageResource(R.drawable.qrcode);
		} else if (i == 2) {
			iv02.setImageResource(R.drawable.marcador_branco);
			iv03.setImageResource(R.drawable.marcador_azul);
			ivBanner.setImageResource(R.drawable.savethedate);
		} else if (i == 3) {
			iv03.setImageResource(R.drawable.marcador_branco);
			iv04.setImageResource(R.drawable.marcador_azul);
			ivBanner.setImageResource(R.drawable.tesouro);
		} else if (i == 4) {
			iv04.setImageResource(R.drawable.marcador_branco);
			iv05.setImageResource(R.drawable.marcador_azul);
			ivBanner.setImageResource(R.drawable.end);
			tvProximo.setText("JOGAR");
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.instrucoes, menu);
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
		 if (id == R.id.action_creditos) {
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


	
