package aacs.com.np.cabapp.Fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import aacs.com.np.cabapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Message_from_principal extends Fragment {
    TextView textView;
    ImageView imageView;
    TextView textView1;

    public Message_from_principal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_message_from_principal, container,false);
        textView= (TextView) view.findViewById(R.id.title_message_from_principal);
        imageView= (ImageView) view.findViewById(R.id.image_principal);
        textView1= (TextView) view.findViewById(R.id.text_message_from_principal);

        // Inflate the layout for this fragment
        return view;
    }

}
