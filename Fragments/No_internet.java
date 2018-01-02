package aacs.com.np.cabapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aacs.com.np.cabapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class No_internet extends Fragment {
    TextView textView;


    public No_internet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_no_internet,container,false);

        textView= (TextView) view.findViewById(R.id.no_internet);
        return view;
    }

}
