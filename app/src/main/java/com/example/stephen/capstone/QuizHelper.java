package com.example.stephen.capstone;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "FifthGradeMath";
    // tasks table name
    private static final String TABLE_QUEST = "question";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c

    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestion();
        // db.close();
    }

    private void addQuestion() {
        Question q1 = new Question("A grocery store scale is used to weigh a bag of vegetables. The scale shows 13.456 oz. " +
                "What is this value rounded to the nearest tenth of an ounce?", "13.4 oz", "13.5 oz", "13.45 oz", "13.5 oz");
        this.addQuestion(q1);
        Question q2 = new Question("What is the standard form of nine and fifteen hundredths?", "0.915", "9.15", "9.015", "9.15");
        this.addQuestion(q2);
        Question q3 = new Question("Lonnie measured the volume of a large box. Which of the " +
                "following results could have been the volume of the box?", "2.5 yards", "2.5 cubic yards", "2.5 square yards", "2.5 cubic yards");
        this.addQuestion(q3);
        Question q4 = new Question("Which of the following comparison statements is true?" +
                " 90 x 5 + 16", "3.909 = 3.990", "3.099 > 3.99", "3.990 = 3.99", "3.990 = 3.99");
        this.addQuestion(q4);
        Question q5 = new Question("Find the product.\n" +
                "6.8 x 0.5", "0.034", "0.34", "3.4", "3.4");
        this.addQuestion(q5);
        Question q6 = new Question("Match up corresponding elements in each pattern below to form ordered pairs. If (0, 0) is the first ordered pair in the list, what would the seventh ordered pair be?\n" +
                "Rule \"Add 3\": 0, 3, 6, . . .\n" +
                "Rule \"Add 8\": 0, 8, 16, . . .", "(21, 56)", "(18, 48)", "(21, 54)", "(18, 48)");
        this.addQuestion(q6);
        Question q7 = new Question("Which of the following expressions has a value that would be triple the value of the expression shown here?\n" +
                "(88 + 17) ÷ 6 + 9", "(88 + 17) ÷ 6 + 9 x 3", "3 x (88 + 17) ÷ 6 + 9", "3 x [(88 + 17) ÷ 6 + 9]", "3 x [(88 + 17) ÷ 6 + 9]");
        this.addQuestion(q7);
        Question q8 = new Question("There are three books in Frank's backpack. The math book weighs 1 pound, 8 ounces. The reading book weighs 1 pound, 4 ounces. The science book weighs 1 pound, 2 ounces. " +
                "What is the combined weight of the three books, in ounces?", "44 ounces", "62 ounces", "50 ounces", "62 ounces");
        this.addQuestion(q8);
        Question q9 = new Question("The number 195.763 is multiplied by 100. " +
                "Where would the decimal point be found in the product?", "between the 1 and the 9", "between the 9 and the 5", "between the 6 and the 3", "between the 6 and the 3");
        this.addQuestion(q9);
        Question q10 = new Question("Evaluate this expression when h=5:\n" +
                "{102-[h x (2 + 7) + 3 x (21 - h)]}÷3", "3", "9", "15", "3");
        this.addQuestion(q10);
        // END
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
        // SQLiteDatabase db = this.getWritableDatabase();
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
        dbase = this.getReadableDatabase();
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


}
