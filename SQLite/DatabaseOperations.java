package aacs.com.np.cabapp.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dell on 8/23/2017.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version=1;
    public String CREATE_QUERY= "CREATE TABLE "+TableData.TableInfo.TABLE_NAME+"("+TableData.TableInfo.MESSAGE_TITLE+
            " TEXT,"+ TableData.TableInfo.MESSAGE_BODY+" TEXT );";
    public DatabaseOperations(Context context){
        super(context, TableData.TableInfo.DATABASE_NAME,null,database_version);

        Log.d("Database Operations","Database created........");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database Operations","Table created........");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInformation(DatabaseOperations dop,String message_title,String message_body)
    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableInfo.MESSAGE_TITLE,message_title);
        cv.put(TableData.TableInfo.MESSAGE_BODY,message_body);
        long k= SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations", "One row inserted");
    }
    public Cursor getInformation(SQLiteDatabase db ){
        String [] projection= {TableData.TableInfo.MESSAGE_TITLE, TableData.TableInfo.MESSAGE_BODY};
        Cursor cursor=db.query(TableData.TableInfo.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;
    }
}
