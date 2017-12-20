package arias.pablo.empezando.lay;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import arias.pablo.empezando.lay.adapters.LostsAdapter;
import arias.pablo.empezando.lay.models.Lost;


public class lostsActivity extends AppCompatActivity {


    private RecyclerView lostsRecyclerView;
    private LostsAdapter lostsAdapter;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losts);

       // lostsRecyclerView = (RecyclerView) findViewById(R.id.lostsRecyclerView);
        lostsRecyclerView.setHasFixedSize(true);
        lostsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        lostsAdapter = new LostsAdapter(this);
        lostsRecyclerView.setAdapter(lostsAdapter);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();



        loadData();

    }

    private void loadData() {

        db.collection("countries")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            lostsAdapter.clear();

                            for (DocumentSnapshot document : task.getResult()) {

                                String name = document.getString("name");
                                String flagURL = document.getString("flagURL");

                                Lost f = new Lost(name, flagURL);

                                lostsAdapter.addLost(f);

                            }

                        } else {

                        }
                    }
                });

    }

}
