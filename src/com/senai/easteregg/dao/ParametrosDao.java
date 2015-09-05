package com.senai.easteregg.dao;

import java.util.ArrayList;

import com.senai.easteregg.modelo.Parametros;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class ParametrosDao {

	private SQLiteDatabase database;
	private AppDatabase dbhelper;
	private String[] colunas = { AppDatabase.COLUMN_ID,
			AppDatabase.COLUMN_DESCRICAO, AppDatabase.COLUMN_VALOR,
			};
	private String[] colunasD = {AppDatabase.COLUMN_DESCRICAO};

	public ParametrosDao(Context c) {
		dbhelper = new AppDatabase(c);
		database = dbhelper.getDatabase();

	}

	public long salvar(Parametros t) {
		Parametros novoParametro = null;

		ContentValues values = new ContentValues();
		values.put(AppDatabase.COLUMN_DESCRICAO, t.getDescricao().toString());
		values.put(AppDatabase.COLUMN_VALOR, t.getValor().toString());

		long insertId = database
				.insert(AppDatabase.TABLE_PARAMETROS, null, values);

		return insertId;
	}
	
	public Parametros atualizar(Parametros t) {
		ContentValues values = new ContentValues();
		values.put(AppDatabase.COLUMN_DESCRICAO, t.getDescricao());
		values.put(AppDatabase.COLUMN_VALOR, t.getValor());
		

		long insertId = database.update(AppDatabase.TABLE_PARAMETROS, values, AppDatabase.COLUMN_ID + " = ?", 
				new String[] {String.valueOf(t.getId())});
		
		Parametros novaTarefa = buscarID(insertId);
		return novaTarefa;
		
		
	}

	public void deletar(Parametros t) {

	}

	public Parametros buscar(String descricao) {
		Parametros t = null;
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunas,AppDatabase.COLUMN_DESCRICAO + " = ?",
				new String[] {String.valueOf(descricao)},null,null,null);
		if(cursor.moveToFirst()){
			t = cursoToTarefa(cursor);
			
		}
		cursor.close();
		return t;
	}
	public ArrayList<Parametros> buscarFeitos() {
		ArrayList<Parametros> feitos = new ArrayList<Parametros>();
		Parametros t = new Parametros();
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunasD,AppDatabase.COLUMN_VALOR + " = ?",
				new String[] {"1"},null,null,null);
		if(cursor.moveToFirst()){
			while (!cursor.isAfterLast()) {
				t = cursorToParametros(cursor);
				feitos.add(t);
				cursor.moveToNext();
			}
		}
		cursor.close();
		return feitos;
	}
	private Parametros cursorToParametros(Cursor cursor) {
		Parametros t = new Parametros(
				cursor.getInt(0),
				cursor.getString(1),
				cursor.getString(2)
				);
		return t;
	}

	public Parametros buscarID(long id) {
		Parametros t = null;
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunas,AppDatabase.COLUMN_ID + " = ?",
				new String[] {String.valueOf(id)},null,null,null);
		if(cursor.moveToFirst()){
			t = cursoToTarefa(cursor);
			
		}
		cursor.close();
		return t;
	}

	@SuppressLint("UseValueOf")
	private Parametros cursoToTarefa(Cursor cursor) {
		
	
		
		Parametros t = new Parametros(
				cursor.getInt(0),
				cursor.getString(1),
				cursor.getString(2)		
				);
		
		return t;
	}
}
