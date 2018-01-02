package aacs.com.np.cabapp.SQLite;

import android.provider.BaseColumns;

/**
 * Created by Dell on 8/23/2017.
 */
public class TableData {
    public TableData(){


    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String MESSAGE_TITLE="message_title";
        public static final String MESSAGE_BODY="message_body";
        public static final String RECEIVED_TIME="received_time";
        public static final String TABLE_NAME="notification_info";
        public static final String DATABASE_NAME="notification";



    }
}
