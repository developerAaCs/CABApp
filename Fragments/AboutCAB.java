package aacs.com.np.cabapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import aacs.com.np.cabapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutCAB extends Fragment {
    TextView textView;
    TextView textView1;


    public AboutCAB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about_cab,container,false);

        textView= (TextView) view.findViewById(R.id.title_about_cab);
        textView1= (TextView) view.findViewById(R.id.text_about_cab);

        return view;
    }

}
