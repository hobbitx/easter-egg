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
			AppDatabase.COLUMN_DESCRICAO, AppDatabase.COLUMN_VALOR, };
	private String[] colunasD = { AppDatabase.COLUMN_DESCRICAO };
	private String[] colunasV = { AppDatabase.COLUMN_VALOR };

	public ParametrosDao(Context c) {
		dbhelper = new AppDatabase(c);
		database = dbhelper.getDatabase();

	}

	public long salvar(Parametros t) {
		Parametros novoParametro = null;

		ContentValues values = new ContentValues();
		values.put(AppDatabase.COLUMN_DESCRICAO, t.getDescricao().toString());
		values.put(AppDatabase.COLUMN_VALOR, t.getValor().toString());

		long insertId = database.insert(AppDatabase.TABLE_PARAMETROS, null,
				values);

		return insertId;
	}

	public Parametros atualizar(Parametros t) {
		ContentValues values = new ContentValues();
		values.put(AppDatabase.COLUMN_DESCRICAO, t.getDescricao());
		values.put(AppDatabase.COLUMN_VALOR, t.getValor());

		long insertId = database.update(AppDatabase.TABLE_PARAMETROS, values,
				AppDatabase.COLUMN_DESCRICAO + " = ?",
				new String[] { String.valueOf(t.getDescricao()) });

		Parametros novaTarefa = buscarID(insertId);
		return novaTarefa;

	}

	public void deletar(Parametros t) {

	}

	public ArrayList<Parametros> buscar() {
		ArrayList<Parametros> feitos = new ArrayList<Parametros>();
		Parametros t = new Parametros();
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunasD,
				null, null, null, null, null);
		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				t = cursorToParametros(cursor);
				feitos.add(t);
				cursor.moveToNext();
			}
		}
		cursor.close();
		return feitos;
	}

	public ArrayList<Parametros> buscarFeitos() {
		ArrayList<Parametros> feitos = new ArrayList<Parametros>();
		Parametros t = new Parametros();
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunasD,
				AppDatabase.COLUMN_VALOR + " = ?", new String[] { "1" }, null,
				null, null);
		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				t = cursorToParametros(cursor);
				feitos.add(t);
				cursor.moveToNext();
			}
		}
		cursor.close();
		return feitos;
	}

	public ArrayList<Parametros> buscarDica() {
		ArrayList<Parametros> feitos = new ArrayList<Parametros>();
		Parametros t = new Parametros();
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunasV,
				AppDatabase.COLUMN_DESCRICAO + " = ?", new String[] { "dica" }, null,
				null, null);
		if (cursor.moveToFirst()) {

			t = cursorToParametros(cursor);
			feitos.add(t);

		}
		cursor.close();

		return feitos;
	}
	public String buscarValores(String n) {
		ArrayList<Parametros> feitos = new ArrayList<Parametros>();
		Parametros t = new Parametros();
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunasV,
				AppDatabase.COLUMN_DESCRICAO + " = ?", new String[] {n}, null,
				null, null);
		if (cursor.moveToFirst()) {

			t = cursorToParametros(cursor);
			feitos.add(t);

		}
		cursor.close();

		return feitos.get(0).toString();
	}

	@SuppressLint("UseValueOf")
	private Parametros cursorToParametros(Cursor cursor) {
		Parametros t = new Parametros(null, cursor.getString(0), null);
		return t;
	}

	public Parametros buscarID(long id) {
		Parametros t = null;
		Cursor cursor = database.query(AppDatabase.TABLE_PARAMETROS, colunas,
				AppDatabase.COLUMN_ID + " = ?",
				new String[] { String.valueOf(id) }, null, null, null);
		if (cursor.moveToFirst()) {
			t = cursorToParametros(cursor);

		}
		cursor.close();
		return t;
	}

}
