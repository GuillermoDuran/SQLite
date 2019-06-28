package facci.guillermoduran.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.*;

public class edit extends AppCompatActivity {
    EditText txtTitle, txtEdit;
    Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        txtTitle = (EditText) findViewById(R.id.txt_ttl);
        txtEdit = (EditText) findViewById(R.id.txt_edi);
        btnApply = (Button) findViewById(R.id.btn_aplicar);

        final Bundle bundle = this.getIntent().getExtras();

        Log.e("identificador", bundle.getString("id"));

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = Book.findById(Book.class, Long.parseLong(bundle.getString("id")));
                Log.e("identificador", bundle.getString("id"));
                book.title = txtTitle.getText().toString();
                book.edition =txtEdit.getText().toString();
                book.save();
            }
        });
    }
}
