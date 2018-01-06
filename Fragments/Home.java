package aacs.com.np.cabapp.Fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import aacs.com.np.cabapp.MainActivity;
import aacs.com.np.cabapp.R;
import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    FloatingActionButton fab_plus, fab_call, fab_fb;
    Animation FabOpen, FabClose, FabRClockwise, FabRanticlockwise;
    boolean isOpen = false;
    TextView about_text;
    ImageView about_image;
    TextView button_message;
    ViewPager mPager;
    int currentPage=0;
    private static final Integer[] XMEN={R.drawable.building,R.drawable.classroom,R.drawable.lab};
    ArrayList<Integer> XMENArray= new ArrayList<Integer>();




    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        about_text= (TextView) view.findViewById(R.id.about_cab);
        about_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCAB aboutCAB = new AboutCAB();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.fragment_container, aboutCAB);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();

            }
        });
        button_message= (TextView) view.findViewById(R.id.message);
        button_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message_from_principal message = new Message_from_principal();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.fragment_container, message);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
        // about_image= (ImageView) view.findViewById(R.id.about_image);
        //Image slider


        //For floating action button
        fab_plus = (FloatingActionButton) view.findViewById(R.id.fab_plus);
        fab_call = (FloatingActionButton) view.findViewById(R.id.fab_call);
        fab_fb = (FloatingActionButton) view.findViewById(R.id.fab_facebook);
        //Animation of the buttons
        FabOpen = AnimationUtils.loadAnimation(getContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_anticlockwise);

        //Directly make a phone call to the college
        fab_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("tel:" + "014462736"));

                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    getActivity().startActivity(intent);

                }
            }
        });
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    fab_fb.startAnimation(FabClose);
                    fab_call.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_call.setClickable(false);
                    fab_fb.setClickable(false);
                    isOpen = false;


                } else {
                    fab_fb.startAnimation(FabOpen);
                    fab_fb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Check the network connection
                            ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                                    .getSystemService(Context.CONNECTIVITY_SERVICE);
                            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                            if (networkInfo == null || !networkInfo.isConnected()) {

                                No_internet newFragment = new No_internet();
                                // consider using Java coding conventions (upper first char class names!!!)
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.addToBackStack(null);

                                // Replace whatever is in the fragment_container view with this fragment,
                                // and add the transaction to the back stack
                                transaction.replace(R.id.fragment_container, newFragment);


                                // Commit the transaction
                                transaction.commit();
                            }else {
                                Facebook newFragment = new Facebook();
                                // consider using Java coding conventions (upper first char class names!!!)
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.addToBackStack(null);
                                // Replace whatever is in the fragment_container view with this fragment,
                                // and add the transaction to the back stack
                                transaction.replace(R.id.fragment_container, newFragment);


                                // Commit the transaction
                                transaction.commit();
                            }
                        }
                    });
                    fab_call.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);
                    fab_call.setClickable(true);

                    fab_fb.setClickable(true);
                    isOpen=true;

                }
            }
        });

            //Image Slider
            for(int i=0;i<XMEN.length;i++)
                XMENArray.add(XMEN[i]);
                mPager= (ViewPager) view.findViewById(R.id.view_pager);
                mPager.setAdapter(new ViewPagerAdapter(getContext(),XMENArray));
                CircleIndicator indicator= (CircleIndicator) view.findViewById(R.id.indicator);
                indicator.setViewPager(mPager);

                //Autp start of viewpager
                final android.os.Handler handler= new android.os.Handler();
                final Runnable Update=new Runnable() {
                    @Override
                    public void run() {
                        if(currentPage== XMEN.length){
                            currentPage=0;
                        }
                        mPager.setCurrentItem(currentPage++,true);
                    }
                };
                Timer swipeTimer= new Timer();
                swipeTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(Update);
                    }
                },2500,2500);



        return view;

    }







}
