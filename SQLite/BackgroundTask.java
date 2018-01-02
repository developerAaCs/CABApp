package aacs.com.np.cabapp.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

/**
 * Created by Dell on 8/25/2017.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context ctx;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        DatabaseOperations dbOperations= new DatabaseOperations(ctx);
       SQLiteDatabase db= dbOperations.getReadableDatabase();
        Cursor cursor= dbOperations.getInformation(db);
        return null;
    }

}
