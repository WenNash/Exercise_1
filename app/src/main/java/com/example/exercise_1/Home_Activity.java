package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collection;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    SearchView searchView;

    private ListView list;

    private ListViewAdapter adapter;

    String[] listnama;

    public static ArrayList<classnama> classNamaArrayList = new ArrayList<classnama>();

    Bundle bundle = new Bundle();

    Intent intent;
    String namakontak;

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        searchView = findViewById(R.id.search_bar);
        listnama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina", "Gita", "Vian", "Lutfi"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listnama);
        list = findViewById(R.id.listkontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            com.example.exercise_1.classnama classnama = new com.example.exercise_1.classnama(listnama[i]);
            classNamaArrayList.add(classnama);

            adapter = new ListViewAdapter(this);

            list.setAdapter(arrayAdapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    namakontak = classNamaArrayList.get(position).getName();

                    bundle.putString("a", namakontak.trim());

                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                    pm.setOnMenuItemClickListener(Home_Activity.this);

                    pm.inflate(R.menu.popup_menu);

                    pm.show();

                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Home_Activity.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Home_Activity.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),lihat_data.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor = namakontak.trim();
                String isinomor = "";
                if (nomor == "Inayah"){
                    isinomor = "08129878762";
                }
                else if (nomor == "Ilham"){
                    isinomor = "00813467986";
                }
                else if (nomor == "Eris"){
                    isinomor = "0814375345";
                }
                else if (nomor == "Fikri"){
                    isinomor = "0815754785";
                }
                else if (nomor == "Maul"){
                    isinomor = "0816976964";
                }
                else if (nomor == "Intan"){
                    isinomor = "0817973256";
                }
                else if (nomor == "Vina"){
                    isinomor = "0818654067";
                }
                else if (nomor == "Gita"){
                    isinomor = "0819743869";
                }
                else if (nomor == "Vian"){
                    isinomor = "0820764345";
                }
                else if (nomor == "Luthfi"){
                    isinomor = "0821754854";
                }

                Toast.makeText(getApplicationContext(), isinomor,
                        Toast.LENGTH_LONG).show();

                Toast.makeText(getApplicationContext(),"Edit Kontak", Toast.LENGTH_LONG).show();
                break;

        }
        return false;
    }
}