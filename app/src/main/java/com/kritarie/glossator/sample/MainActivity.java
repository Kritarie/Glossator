package com.kritarie.glossator.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kritarie.glossator.Glossator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        List<Animal> items = new ArrayList<>(15);
        items.add(new Dog());
        items.add(new Cat());
        items.add(new Fox());
        items.add(new Dog());
        items.add(new Cat());
        items.add(new Fox());
        items.add(new Dog());
        items.add(new Cat());
        items.add(new Fox());
        items.add(new Dog());
        items.add(new Cat());
        items.add(new Fox());
        items.add(new Fox());
        items.add(new Fox());
        items.add(new Fox());

        RecyclerView.Adapter adapter =
                Glossator.with(items)
                        .map(R.layout.view_cat, Cat.class, new CatHolderFactory())
                        .map(R.layout.view_dog, Dog.class, DogHolder.class)
                        .map(R.layout.view_fox, Fox.class)
                        .build();

        recycler.setAdapter(adapter);
    }
}
