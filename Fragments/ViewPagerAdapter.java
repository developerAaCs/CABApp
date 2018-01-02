package aacs.com.np.cabapp.Fragments;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import aacs.com.np.cabapp.R;

/**
 * Created by Dell on 7/5/2017.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Integer> images;

    public ViewPagerAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images=images;
        layoutInflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= layoutInflater.inflate(R.layout.view_pager_layout,container,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.view_image);
        imageView.setImageResource(images.get(position));
        container.addView(view,0);
        return  view;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }
}
