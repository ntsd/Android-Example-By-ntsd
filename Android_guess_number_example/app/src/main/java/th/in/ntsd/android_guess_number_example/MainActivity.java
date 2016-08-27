package th.in.ntsd.android_guess_number_example;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView guessNumberView;
    public TextView textGuessRange;
    int real_number = 0;
    int guessNumber = 0;
    int number_min = 0; //min number
    int number_max = 100; //max number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        real_number = randomNumberRange(number_min, number_max); //real number
        guessNumber = randomNumberRange(number_min, number_max); //start number to guess
        Log.d("number", "random_real_number = "+real_number + "  guessNumber = "+guessNumber);

        textGuessRange = (TextView) findViewById(R.id.text_guess_show_range); //set first text range
        textGuessRange.setText("Guess the number in"+number_min+"-"+number_max);

        guessNumberView = (TextView) findViewById(R.id.guessnumber);
        guessNumberView.setText(""+guessNumber);

        Button less_button = (Button) findViewById(R.id.button_less);
        less_button.setOnClickListener(new less_Onclick());

        Button equal_button = (Button) findViewById(R.id.button_equal);
        equal_button.setOnClickListener(new equal_Onclick());

        Button greater_button = (Button) findViewById(R.id.button_greater);
        greater_button.setOnClickListener(new greater_Onclick());
    }

    private int randomNumberRange(int range_min, int range_max){
        Random r = new Random();
        return range_min + r.nextInt(range_max-range_min);
    }

    private class less_Onclick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if(real_number < guessNumber){
                show_dialog("Yes the number less than "+guessNumber);

                number_max = guessNumber-1;
                guessNumber = randomNumberRange(number_min, number_max);

                guessNumberView.setText(""+guessNumber);
                textGuessRange.setText("Guess the number in"+number_min+"-"+number_max);
            }
            else {
                show_dialog("No try again");
            }
        }
    }

    private class equal_Onclick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if(real_number == guessNumber){
                show_dialog("Congratulation the number equal with "+guessNumber);
            }
            else {
                show_dialog("No try again");
            }
        }
    }

    private class greater_Onclick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if(real_number > guessNumber){
                show_dialog("Yes the number greather than "+guessNumber);

                number_min = guessNumber+1;
                guessNumber = randomNumberRange(number_min, number_max);

                guessNumberView.setText(""+guessNumber);
                textGuessRange.setText("Guess the number in"+number_min+"-"+number_max);
            }
            else {
                show_dialog("No try again");
            }
        }
    }

    void show_dialog(String text){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(text);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
