package facci.guillermoduran.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.util.*;

public class listView extends AppCompatActivity {
    ListView listaBook;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listaBook = (ListView) findViewById(R.id.lv_books);

        final List<Book> books = Book.listAll(Book.class);
        final List<String> listaTextoLibros = new ArrayList<>();

        for(Book libro: books){
            Log.e("Libro", libro.getTitle() + ", " + libro.getEdition());
            listaTextoLibros.add(libro.getTitle() + ", " + libro.getEdition());
        }

        listaBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent edit = new Intent(listView.this, edit.class);
                Bundle ident = new Bundle();
                ident.putString("id", String.valueOf(id+1));
                edit.putExtras(ident);
                startActivity(edit);
            }
        });

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, listaTextoLibros);

        listaBook.setAdapter(itemsAdapter);
    }
}
