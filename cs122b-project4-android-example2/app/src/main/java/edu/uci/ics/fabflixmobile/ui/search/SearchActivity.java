package edu.uci.ics.fabflixmobile.ui.search;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import edu.uci.ics.fabflixmobile.R;
import edu.uci.ics.fabflixmobile.data.NetworkManager;
import edu.uci.ics.fabflixmobile.databinding.ActivitySearchBinding;
import edu.uci.ics.fabflixmobile.ui.movielist.MovieListActivity;

public class SearchActivity extends AppCompatActivity {

    private EditText searchbox;

    private TextView message;

    /*
      In Android, localhost is the address of the device or the emulator.
      To connect to your machine, you need to use the below IP address
     */
    private final String host = "10.0.2.2";
    private final String port = "8080";
    //    private final String domain = "cs122b_project2_login_cart_example_war";
    private final String domain = "nkdl_proj_war";
    private final String baseURL = "http://" + host + ":" + port + "/" + domain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchBinding binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        searchbox = binding.searchbox;
        message = binding.message;
        final Button searchButton = binding.search;

        //assign a listener to call a function to handle the user request when clicking a button
        searchButton.setOnClickListener(view -> search());
    }

    @SuppressLint("SetTextI18n")
    public void search() {
        String searchQuery = searchbox.getText().toString();
        message.setText("Trying to search: " + searchQuery);

        // use the same network queue across our application
        final RequestQueue queue = NetworkManager.sharedManager(this).queue;
        // request type is POST
        final StringRequest searchRequest = new StringRequest(
                Request.Method.GET,
                baseURL + "/movie-list?title=" + searchQuery,
                response -> {
                    // TODO: should parse the json response to redirect to appropriate functions
                    //  upon different response value.
                    Log.d("search.success", response);
//                    message.setText("Trying to search: " + searchQuery);
//                    message.setText("Trying to search: " + response);
//                    finish();
                    // Pass the search query and response to the MovieListActivity
                    Intent movieListIntent = new Intent(SearchActivity.this, MovieListActivity.class);
                    movieListIntent.putExtra("searchQuery", searchQuery);
                    movieListIntent.putExtra("searchResponse", response);
                    startActivity(movieListIntent);
                },
                error -> {
                    // error
                    Log.d("search.error", error.toString());
                });

        // important: queue.add is where the search request is actually sent
        queue.add(searchRequest);
    }

}