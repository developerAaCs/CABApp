package aacs.com.np.cabapp.Fragments;


import android.app.DownloadManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import aacs.com.np.cabapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Facebook extends Fragment {

    WebView myWebview;
    FrameLayout frameLayout;
    ProgressBar progressBar;
    public Facebook() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_facebook, container, false);
        frameLayout= (FrameLayout) view.findViewById(R.id.framelayout);
        progressBar= (ProgressBar) view.findViewById(R.id.progress);
        progressBar.setMax(100);
        myWebview = (WebView) view.findViewById(R.id.webView);
        myWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        WebSettings webSettings= myWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);





        myWebview.loadUrl("https://www.facebook.com/collegeofappliedbusiness/");
        myWebview.setWebViewClient(new WebViewClient());
        myWebview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                frameLayout.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);

                if(newProgress==100){
                    frameLayout.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        myWebview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Log.i("URL", url);
                DownloadManager.Request request= new DownloadManager.Request(Uri.parse(url));
                request.setMimeType(mimetype);
                String cookies= CookieManager.getInstance().getCookie(url);
                request.addRequestHeader("cookie",cookies);
                request.addRequestHeader("User-Agent", userAgent);

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                DownloadManager dm= (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getContext(), "Downloading File....",
                        Toast.LENGTH_LONG).show();

            }
        });
        myWebview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()== KeyEvent.ACTION_DOWN){
                    myWebview= (WebView) v;
                    switch (keyCode){
                        case KeyEvent.KEYCODE_BACK:
                            if(myWebview.canGoBack()){
                                myWebview.goBack();
                                return  true;
                            }
                            break;
                    }
                }

                return false;
            }
        });
        progressBar.setProgress(0);
        return view;

    }

}
