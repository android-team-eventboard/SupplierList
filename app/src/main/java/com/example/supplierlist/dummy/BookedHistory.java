package com.example.supplierlist.dummy;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class BookedHistory extends AppCompatActivity {
    private Context context;

    public BookedHistory(Context context){this.context=context;}

    public static final List<com.example.supplierlist.dummy.BookedHistory> ITEMS = new ArrayList<BookedHistory>();

    public static class BookedData{
        public String name;
        public String description;
        public String time;
        public String date;


        public BookedData( String name, String description, String time, String date) {
            this.name = name;
            this.description = description;
            this.time = time;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
