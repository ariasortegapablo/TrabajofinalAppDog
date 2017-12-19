package arias.pablo.empezando.lay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


       findActivity findclass=new findActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton lost = (ImageButton) findViewById(R.id.imageButtonPerdido);
        lost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , lostActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final ImageButton find = (ImageButton) findViewById(R.id.imageButtonEncontrado);
        find.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , findActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final ImageButton chat = (ImageButton) findViewById(R.id.imageButtonChat);
        chat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , chatActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final ImageButton losts= (ImageButton) findViewById(R.id.imageButtonPerdidos);
        losts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , lostsActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });
        final ImageButton finds = (ImageButton) findViewById(R.id.imageButtonEncontrados);
        finds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(MainActivity.this , findsActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });

    }





    }


