package edu.cs.birzeit.library13;

import androidx.appcompat.app.AppCompatActivity;
import edu.cs.birzeit.library13.model.Book;
import edu.cs.birzeit.library13.model.BookDa;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnShow;
    private Spinner spnTypes;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = findViewById(R.id.btnShow);
        spnTypes = findViewById(R.id.spnTypes);
        txtResult = findViewById(R.id.txtResult);
        BookDa bookDa = new BookDa();
        String[] types = bookDa.getBookTypes();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, types);
        spnTypes.setAdapter(adapter);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = spnTypes.getSelectedItem().toString();
                BookDa bookDa = new BookDa();
                List<Book> lstBooks = bookDa.getBooksByType(type);
                String str = "";
                for(Book b: lstBooks){
                    str+= b.getTitle() + "\n";
                }
                txtResult.setText(str);
            }
        });
    }
}