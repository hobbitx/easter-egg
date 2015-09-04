package com.senai.easteregg;


import java.util.ArrayList;
import java.util.Random;

import com.senai.easteregg.dao.ParametrosDao;
import com.senai.easteregg.modelo.Parametros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CheckpointActivity extends Activity {
	public static final int REQUEST_CODE = 0;
	private TextView tv_dica;
	private String resultado ="",dica ="",vericacao = "";
	private Instrucoes ins;
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
		tv_dica = (TextView)findViewById(R.id.tv_dica);
	}

	public void leitura(View view){
		/*Metodo para pegar o click do botao e chamar a intent do zxing
		 * 
		 * modificação no com.google.zxing.client.android.Camera.CameraConfigurationManager
		 * linha 78 - Adicionado  camera.setDisplayOrientation(90);
		 * para alinhar a camera na vertical
		 */
		Intent it = new Intent(CheckpointActivity.this, com.google.zxing.client.android.CaptureActivity.class);
		startActivityForResult(it, REQUEST_CODE);
	}
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		/*
		 * Método de retorno do zxing ,
		 * após o scanner do qrcode ele retorna para este metodo
		 * 
		 * para isto fazemos modificação no com.google.zxing.client.android.CaptureActivity
		 * adicionamos as linhas 404 á 407
		 * 
		 * */
		if(REQUEST_CODE == requestCode && RESULT_OK == resultCode){
			if(data.getStringExtra("SCAN_FORMAT").equals("QR_CODE")){
				resultado = data.getStringExtra("SCAN_RESULT");
				verificarCheckpoint();
		}
			else {
				Toast.makeText(this, "QR Code invalido", Toast.LENGTH_LONG).show();
			}
			}
	}
	
	
	private void verificarCheckpoint() {
		ParametrosDao dao = new ParametrosDao(this);
		Parametros pq = null;
		
		if(resultado.equals("inicio")){
			pq.setDescricao(resultado);
			pq.setValor("1");
			gerarDica();
			tv_dica.setText(dica);
			dao.salvar(pq);
		}
		else if(resultado.equals(vericacao)){//banheiro}
			String a="";
			pq.setDescricao(resultado);
			pq.setValor("1");
			gerarDica();
			for (int i = 0; i <Feitos.size(); i++) {
				
			a = Feitos.get(i).toString();
			
			if(!vericacao.equals(a)){
				tv_dica.setText(dica);
				dao.salvar(pq);
			}
			else{
				
			}
			}
			
		}
		else{
			Toast.makeText(this, "Checkpoint invalido", Toast.LENGTH_LONG).show();
		}
	}
	
	private void buscarFeitos() {
		ParametrosDao dao = new ParametrosDao(this);
		Parametros p = null;
		String ver;
		Feitos = dao.buscarFeitos("1");
		
		}
	
	private void gerarDica() {
		int r = new Random().nextInt(dicas.size());
		dica = dicas.get(r);
		vericacao = controle.get(r);

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
