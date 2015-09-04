package com.senai.easteregg;


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
	private TextView tv_instrucao;
	private String resultado ="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkpoint);
		
		tv_instrucao = (TextView)findViewById(R.id.tv_instrucao);
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
				verificarCheckpoint();
		}
			else {
				Toast.makeText(this, "QR Code invalido", Toast.LENGTH_LONG).show();
			}
			}
	}
	
	private void verificarCheckpoint() {
		

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
