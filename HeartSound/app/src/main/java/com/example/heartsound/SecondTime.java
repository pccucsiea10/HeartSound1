package com.example.heartsound;


import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


public class SecondTime extends Fragment {

    private View mainView;
    private Button department_stop_test;
    public Chronometer count_down2;
    public static TextView First;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        mainView = inflater.inflate(R.layout.activity_second_time,container,false);
        count_down2 = mainView.findViewById(R.id.count_down);
        department_stop_test = mainView.findViewById(R.id.department_stop_test);
        First = mainView.findViewById(R.id.First);
        count_down2.setBase(SystemClock.elapsedRealtime() + 600000);
        count_down2.start();

        WebView webView = (WebView)mainView.findViewById(R.id.sd);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setAllowContentAccess(true);
//        webView.getSettings().setAllowFileAccess(true);
//        webView.getSettings().setMediaPlaybackRequiresUserGesture(true);
//        webView.getSettings().setUserAgentString(USERAGENT);//Important to auto play video
//        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.setWebChromeClient(new WebChromeClient());
//        webView.setWebViewClient(new WebViewClient());


        webView.loadUrl("https://www.youtube.com/embed/wPVTdiWiJJY");



//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                webView.setWebChromeClient(new WebChromeClient());
//                webView.loadUrl(url);
//                return false;
//            }
//        });


        department_stop_test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Connect.sync(First.getText().toString());

                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container,new StartNormal3()).commit();
            }
        });

        count_down2.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {

                count_down2.setText(count_down2.getText().toString().substring(1));
                if (SystemClock.elapsedRealtime()-count_down2.getBase()>=0){
                    count_down2.stop();
                }
            }
        });
        return mainView;

    }

}