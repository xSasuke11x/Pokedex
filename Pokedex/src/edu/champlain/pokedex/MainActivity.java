package edu.champlain.pokedex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

        private static final String TAG = null;
		TextView valueTextView;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.activity_main);
                
        	valueTextView = (TextView) findViewById(R.id.textViewAnswer);
	        Spinner s = (Spinner)findViewById(R.id.spinnerList);
	        
	        AssetManager am = this.getAssets();
	        try {
	        	InputStream is = am.open("pokedexfile.txt");
	        	BufferedReader in = new BufferedReader(new InputStreamReader(is));
	        	String line, line2;
	        	final MyData items[] = new MyData[69];
	        	int i = 0;
	        	while (((line = in.readLine()) != null) && ((line2 = in.readLine()) != null)) {
	        		Log.d(TAG, line.toString());
	        		items[i] = new MyData (line, line2);
	        		i++;
	        	}
	        	ArrayAdapter<MyData> adapter = new ArrayAdapter<MyData>(this,
	                    android.R.layout.simple_spinner_item, items);
			    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			    s.setAdapter(adapter);
			    s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		                MyData d = items[position];
		                valueTextView.setText( d.getValue() );
		            }
	
		            public void onNothingSelected(AdapterView<?> parent) {
		            }
			    });
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
        
        }
        
        class MyData {
                
	        String spinnerText;
	        String value;
	                
	        public MyData( String spinnerText, String value ) {
	            this.spinnerText = spinnerText;
	            this.value = value;
	        }
	
	        public String getSpinnerText() {
	            return spinnerText;
	        }
	
	        public String getValue() {
	            return value;
	        }
	
	        public String toString() {
	            return spinnerText;
	        }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }

}