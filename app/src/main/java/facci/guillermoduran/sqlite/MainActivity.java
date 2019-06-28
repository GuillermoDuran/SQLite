package facci.guillermoduran.sqlite;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.View;
import android.widget.*;
import android.util.*;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    ListView listViewLibros;
    Button btnWrite;
    Button btnRead;
    Button btnDelete, btnConsultaInd, btnDeleteAll;
    Button btnEdit;
    EditText txtTitle, txtEdition, txtConsultaInd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtConsultaInd= (EditText) findViewById(R.id.editxt_update);
        btnConsultaInd = (Button) findViewById(R.id.btn_consultaIndividual);
        listViewLibros =(ListView) findViewById(R.id.lv_books);
        btnWrite = (Button) findViewById(R.id.btn_write);
        btnRead = (Button) findViewById(R.id.btn_read);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnEdit = (Button) findViewById(R.id.btn_edit);
        txtTitle = (EditText) findViewById(R.id.txt_title);
        txtEdition = (EditText) findViewById(R.id.txt_edition);
        btnDeleteAll = (Button) findViewById(R.id.btn_delete_all);

        btnWrite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            Book registro = new Book(txtTitle.getText().toString(), txtEdition.getText().toString());
            registro.save();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, listView.class);
            startActivity(i);
            }
        });

        btnConsultaInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class, Long.parseLong(txtConsultaInd.getText().toString()));
                txtTitle.setText(book.getTitle());
                txtEdition.setText(book.getEdition());
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class, Long.parseLong(txtConsultaInd.getText().toString()));
                book.title = txtTitle.getText().toString();
                book.edition = txtEdition.getText().toString();
                book.save();
            }
        });

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = Book.listAll(Book.class);
                Book.deleteAll(Book.class);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class, Long.parseLong(txtConsultaInd.getText().toString()));
                book.delete();
            }
        });

      /* Book registro1 = new Book("Libro 1", "primera edicion edicion");
        registro1.save();
        Book registro2 = new Book("Libro 2", "segunda edicion edicion");
        registro2.save();
        Book registro3 = new Book("Libro 3", "tercera edicion edicion");
        registro3.save();

        Book book = Book.findById(Book.class, Long.parseLong("1"));
        book.title = "Libro 1.1";
        book.edition = "edicion segunda";
        book.save();*/
    }
}