package sg.edu.rp.c346.p12_practicalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    WebView webView;

    ArrayList<String> al;
    ArrayAdapter<String> aa;

    int website;
    String site;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn = findViewById(R.id.spinner);
        webView = findViewById(R.id.webView);

        al = new ArrayList<>();
        String[] str = getResources().getStringArray(R.array.web);
        al.addAll(Arrays.asList(str));

        aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,al);

        webView.setWebViewClient(new WebViewClient());

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        //al.clear();
                        website = spn.getSelectedItemPosition();
                        //site = "https://www.google.com.sg/";
                        break;
                    case 1:
                        //al.clear();
                        website = spn.getSelectedItemPosition();
                        //site = "http://www.rp.edu.sg";
                        break;
                }
                if(website == 0){
                    site = "https://www.google.com.sg/";
                    webView.loadUrl(site);
                }
                else{
                    site = "http://www.rp.edu.sg";
                    webView.loadUrl(site);
                }
                aa.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
