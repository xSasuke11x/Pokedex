package edu.champlain.pokedex;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView valueTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		valueTextView = (TextView) findViewById(R.id.textViewAnswer);
        Spinner s = (Spinner)findViewById(R.id.spinnerList);
        final MyData items[] = new MyData[3];
        items[0] = new MyData( "Chespin","Basic" );
        items[1] = new MyData( "Quilladin","Evolve Chespin at Lv. 16" );
        items[2] = new MyData( "Chesnaught","Evolve Quilladin at Lv. 36" );
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
            }
        );
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
