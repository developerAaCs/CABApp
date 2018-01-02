package aacs.com.np.cabapp.Fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aacs.com.np.cabapp.R;
import aacs.com.np.cabapp.SQLite.BackgroundTask;
import aacs.com.np.cabapp.SQLite.DatabaseOperations;
import aacs.com.np.cabapp.SQLite.Notification;
import aacs.com.np.cabapp.SQLite.NotificationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    //BackgroundTask backgroundTask;
    List<Notification> notifications= new ArrayList<>();
    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_news,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //backgroundTask= new BackgroundTask(getContext());
        //backgroundTask.execute();
       /* DatabaseOperations databaseOperations= new DatabaseOperations(getContext());
        SQLiteDatabase sqLiteDatabase= databaseOperations.getReadableDatabase();

        Cursor cursor= databaseOperations.getInformation(sqLiteDatabase);
        cursor.moveToLast();
        do {
            Notification notification= new Notification(cursor.getString(0),cursor.getString(1));
            notifications.add(notification);


        }while (cursor.moveToPrevious());
        databaseOperations.close();*/
        adapter= new NotificationAdapter(getContext(),notifications);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
