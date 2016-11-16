package com.example.aaishsindwani.careerguide;

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
	private static final String KEY_OPTD= "optd"; //option c
	private static final String BRANCH="branch";
	private static final String engg="ENGG";
	private static final String medi="MEDI";
	private static final String comm="COMM";
	private static final String arts="ARTS";
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
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+BRANCH+" TEXT)";
		db.execSQL(sql);		
		addQuestions();
		//db.close();
	}
	private void addQuestions() {
		Question q1 = new Question("Cricket in colonial India was organised on the " +
				"principle of:", "Religion", "Region", "Religion and Region", "National Loyalties", "3", arts);
		this.addQuestion(q1);
		Question q2 = new Question("A rational number can be expresses as terminating decimal if the denominator has " +
				"factors", "2,3 or 5", "2 or 5", "2 or 3", "3 or 5", "2", engg);
		this.addQuestion(q2);
		Question q3 = new Question("Under law of demand:", "Price of commodity is an independent variable", "" +
				"Quantity demanded is a dependent variable", "Reciprocal relationship is found between price and quantity " +
				"demanded", "All of the above", "4", comm);
		this.addQuestion(q3);
		Question q4 = new Question("Plants synthesis protein from:", "starch", "sugar", "amino acids", "fatty acids", "3", medi);
		this.addQuestion(q4);
		Question q5 = new Question("5. Most fish do not sink in water because of the presence of\n " +
				"I.   swim bladder\n" +
				"II.  air bladder\n" +
				"III. air sacs\n" +
				"IV. air in spongy bones", "I and II are correct", "II and III are correct",
				"III and IV are correct", "I, II, III and IV are correct", "1", medi);
		this.addQuestion(q5);
		Question q6 = new Question("The compound interest on Rs. 7500 at 4% per annum for 2 years compounded annually is",
				"Rs. 610", "Rs. 612", "Rs. 614", "Rs. 616", "2", comm);
		this.addQuestion(q6);
		Question q7 = new Question("Democracy does not ensure:", "equality before the law of the State", "equal" +
				" income to all citizens", "equality of opportunities to all citizens", "equal political rights" +
				" to all citizens", "2", arts);
		this.addQuestion(q7);
		Question q8 = new Question("The tops of two poles of height 10m and 18m are connected with wire, " +
				"If wire makes an angle of 30(degree) with horizontal, the the length of wire is",
				"10m", "12m", "16m", "18m", "3", engg);
		this.addQuestion(q8);
		Question q9 = new Question("\"I am primarily interested in thinking processes; I am a __________ psychologist.\""
				, "cognitive", "learning", "perception", "personality", "1", arts);
		this.addQuestion(q9);
		Question q10 = new Question("James borrows $10,000 from the bank. By the time the loan is repaid, James has paid the " +
				"bank $10,400. What does the additional $400 represent?", "A Inflation rate", "Purchasing power of money"
				, "Interest", "Investment", "3", comm);
		this.addQuestion(q10);
		Question q11 = new Question("Pine, fir, spruce, cedar, larch and cypress are the famous timber-yielding" +
				" plants of which several also occur widely in the hilly regions of India. All these belong to:",
				"Gymnosperms", "Angiosperms", "Monocotyledons", "Dicotyledons", "1", medi);
		this.addQuestion(q11);
		Question q12 = new Question("A farmer connects his electrical water pump in the field to a power" +
				"socket in his home through a 500 m long cable. Which of the following" +
				"statements is/are true ?\n" +
				"I. 'rhe voltage across the pump is exactly equal to the voltage across" +
				"the power socket at his home.\n" +
				"II. The current flowing through the pump is exactly equal to the" +
				"current flowing through the power socket at his home.", "Only 1 is correct"
				, "Only II is correct", "Both I and II are correct", "Neither I nor II is correct ", "2", engg);
		this.addQuestion(q12);
		Question q13 = new Question("Passive factor of production is:", "Only land", "Only capital"
				, "Neither land and capital", "Both land nor capital", "4", comm);
		this.addQuestion(q13);
		Question q14 = new Question("Which of the following is present in spinach but completely absent in" +
				"butter made at home from milk ?",
				"Fats", "Proteins", "Carbohydrates", "Dietary fibre", "4", medi);
		this.addQuestion(q14);
		Question q15 = new Question("Which one of the following tributaries meets·the Ganga river on its right bank?",
				"Yamuna", "Gandak", "Ghaghara", "Kosi", "1", arts);
		this.addQuestion(q15);
		Question q16 = new Question("You feel more comfortable sitting on a cushioned sofa than on a hard" +
				"wooden chair because compared to the chair, the sofa exerts",
				"less force and less pressure on you.",
				"less force but same pressure on you.",
				"greater force but less pressure on you", "the same force but less pressure on you", "4", engg);
		this.addQuestion(q16);
		Question q17 = new Question("For inferior commodities, income effect is:",
				"Negative", "Zero", "Infinite", "Positive", "1", comm);
		this.addQuestion(q17);
		Question q18 = new Question("Haemoglobin is a pigment that is present in the blood and carnes" +
				"oxygen to all the tissues of the body. Anemia is a Condition in which" +
				"the total haemoglobin content of the blood decreases. Which of the" +
				"following will be the result of anemia ?",
				"Increase in heart rate and increase in respiratory rate.",
				"Decrease in heart rate ·and increase in respiratory rate.",
				"Increase in heart rate and decrease in respiratory rate.",
				"Increase in respiratory rate but heart rate unaffected.", "1", medi);
		this.addQuestion(q18);
		Question q19 = new Question("What led to the Civil Disobedience Movement?"
				, "Arrival of the Simon Commission",
				"Working at the firm without payments",
				"Violation of Salt Tax by Gandhi",
				"Fall in demand for agricultural goods", "3", arts);
		this.addQuestion(q19);
		Question q20 = new Question("If the sum of a positive number x and its reciprocal is twice their " +
				"difference, x is:", "3", "1/3", "1/\u221A3", "\u221A3", "4", engg);
		this.addQuestion(q20);
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
		values.put(KEY_OPTD, quest.getOPTD());
		values.put(BRANCH,quest.getSTREAM());
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
				quest.setOPTD(cursor.getString(6));
				quest.setSTREAM(cursor.getString(7));
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
