package facci.guillermoduran.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.*;
import android.util.*;

public class listView extends AppCompatActivity {
    ListView listaBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listaBook = (ListView) findViewById(R.id.lv_books);

        List<Book> books = Book.listAll(Book.class);
        List<String> listaTextoLibros = new ArrayList<>();

        for(Book libro: books){
            Log.e("Libro", libro.getTitle() + ", " + libro.getEdition());
            listaTextoLibros.add(libro.getTitle() + ", " + libro.getEdition());
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, listaTextoLibros);

        listaBook.setAdapter(itemsAdapter);
    }
}
