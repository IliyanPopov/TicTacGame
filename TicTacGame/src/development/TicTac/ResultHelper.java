package development.TicTac;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class ResultHelper extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "TicTacGame.db";
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";

	// private static final String SQL_CREATE_ENTRIES = "CREATE TABLE ";

	// private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
	public ResultHelper(Context context)
	{
		super(context,DATABASE_NAME, null, DATABASE_VERSION);
	}	// + ResultTable.TABLE_NAME;

	public ResultHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ResultTable.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// This database is only a cache for online data, so its upgrade policy
		// is
		// to simply to discard the data and start over
		db.execSQL(ResultTable.CREATE_TABLE);
		onCreate(db);
	}

	public void addScore(TicTacToeScore ticTacToeScore) {

		SQLiteDatabase db = null;
		try {
			db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			// values.put(City_CountryContract.CountryEntry.COUNTRY,
			// country.get_country()); // Country Name
			values.put(ResultTable.Result, ticTacToeScore.getScore());
			values.put(ResultTable.Result, ticTacToeScore.getTime());
			// Inserting Row
			// db.insert(City_CountryContract.CountryEntry.TABLE_NAME, null,
			// values);
			db.insert(ResultTable.TABLE_NAME, null, values);

		} catch (SQLiteException e) {
			e.printStackTrace();
		} finally {
			if (db != null && db.isOpen())
				db.close(); // Closing database connection
		}

	}
	
	public void readScore(TicTacToeScore ticTacToeScore){
		
		
	}

	public static class ResultTable implements BaseColumns {
		ResultTable() {

		}

		public static final String TABLE_NAME = "TicTacTable";
		public static final String Result = "Result";
		public static final String Time = "Time";

		public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
				+ " (" + _ID + " INTEGER PRIMARY KEY," + Result + TEXT_TYPE
				+ COMMA_SEP + Time + " INTEGER " + " )";

		public static final String DELETE_TABLE = "DROP TABLE IF EXISTS "
				+ ResultTable.TABLE_NAME;
		public static final String SCORE_QUERY = "SELECT  * FROM " + TABLE_NAME + " WHERE " + Result + "=?";

	}

}
