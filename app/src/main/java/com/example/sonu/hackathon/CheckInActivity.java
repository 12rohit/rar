package com.example.sonu.hackathon;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CheckInActivity extends ListActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        new GetPlaces(this,getListView()).execute();
    }

    class GetPlaces extends AsyncTask<Void, Void, Void> {

        private ProgressDialog dialog;
        private Context context;
        private String[] placeName;
        private String[] imageUrl;
        private String[] vicinity;
        private ListView listView;

        public GetPlaces(Context context, ListView listView) {

            this.context = context;
            this.listView = listView;
        }


        protected void onPostExecute(Void  result) {

            super.onPostExecute(result);
            dialog.dismiss();
            // Log.d("ravindra","onPostExecute");
            //Toast.makeText(context, "onPostExecute"+result, Toast.LENGTH_SHORT).show();
            listView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1,placeName));
            /*recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            BookmarkedRecyclerAdapter adapter = new BookmarkedRecyclerAdapter(getApplicationContext(),placeName,vicinity);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));*/
        }


        protected void onPreExecute() {

            super.onPreExecute();
            dialog = new ProgressDialog(context);
            dialog.setCancelable(true);
            dialog.setMessage("Loading..");
            dialog.isIndeterminate();
            dialog.show();
            // Log.d("ravindra","onPreExecute");
        }


        protected Void doInBackground(Void... arg0) {



            PlacesService service = new PlacesService("AIzaSyAtoBeJHsegAvXRg1NsjjqmV6s0XS-KJME");
            List<Place> findPlaces = service.findPlaces(21.2514, 81.6296,"hospital");  // hospiral for hospital
            // atm for ATM


            placeName = new String[findPlaces.size()];
            imageUrl = new String[findPlaces.size()];
            vicinity = new String[findPlaces.size()];

            for (int i = 0; i < findPlaces.size(); i++) {

                Place placeDetail = findPlaces.get(i);
                placeDetail.getIcon();

                // Toast.makeText(context, placeDetail.getName(), Toast.LENGTH_SHORT).show();
                // System.out.println(  placeDetail.getName());
                placeName[i] =placeDetail.getName();
                imageUrl[i] =placeDetail.getIcon();
                vicinity[i] =placeDetail.getVicinity();

            }
            return null;
        }
    }
}


