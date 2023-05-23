package edu.uci.ics.fabflixmobile.ui.movielist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.uci.ics.fabflixmobile.R;
import edu.uci.ics.fabflixmobile.data.model.Movie;
import edu.uci.ics.fabflixmobile.ui.search.SearchActivity;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    private TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);
        // TODO: this should be retrieved from the backend server
        Intent intent = getIntent();
        String searchQuery = intent.getStringExtra("searchQuery");
        String searchResponse = intent.getStringExtra("searchResponse");

        // Use the searchQuery and searchResponse to display the movie list
        // You can parse the response JSON and populate the movie list accordingly

        // Example: Log the search query
        Log.d("MovieList", "Search Query: " + searchQuery);
//        message.setText(searchQuery);
        message.setText(searchResponse);
        final ArrayList<Movie> movies = new ArrayList<>();
//        Movie(String name, short year, String id, String director, ArrayList< Star > stars, ArrayList< Genre > genres)
//        movies.add(new Movie("The Terminal", (short) 2004));
//        movies.add(new Movie("The Final Season", (short) 2007));
//        movies.add(new Movie("Logged in success", (short) 2023));
        MovieListViewAdapter adapter = new MovieListViewAdapter(this, movies);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Movie movie = movies.get(position);
            @SuppressLint("DefaultLocale") String message = String.format("Clicked on position: %d, name: %s, %d", position, movie.getName(), movie.getYear());
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        });
    }
    protected void goBack(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Intent goBackIntent = new Intent(MovieListActivity.this, SearchActivity.class);
        startActivity(goBackIntent);
    }
}