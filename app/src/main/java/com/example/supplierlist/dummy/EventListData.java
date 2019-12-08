package com.example.supplierlist.dummy;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class EventListData extends AppCompatActivity {
  private Context context;

  public EventListData(Context context){this.context=context;}

    public static final List<com.example.supplierlist.dummy.EventListData> ITEMS = new ArrayList<com.example.supplierlist.dummy.EventListData>();

  public static class EventData{

      public String name;
      public String description;
      public String time;
      public String date;

      public EventData(String name, String description, String time, String date) {
          this.name = name;
          this.description = description;
          this.time = time;
          this.date = date;
      }

      @Override
      public String toString() {
          return name;
      }

  }
   }
