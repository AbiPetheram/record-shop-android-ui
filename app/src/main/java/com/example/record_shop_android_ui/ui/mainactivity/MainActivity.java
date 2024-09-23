package com.example.record_shop_android_ui.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.record_shop_android_ui.R;
import com.example.record_shop_android_ui.databinding.ActivityMainBinding;
import com.example.record_shop_android_ui.model.Album;
import com.example.record_shop_android_ui.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    private RecyclerView recyclerView;
    private ArrayList<Album> albums;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    private MainActivityClickHandler clickHandler;
    private final String ALBUM_KEY = "album";
    private ArrayList<Album> filteredAlbumList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        clickHandler = new MainActivityClickHandler(this);
        binding.setClickHandler(clickHandler);

        getAllAlbums();

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text){
        filteredAlbumList = new ArrayList<>();

        for (Album album : albums){
            if(album.getAlbumName().toLowerCase().contains(text.toLowerCase())){
                filteredAlbumList.add(album);
            }
        }
        if(filteredAlbumList.isEmpty()){
            Toast.makeText(MainActivity.this,
                    "No album found",
                    Toast.LENGTH_SHORT).show();
        } else {
            albumAdapter.setFilteredAlbumList(filteredAlbumList);
        }
    }

    private void getAllAlbums(){
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                albums = (ArrayList<Album>) albumsFromLiveData;
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView(){
        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(this, albums, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, UpdateAlbumActivity.class);
        if(filteredAlbumList == null){
            intent.putExtra(ALBUM_KEY, albums.get(position));
        } else{
            intent.putExtra(ALBUM_KEY, filteredAlbumList.get(position));
        }
        startActivity(intent);
    }
}