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
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import aacs.com.np.cabapp.R;
import aacs.com.np.cabapp.RealTimeData.MyDataSet;
import aacs.com.np.cabapp.RealTimeData.NotificationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    List<MyDataSet> notifications = new ArrayList<>();
    FirebaseDatabase FDB;
    DatabaseReference DBR;

    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);


        Toast.makeText(getContext(),"Fetching recent notices...... Please wait",Toast.LENGTH_SHORT).show();
        //Firebase operations
        FDB = FirebaseDatabase.getInstance();
        DBR = FDB.getReference("Notice");
        DBR.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MyDataSet data= new MyDataSet();
                data= dataSnapshot.getValue(MyDataSet.class);
                notifications.add(data);
                adapter = new NotificationAdapter(getContext(), notifications);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return rootView;


    }
}
