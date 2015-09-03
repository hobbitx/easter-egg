package com.senai.easteregg.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDatabase {

	private final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "parametros.db";

	public static final String TABLE_PARAMETROS = "parametros";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_DESCRICAO = "descricao";
	public static final String COLUMN_VALOR = "valor";

	private static final String TABLE_PARAMETROS_CREATE = "create table "
			+ TABLE_PARAMETROS + " (" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_DESCRICAO
			+ " text not null, " + COLUMN_VALOR + " text not null);";

	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;

	public AppDatabase(Context context) {
		this.dbHelper = new DatabaseHelper(context);
		this.database = dbHelper.getWritableDatabase();
	}

	public SQLiteDatabase getDatabase() {
		return database;
	}

	public void closeConnection() {
		dbHelper.close();
	}

	class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(TABLE_PARAMETROS_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("APP DATABASE", "Atualizando banco de dados da versão "
					+ oldVersion + " para a versão " + newVersion
					+ ". Todos os dados serão perdidos");
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARAMETROS);
			onCreate(db);
		}
	}
}
