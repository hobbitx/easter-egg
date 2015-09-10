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

public class RegrasActivity extends Activity {
	private ListView lv_regras;
	private ArrayList<String> listaRegras = new ArrayList<String>(Arrays.asList(
	"É proibido participar do jogo mais de uma vez.",
	"O aplicativo não está livre de erros ou bugs durante o decorrer do jogo.",
	"É proibido manipular o código desse aplicativo para outros fins,"
	+ "senão para a participação no Projeto SENAI Casa Aberta.",
	"A equipe desenvolvedora não é responsável por qualquer dano direto, indireto, acidental,"
	+ " excepcional ou resultante do uso ou inaptidão do desfrute do seu aplicativo."
	+ " Quaisquer dúvidas, informações, suporte ou apoio técnico para o aplicativo estarão"
	+ " disponíveis até às 21 horas (horário de Brasília) do dia 11 de setembro de 2015, "
	+ "no SENAI Euvaldo Lodi, 2º andar, sala 210C. Este aplicativo é distribuído gratuitamente.",
	"A Equipe Desenvolvedora reserva o direito de não impor ônus aos seus usuários, assim como manter seu aplicativo livre de anúncios, mídia e publicidade de terceiros. ",
	"Ao utilizar esse aplicativo o usuário concorda com todos os termos empregados pela Equipe Desenvolvedora."                    
));
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regras);
		lv_regras = (ListView) findViewById(R.id.lv_regras);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaRegras);
		lv_regras.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regras, menu);
		return true;
	}

	private void instrucoes() {
		Intent intent = new Intent(this, InstrucoesActivity.class);
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
		} else if (id == R.id.action_creditos) {
			creditos();
			return true;
		}
		else if (id == R.id.action_voltar) {
			voltar();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
