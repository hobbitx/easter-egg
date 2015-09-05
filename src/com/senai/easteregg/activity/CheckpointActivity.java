package com.senai.easteregg.activity;

import java.util.ArrayList;
import java.util.Random;

import com.senai.easteregg.R;
import com.senai.easteregg.dao.ParametrosDao;
import com.senai.easteregg.modelo.Instrucoes;
import com.senai.easteregg.modelo.Parametros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckpointActivity extends Activity {
	public static final int REQUEST_CODE = 0;
	private ImageView iv01, iv02, iv03, iv04, iv05, iv06, iv07;
	private TextView tv_dica;
	private String resultado = "", dica = "", vericacao = "";
	private Instrucoes ins;
	private int conta = 0;
	private ArrayList<String> instrucoes = new ArrayList<String>();
	private ArrayList<String> dicas = new ArrayList<String>();
	private ArrayList<String> controle = new ArrayList<String>();
	private ArrayList<Parametros> Feitos = new ArrayList<Parametros>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkpoint);
		ins = new Instrucoes();
		instrucoes = ins.instrucoes;
		dicas = ins.dicas;
		controle = ins.controle;

		iv01 = (ImageView) findViewById(R.id.iv_01);
		iv02 = (ImageView) findViewById(R.id.iv_02);
		iv03 = (ImageView) findViewById(R.id.iv_03);
		iv04 = (ImageView) findViewById(R.id.iv_04);
		iv05 = (ImageView) findViewById(R.id.iv_05);
		iv06 = (ImageView) findViewById(R.id.iv_06);
		iv07 = (ImageView) findViewById(R.id.iv_07);
		tv_dica = (TextView) findViewById(R.id.tv_dica);
	}

	public void leitura(View view) {
		/*
		 * Metodo para pegar o click do botao e chamar a intent do zxing
		 * 
		 * modificação no
		 * com.google.zxing.client.android.Camera.CameraConfigurationManager
		 * linha 78 - Adicionado camera.setDisplayOrientation(90); para alinhar
		 * a camera na vertical
		 */
		Intent it = new Intent(CheckpointActivity.this,
				com.google.zxing.client.android.CaptureActivity.class);
		startActivityForResult(it, REQUEST_CODE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		/*
		 * Método de retorno do zxing , após o scanner do qrcode ele retorna
		 * para este metodo
		 * 
		 * para isto fazemos modificação no
		 * com.google.zxing.client.android.CaptureActivity adicionamos as linhas
		 * 404 á 407
		 */
		if (REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
			if (data.getStringExtra("SCAN_FORMAT").equals("QR_CODE")) {
				resultado = data.getStringExtra("SCAN_RESULT");
				verificarCheckpoint();

			} else {
				Toast.makeText(this, "QR Code invalido", Toast.LENGTH_LONG)
						.show();
			}
		}
	}

	private void verificarCheckpoint() {
		ParametrosDao dao = new ParametrosDao(this);
		Parametros pq = new Parametros();
		Toast.makeText(this, "Contagem = " + conta, Toast.LENGTH_LONG).show();
		if (conta == 5) {
			String dicaFim = "Toda história tem um fim, mas na vida todo final é um novo começo. Que tal começar?";
			tv_dica.setText(dicaFim);
		} else if (resultado.equals("inicio")) {
			pq.setDescricao("" + resultado);
			pq.setValor("1");
			gerarDica();
			tv_dica.setText(dica);
			dao.salvar(pq);

		} else if (resultado.equals(vericacao)) {// banheiro}
			String a = "";
			pq.setDescricao(resultado);
			pq.setValor("1");
			gerarDica();
			buscar();
			for (int i = 0; i < Feitos.size(); i++) {

				a = Feitos.get(i).toString();
				Toast.makeText(this, "A = " + a, Toast.LENGTH_SHORT).show();
				if (!vericacao.equals(a)) {
					tv_dica.setText(dica);
					dao.salvar(pq);

				} else {
					Toast.makeText(this, "Igual: " + a, Toast.LENGTH_SHORT)
							.show();
				}

			}
		} else {
			Toast.makeText(this, "Checkpoint invalido", Toast.LENGTH_LONG)
					.show();
		}
		mudarImagens(conta);
	}

	private void buscar() {
		ParametrosDao dao = new ParametrosDao(this);
		Feitos = dao.buscar();

	}

	private void gerarDica() {
		int r = new Random().nextInt(dicas.size());
		dica = dicas.get(r);
		vericacao = controle.get(r);
		dicas.remove(r);
		controle.remove(r);
		Toast.makeText(this, "dica = " + r, Toast.LENGTH_LONG).show();
		Toast.makeText(this, "Verificacao: " + vericacao, Toast.LENGTH_SHORT)
				.show();
		conta++;
	}

	private void mudarImagens(int i) {
		if (i == 1) {
			iv01.setImageResource(R.drawable.marcador_branco);
			iv02.setImageResource(R.drawable.marcador_azul);

		} else if (i == 2) {
			iv02.setImageResource(R.drawable.marcador_branco);
			iv03.setImageResource(R.drawable.marcador_azul);

		} else if (i == 3) {
			iv03.setImageResource(R.drawable.marcador_branco);
			iv04.setImageResource(R.drawable.marcador_azul);

		} else if (i == 4) {
			iv04.setImageResource(R.drawable.marcador_branco);
			iv05.setImageResource(R.drawable.marcador_azul);
		} else if (i == 5) {
			iv05.setImageResource(R.drawable.marcador_branco);
			iv06.setImageResource(R.drawable.marcador_azul);
		} else if (i == 6) {
			iv06.setImageResource(R.drawable.marcador_branco);
			iv07.setImageResource(R.drawable.marcador_azul);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checkpoint, menu);
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
