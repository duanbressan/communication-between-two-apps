package example.duan.sendingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button buttonSend = (Button) findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().equals("")){
                    Toast t = Toast.makeText(getApplicationContext(), "Adicione um texto!", Toast.LENGTH_SHORT);
                    t.show();
                }
                else{
                    send(editText.getText().toString());
                }
            }
        });
    }

    private void send(String text_to_send) {
        Intent sendIntent = new Intent();
        sendIntent.setClassName("example.duan.receiverapp", "example.duan.receiverapp.MainActivity");
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text_to_send);
        sendIntent.setType("text/plain");

        startActivity(sendIntent);
    }
}
