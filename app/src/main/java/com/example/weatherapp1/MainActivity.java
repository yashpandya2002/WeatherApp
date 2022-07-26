
package com.example.weatherapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button button,button_current;
//ListView listView;
//    Spinner listView;
ImageView imageView;
GridView listView;
TextView txt_temperature,txt_time,txt_place,text_weather;
CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edt_regioncode);
//        button = findViewById(R.id.btn_regioncode);
        button_current = findViewById(R.id.btn_current);
        txt_place = findViewById(R.id.city_name);
        txt_temperature = findViewById(R.id.temperature);
        txt_time = findViewById(R.id.time);
        text_weather = findViewById(R.id.weather_text);
        imageView = findViewById(R.id.image_icon);
        cardView = findViewById(R.id.card_view);
        button_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue requestQueue1 = Volley.newRequestQueue(MainActivity.this);
                String url = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=J5lNCi62tWz5tXiRj2yhO3HhRoKgtYSJ&q=" + editText.getText().toString().toLowerCase() + "&details=true";
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        cardView.setVisibility(View.VISIBLE);
                        Log.e("Response", response.toString());


                        try {
                            JSONObject jsonObject = (JSONObject) response.get(0);
                            String key = jsonObject.getString("Key");
                            String city = jsonObject.getString("EnglishName");
                            Log.e("City code", key);
                            generateweather(city, key);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue1.add(request);
            }
        });
//        listView=findViewById(R.id.list_view);
//
//        ArrayList<MyFlag> arrayList=new ArrayList<>();
//        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
//        String url="https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/index.json";
//        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                int length=response.length();
////                Log.e("Response",response.toString());
////                Log.e("Length",String.valueOf(length));
//                for(int i=0;i<length;i++)
//                {
//                    try {
//                        JSONObject jsonObject= (JSONObject) response.get(i);
//                        arrayList.add(new MyFlag(jsonObject.getString("name"),jsonObject.getString("image"),jsonObject.getString("code")));
//                        Log.e("Country name:",jsonObject.getString("name"));
//                        Log.e("Country image:",jsonObject.getString("image"));
//                        Log.e("Country code:",jsonObject.getString("code"));
////                        Log.e("City:",country);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
////                Toast.makeText(MainActivity.this, "Countries received"+length, Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "Error in flag api", Toast.LENGTH_SHORT).show();
//            }
//        });
//        requestQueue.add(request);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<MyFlag> finalArray=new ArrayList<MyFlag>();
//                final MyFlagBaseAdapter[] myFlagBaseAdapter = new MyFlagBaseAdapter[1];
//                RequestQueue requestQueue1= Volley.newRequestQueue(MainActivity.this);
//                String url="https://dataservice.accuweather.com/locations/v1/countries/"+
//                        editText.getText().toString().trim()+"?apikey=V0XelMLczRMQqinOKTpyJ23xgnDP3PwG";
//                JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        int length=response.length();
//                        Log.e("Response",response.toString());
//                        Log.e("Length",String.valueOf(length));
//                        for(int i=0;i<length;i++)
//                        {
//                            try {
//                                JSONObject jsonObject= (JSONObject) response.get(i);
//                                String country=jsonObject.getString("EnglishName");
//                                String code=jsonObject.getString("ID");
//                                for(MyFlag myFlag:arrayList)
//                                {
//                                    if(code.equalsIgnoreCase(myFlag.getCode()))
//                                    {
//                                        finalArray.add(myFlag);
//
//                                    }
//                                }
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                        Log.e("Size of final array:",String.valueOf(finalArray.size()));
//                        Toast.makeText(MainActivity.this, "Countries received"+length, Toast.LENGTH_SHORT).show();
//                        myFlagBaseAdapter[0] =new MyFlagBaseAdapter(finalArray,MainActivity.this);
//                        listView.setAdapter(myFlagBaseAdapter[0]);
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                requestQueue1.add(request);
//            }
//        });
//    }
    }
    private void generateweather(String city, String key) {
        RequestQueue requestQueue1= Volley.newRequestQueue(MainActivity.this);
        String url="http://dataservice.accuweather.com/currentconditions/v1/"+key+"?apikey=J5lNCi62tWz5tXiRj2yhO3HhRoKgtYSJ";
        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.e("Response",response.toString());


                try {
                    JSONObject jsonObject= (JSONObject) response.get(0);
                    long time=System.currentTimeMillis();
                    String weather=jsonObject.getString("WeatherText");
                    boolean isRaining=jsonObject.getBoolean("HasPrecipitation");
                    long temperature=jsonObject.getJSONObject("Temperature").getJSONObject("Metric").getLong("Value");
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date resultdate = new Date(time);
                    if(weather.toLowerCase().contains("sunny")||weather.toLowerCase().contains("sunshine"))
                    {
                        imageView.setImageResource(R.drawable.sunny);
                    }
                    else if(weather.toLowerCase().contains("cloud"))
                    {
                        imageView.setImageResource(R.drawable.cloud);
                    }
                    else if(weather.toLowerCase().contains("shower")||weather.toLowerCase().contains("rain"))
                    {
                        imageView.setImageResource(R.drawable.rainy);
                    }
                    else if(weather.toLowerCase().contains("clear"))
                    {
                        imageView.setImageResource(R.drawable.clearsky);
                    }
                    else if(weather.toLowerCase().contains("storm"))
                    {
                        imageView.setImageResource(R.drawable.storm);
                    }
                    else
                    {
                        imageView.setImageResource(R.drawable.cloud);
                    }

//                    Log.e("City code",key);
//                    Log.e("time",String.valueOf(time));
//                    Log.e("weather",weather);
//                    Log.e("temp",String.valueOf(temperature));
                    txt_place.setText(city);
                    txt_temperature.setText(String.valueOf(temperature)+ " \u2103");
                    txt_time.setText(String.valueOf(sdf.format(resultdate)));
                    text_weather.setText(weather);




                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue1.add(request);
    }
}