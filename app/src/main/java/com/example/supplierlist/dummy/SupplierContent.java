package com.example.supplierlist.dummy;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample description for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class SupplierContent extends AppCompatActivity {

    //    Database COnnection
    private Context context;

    public SupplierContent(Context context) {
        this.context = context;
    }

//    private static int[] idList = {1, 2, 3, 4, 5, 7, 6, 8, 9, 10};
//    private static String[] Name = {"Rock Weiger", "Cate Nason", "Fidel Gruner", "Augustine Goldfinger", "Whitney Riccardi", "Arluene Cezeaux", "Salvador Gulley", "Adorne Antos", "Rosco Unamuno", "Arielle Du boux"};
//    private static int Contact[] = {394830313, 634000991, 607304897, 378193857, 938308368, 428483146, 563207913, 589358978, 378193857, 938306368};
//    private static String[] Email = {"HulkingG@gmail.com", "Succinct@gmail.com", "Grumpy@gmail.com", "Waggish@gmail.com", "Little@gmail.com", "Telling@gmail.com", "Obtainable@gmail.com", "Coherent@gmail.com", "Red@gmail.com", "Marked@gmail.com"};
//    private static  String[] supplierNames={"Conall","Kaydee","Kylan","Jevan","Zain","Austin","Callum","Bryson","Heena","Aoife"};
    /**
     * An array of sample (dummy) items.
     */
    public static final List<Supplier> ITEMS = new ArrayList<Supplier>();


//    private static final int COUNT = 10;

//    static {
//        // Add some sample items.
//        for (int i = 0; i <= COUNT - 1; i++) {
//            addItem(createDummyItem(idList[i], Name[i], Contact[i], Email[i]));
//        }
//    }


//    private static void addItem(Supplier item) {
//        ITEMS.add(item);
//    }

//    private static Supplier createDummyItem(int id, String name, int Contact, String email) {
//        return new Supplier("ID :- " + id, "Name :- " + name, "Contact :- " + Contact, "Email :- " + email);
//    }


    /**
     * A dummy item representing a piece of description.
     */
    public static class Supplier {

        public final String id;
        public final String name;
        public final String contact;
        public final String email;

        public Supplier(String id, String name, String Contact, String email) {

            this.id = id;
            this.name = name;
            this.contact = Contact;
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getContact() {
            return contact;
        }

        public String getEmail() {
            return email;
        }
    }
}