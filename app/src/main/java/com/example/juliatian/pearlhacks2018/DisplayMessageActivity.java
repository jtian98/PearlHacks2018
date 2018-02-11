package com.example.juliatian.pearlhacks2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DisplayMessageActivity extends AppCompatActivity {

    // Map<Integer, Map<String, Double[]>> _r; // restaurant Map
    Map<Integer, String> _r;
    int _i; // index of restaurant
    TextView _textView;
    Map<String, Double[]> _xy; // longitude/latitude coordinates
    double[] _coord;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public DisplayMessageActivity() {
        // Franklin Street Restaurants

        // _r = new HashMap<Integer, Map<String, Double[]>>();
        _r = new HashMap<Integer, String>();

        // addn features
        _xy = new HashMap<String, Double[]>();
        _coord = new double[2]; // xy

        // Asian

//        double[] c = new double[] {35.913170, -79.055003};
//        _xy.put("Asia Cafe", c);
//        _r.put(1, _xy);
//
//        c = new double[] {35.913393, -79.056142};
//        _xy.put("Kurama Sushi & Noodle Express", c);
//        _r.put(2, _xy);
//
//        c = new double[] {35.910445, -79.062336};
//        _xy.put("Lantern", c);
//        _r.put(3, _xy);

        _r.put(1, "Asia Cafe");
        _r.put(2, "Kurama Sushi & Noodle Express");
        _r.put(3, "Lantern");
        _r.put(4, "Shanghai Dumpling");
        _r.put(5, "Sawasdee Thai Restaurant");
        _r.put(6, "Lime and Basil");
        _r.put(7, "Ms. Mong");
        _r.put(8, "Noodles and Company");
        _r.put(9, "Spicy 9 Sushi Bar & Asian Restaurant");

        // Bars
        _r.put(10, "Blue Horn Lounge");
        _r.put(11, "Carolina Brewery");
        _r.put(12, "Carolina Coffee Shop");
        _r.put(13, "The Cave");
        _r.put(14, "The Cellar");
        _r.put(15, "Country Fried Duck");
        _r.put(16, "The Crunkleton");
        _r.put(17, "The Dead Mule Club");
        _r.put(18, "Four Corners Grill");
        _r.put(19, "Goodfellow's");
        _r.put(20, "He's Not Here");
        _r.put(21, "The Library");
        _r.put(22, "Linda's Bar and Grill");
        _r.put(23, "Mellow Mushroom");
        _r.put(24, "Might As Well Bar & Grill");
        _r.put(25, "Nightlight Bar and Club");
        _r.put(26, "The Northside District");
        _r.put(27, "Roberts at the Franklin Lobby Bar & Patio");
        _r.put(28, "Sup Dogs");
        _r.put(29, "Top of the Hill");
        _r.put(30, "TRU Deli + Wine Bar");
        _r.put(31, "West End Wine Bar");
        _r.put(32, "Zog's Pool Hall");

        // Breakfast
        _r.put(33, "Breadmen's");
        _r.put(34, "Crook's Corner");
        _r.put(35, "Kipos Greek Taverna");
        _r.put(36, "Mama Dip's Kitchen");
        _r.put(37, "McDonald's");
        _r.put(38, "Panera Bread Company");
        _r.put(39, "The Purple Bowl");
        _r.put(40, "Starbucks Coffee");
        _r.put(41, "Smoothie King");
        _r.put(42, "Sutton's Drug Store");
        _r.put(43, "Time Out Restaurant");
        _r.put(44, "Waffle House");
        _r.put(45, "Ye Olde Waffle Shoppe");

        // Casual
        _r.put(46, "Bski's Tortilla Wrap Grill");
        _r.put(47, "Buns");
        _r.put(48, "Cuban Revolution Express");
        _r.put(49, "Grk Yeero");
        _r.put(50, "Imbibe");
        _r.put(51, "Jimmy John's");
        _r.put(52, "Joe's Joint");
        _r.put(53, "Moe's Southwest Grill");
        _r.put(54, "R&R Grill");
        _r.put(55, "Spanky's Restaurant and Bar");
        _r.put(56, "Trolley Stop");

        // Coffee & Bakeries
        _r.put(57, "Perennial");
        _r.put(58, "Sugarland");

        // Dessert
        _r.put(59, "Ben & Jerry's");
        _r.put(60, "Yogurt Pump");
        _r.put(61, "Insomnia Cookies");

        // Fine Dining
        _r.put(62, "411 West Restaurant");
        _r.put(63, "Elaine's on Franklin");
        _r.put(64, "La Residence Restaurant");
        _r.put(65, "Talulla's Mezze Lounge & Bar");
        _r.put(66, "Cholanad");

        // Indian
        _r.put(67, "Vimala's Curryblossom Cafe");

        // Italian
        _r.put(68, "Italian Pizzeria III");

        // Late night
        _r.put(69, "I <3 NY Pizza");
        _r.put(70, "Papa John's Pizza");
        _r.put(71, "Toppers");

        // Mediterranean
        _r.put(72, "Mediterranean Deli");

        // Mexican
        _r.put(73, "Bandido's Mexican Café");
        _r.put(74, "Chipotle");
        _r.put(75, "Cosmic Cantina");

        // Pizza
        _r.put(76, "Benny Capella's");
        _r.put(77, "Lotsa Stone Fired Pizza");

        // Southern
        // all duplicates

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainScreen.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        _textView = findViewById(R.id.textView);
        _textView.setText(message);

        TextView restaurantView = findViewById(R.id.restaurant);
        Random random = new Random();
        _i = random.nextInt(77 - 1 + 1) + 1;
        // _i = random.nextInt(3 - 1 + 1) + 1;
        // String[] temp = (String[])_r.get(_i).entrySet().toArray();
        restaurantView.setText(_r.get(_i));
        // _coord = _r.get(_i).values();
    }

    public void findLocation(View view) {
        Intent intent = new Intent(this, DisplayLocationActivity.class); //*
        double[] coordinates = new double[2];
        coordinates[0] = 35.91146;
        coordinates[1] = -79.060447;
        intent.putExtra(EXTRA_MESSAGE, coordinates);
        startActivity(intent);
    }

    public void retry(View view) {
        Intent intent = new Intent(DisplayMessageActivity.this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, _textView.getText().toString());
        startActivity(intent);
        finish();
    }

}
