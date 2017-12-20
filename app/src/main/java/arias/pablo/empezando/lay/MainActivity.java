package arias.pablo.empezando.lay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button lost = (Button) findViewById(R.id.ButtonPerdido);
        lost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , lostActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final Button find = (Button) findViewById(R.id.ButtonEncontrado);
        find.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , findActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final Button chat = (Button) findViewById(R.id.ButtonChat);
        chat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , chatActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final Button losts= (Button) findViewById(R.id.ButtonPerdidos);
        losts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , lostsActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final Button finds = (Button) findViewById(R.id.ButtonEncontrados);
        finds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , findsActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });

              /////////////////////////////////Seperacion
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


       verifyUser();
    }



    public void verifyUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser == null) {
            goLogInScreen();
        }
    }

    private void goLogInScreen() {
        Intent intent = new Intent(MainActivity.this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        MainActivity.this.startActivity(intent);
    }


}


