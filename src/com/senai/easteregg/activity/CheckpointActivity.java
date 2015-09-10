package com.senai.easteregg.activity;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.senai.easteregg.R;
import com.senai.easteregg.dao.ParametrosDao;
import com.senai.easteregg.modelo.Instrucoes;
import com.senai.easteregg.modelo.Parametros;

public class CheckpointActivity extends Activity {
	public static final int REQUEST_CODE = 0;
	private ImageView iv01, iv02, iv03, iv04, iv05, iv06, iv07;
	private TextView tv_dica,tv_senai,tv_titulo,tv_tdica;
	private String resultado = "", dica = "", vericacao = "",propaganda="";
	private Instrucoes ins;
	private int conta = 0, aux = 0;
	private ArrayList<String> instrucoes = new ArrayList<String>();
	private ArrayList<String> dicas = new ArrayList<String>();
	private ArrayList<String> controle = new ArrayList<String>();
	private ArrayList<String> propagandas = new ArrayList<String>();
	private ArrayList<Parametros> Feitos = new ArrayList<Parametros>();
	private ArrayList<Parametros> progresso = new ArrayList<Parametros>();
	private Button bt_capturar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkpoint);
		
	IniciarJogo();
	recuperarDica();
	}
	
	private void IniciarJogo() {
		ParametrosDao dao = new ParametrosDao(this);
		Parametros t = new Parametros();
		
		ins = new Instrucoes();
		instrucoes = ins.instrucoes;
		dicas = ins.dicas;
		controle = ins.controle;
		propagandas = ins.propaganda;
		iv01 = (ImageView) findViewById(R.id.iv_01);
		iv02 = (ImageView) findViewById(R.id.iv_02);
		iv03 = (ImageView) findViewById(R.id.iv_03);
		iv04 = (ImageView) findViewById(R.id.iv_04);
		iv05 = (ImageView) findViewById(R.id.iv_05);
		iv06 = (ImageView) findViewById(R.id.iv_06);
		iv07 = (ImageView) findViewById(R.id.iv_07);
		tv_dica = (TextView) findViewById(R.id.tv_dica);
		tv_senai = (TextView) findViewById(R.id.tv_senai);
		tv_titulo = (TextView) findViewById(R.id.tv_titulo);
		tv_tdica = (TextView) findViewById(R.id.tv_tdica);
		bt_capturar = (Button) findViewById(R.id.bt_capturar);
		
		
	
	}
	private void recuperarDica() {
		ParametrosDao dao = new ParametrosDao(this);
		Parametros t = new Parametros();
		try{
			progresso = dao.buscarDica();
			dica = progresso.get(0).toString();
			conta = Integer.parseInt(dao.buscarValores("contagem"));
			vericacao = dao.buscarValores("verificacao");
			propaganda = dao.buscarValores("propaganda");
			
			tv_dica.setText(dica);
			tv_senai.setText(propaganda);
			tv_titulo.setText("Voc� sabia?");
			mudarImagens(conta);
		}
		catch(NullPointerException e){
			
		}
		catch (IndexOutOfBoundsException e) {
			
			}

	}

	public void leitura(View view) {
		/*
		 * Metodo para pegar o click do botao e chamar a intent do zxing
		 * 
		 * modifica��o no
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
		 * M�todo de retorno do zxing , ap�s o scanner do qrcode ele retorna
		 * para este metodo
		 * 
		 * para isto fazemos modifica��o no
		 * com.google.zxing.client.android.CaptureActivity adicionamos as linhas
		 * 404 � 407
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
		tv_titulo.setText("Voc� Sabia?");
		tv_tdica.setText("Dica: ");
		ParametrosDao dao = new ParametrosDao(this);
		Parametros pq = new Parametros();
		//Toast.makeText(this, "Contagem = " + conta, Toast.LENGTH_LONG).show();
		if (conta == 5 && resultado.equals(vericacao)) {
			String propagandaFim = "O curso T�cnico em Inform�tica tem como objetivo formar profissionais com "
					+ "habilita��o T�cnica de N�vel M�dio em Inform�tica, "
					+ "voltado para a �rea de programa��o de computadores.";
			String dicaFim = "Toda hist�ria tem um fim, mas na vida todo final � um novo come�o. Que tal come�ar?";
			tv_dica.setText(dicaFim);
			tv_senai.setText(propagandaFim);
			mudarImagens(conta);
			conta++;
		} else if (resultado.equals("inicio") && conta == 0) {
			pq.setDescricao("" + resultado);
			pq.setValor("1");
			gerarDica();
			tv_dica.setText(dica);
			tv_senai.setText(propaganda);
			dao.salvar(pq);

		} else if (resultado.equals("inicio") && conta == 6) {
			tv_titulo.setText("Uhulll!!!");
			tv_senai.setText(" Voc� Completou todo o trajeto do jogo... ");
			tv_dica.setText("Seja Bem Vindo ao Seleto Grupo dos conquistadores de tesouros...");
			bt_capturar.setEnabled(false);
		}
		
		else if (resultado.equals(vericacao)) {// banheiro}
			String a = "";
			pq.setDescricao(resultado);
			pq.setValor("1");
			gerarDica();
			buscar();
			for (int i = 0; i < Feitos.size(); i++) {

				a = Feitos.get(i).toString();
				//Toast.makeText(this, "A = " + a, Toast.LENGTH_SHORT).show();
				if (!vericacao.equals(a)) {
					tv_dica.setText(dica);
					tv_senai.setText(propaganda);
					dao.salvar(pq);

				} else {
					//Toast.makeText(this, "Igual: " + a, Toast.LENGTH_SHORT)
						//	.show();
				}

			}
		} else {
			alerta();
		}
		pq.setDescricao("Local");
		pq.setValor(""+conta);
		dao.salvar(pq);
		mudarImagens(conta);
	}

	private void buscar() {
		ParametrosDao dao = new ParametrosDao(this);
		Feitos = dao.buscar();

	}

	private void gerarDica() {		
		int r = new Random().nextInt(dicas.size());
		if(aux == 0){
		
			dica = dicas.get(r);
			vericacao = controle.get(r);
			propaganda = propagandas.get(r);
			dicas.remove(r);
			propagandas.remove(r);
			controle.remove(r);
			conta++;	
			aux = 1;
			salvarDica();
			}
	else{
		dica = dicas.get(r);
		vericacao = controle.get(r);
		propaganda = propagandas.get(r);
		dicas.remove(r);
		propagandas.remove(r);
		controle.remove(r);
		conta++;
		atualizardica();
		
	}
	}
private void atualizardica() {
	ParametrosDao dao = new ParametrosDao(this);
	Parametros t = new Parametros();
	t.setDescricao("dica");
	t.setValor(""+dica);
	dao.atualizar(t);
	t.setDescricao("contagem");
	t.setValor(""+conta);
	dao.atualizar(t);
	t.setDescricao("propaganda");
	t.setValor(""+propaganda);
	dao.atualizar(t);
	t.setDescricao("verificacao");
	t.setValor(""+vericacao);
	dao.atualizar(t);
}
private void salvarDica() {
	ParametrosDao dao = new ParametrosDao(this);
	Parametros t = new Parametros();
	t.setDescricao("dica");
	t.setValor(""+dica);
	dao.salvar(t);
	t.setDescricao("contagem");
	t.setValor(""+conta);
	dao.salvar(t);
	t.setDescricao("propaganda");
	t.setValor(""+propaganda);
	dao.salvar(t);
	t.setDescricao("verificacao");
	t.setValor(""+vericacao);
	dao.salvar(t);

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
	private void alerta() {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		dialogBuilder
				.setTitle("Voc� esta no lugar errado!!")
				.setMessage("Verifique sua dica novamente e se dirija ao destino correto da charada")
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface arg0, int arg1) {
								
							}
						})
					.create().show();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checkpoint, menu);
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
			regras();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
