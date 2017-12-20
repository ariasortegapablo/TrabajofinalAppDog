package arias.pablo.empezando.lay;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import arias.pablo.empezando.lay.adapters.FindsAdapter;
import arias.pablo.empezando.lay.models.Find;

public class findsActivity extends AppCompatActivity {

    private RecyclerView findsRecyclerView;
    private FindsAdapter findsAdapter;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finds);


        findsRecyclerView = (RecyclerView) findViewById(R.id.findsRecyclerView);
        findsRecyclerView.setHasFixedSize(true);
        findsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findsAdapter = new FindsAdapter(this);
        findsRecyclerView.setAdapter(findsAdapter);

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

                            findsAdapter.clear();

                            for (DocumentSnapshot document : task.getResult()) {

                                String name = document.getString("name");
                                String flagURL = document.getString("flagURL");

                                Find f = new Find(name, flagURL);

                                findsAdapter.addFind(f);

                            }

                        } else {

                        }
                    }
                });

    }



}
