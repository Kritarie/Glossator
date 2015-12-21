package com.kritarie.glossator.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kritarie.glossator.*;

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

        List<Animal> items = new ArrayList<>(17000);
        for (int i = 0; i < 1000; i++) {
            items.add(new Dog());
            items.add(new Cat());
            items.add(new Fox());
            items.add(new Dog());
            items.add(new Lizard());
            items.add(new Cat());
            items.add(new Fox());
            items.add(new Dog());
            items.add(new Cat());
            items.add(new Fox());
            items.add(new Dog());
            items.add(new Cat());
            items.add(new Fox());
            items.add(new Horse());
            items.add(new Fox());
            items.add(new Fox());
            items.add(new Fox());
        }

        RecyclerView.Adapter adapter =
                Glossator.with(items)
                        .map(R.layout.view_default)
                        .map(Cat.class, new CatHolderFactory(R.layout.view_cat, new Object()))
                        .map(Dog.class, DogHolder.class, R.layout.view_dog)
                        .map(Fox.class, R.layout.view_fox)
                        .build();

        recycler.setAdapter(adapter);
    }
}
