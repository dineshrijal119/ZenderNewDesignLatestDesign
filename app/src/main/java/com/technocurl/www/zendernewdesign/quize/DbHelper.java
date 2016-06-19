package com.technocurl.www.zendernewdesign.quize;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "triviaQuiz";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		db.execSQL(sql);		
		addQuestions();
		//db.close();
	}
	private void addQuestions()
	{
		Question q1=new Question("1. Have you had trouble deciding on baby names?","We agree on girl names, but not on boy names.", "We agree on boy names, but not on girl names.", "We've had no trouble agreeing on names.", "We've had no trouble agreeing on names");
		this.addQuestion(q1);
		Question q2=new Question("2. What types of food have you been craving?", "Candy, cookies and everything sweet.", "Lemons, pickles, yogurt and other sour foods.", " I haven't had many food cravings.", " I haven't had many food cravings.");
		this.addQuestion(q2);
		Question q3=new Question("3. Is the daddy gaining weight along with you?","Yes", "No","He'll never tell!", "He'll never tell!" );
		this.addQuestion(q3);
		Question q4=new Question("4. Do you find yourself craving more protein than before?", " No. Bread, fruit and snack foods, but rarely protein.", "Yes. Meat and cheese are my new favorite treats.", "No more or less than before.","No more or less than before.");
		this.addQuestion(q4);
		Question q5=new Question("5. How has your hair changed since getting pregnant?"," It's become thin and dull.","More shiny and full-bodied.","It's about the same.","It's about the same.");
		this.addQuestion(q5);
		Question q6=new Question("6. What about your nails?"," They're growing slower or feel thin and brittle.","Growing faster and stronger.","I haven't noticed a change.","I haven't noticed a change.");
		this.addQuestion(q6);
		Question q7=new Question("7. Are your feet colder now that you're pregnant?","No, my feet don't get cold.","Yes, they're like little icicles.","About the same as before.","About the same as before.");
		this.addQuestion(q7);
		Question q8=new Question("8. Are you generally happier or more moody?"," I cry more, I laugh more. Definitely moody.","No, if anything I feel more positive.","I don't know.","I don't know.");
		this.addQuestion(q8);
		Question q9=new Question("9. Have you been dreaming about your baby?"," In my dreams, my baby is a girl.","In my dreams, my baby is a boy."," I haven't had any dreams about my baby."," I haven't had any dreams about my baby.");
		this.addQuestion(q9);
		Question q10=new Question("10. Has pregnancy made you clumsy or graceful?"," I feel more graceful.","I feel more clumsy."," I'm not sure."," I'm not sure.");
		this.addQuestion(q10);
		Question q11=new Question("11.  Which side do you prefer to lay down on?"," I lay on my right side.","I lay on my left side."," I don't have a preference."," I don't have a preference.");
		this.addQuestion(q11);
		Question q12=new Question("12. Have you had serious morning sickness?","My morning sickness lasts all day!","What morning sickness? I feel great."," It's been about as expected."," It's been about as expected.");
		this.addQuestion(q12);
		Question q13=new Question("13. How fast is your baby's heartbeat?","140 bpm and above.","Less than 140 bpm."," I'm not sure."," I'm not sure.");
		this.addQuestion(q13);
		Question q14=new Question("14. What do you think you're having?","A girl.","A boy.","A baby.","A baby.");
		this.addQuestion(q14);


	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION()); 
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
}
