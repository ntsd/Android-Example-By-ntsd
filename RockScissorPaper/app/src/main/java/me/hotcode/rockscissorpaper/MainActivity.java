package me.hotcode.rockscissorpaper;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int RC_SIGNIN = 1;
    TextView main_name;
    Button rockbut;
    Button paperbut;
    Button scissorbut;
    List<String> result;
    List<String> RPS;
    TextView recent;
    int win = 0;
    int draw = 0;
    int lose = 0;
    TextView score;
    String name = "";
    ImageView playerImageview;
    ImageView botImageview;
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(400, 400);

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request it is that we're responding to
        if (requestCode == RC_SIGNIN) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String yourname = data.getStringExtra("name");
                name = yourname;
                main_name.append(yourname);
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Signin.class);
//        startActivity(intent);
        startActivityForResult(intent, RC_SIGNIN);
        main_name = (TextView) findViewById(R.id.main_name);
        recent = (TextView) findViewById(R.id.recent);
        rockbut = (Button) findViewById(R.id.rockbut);
        rockbut.setOnClickListener(this);
        paperbut = (Button) findViewById(R.id.paperbut);
        paperbut.setOnClickListener(this);
        scissorbut = (Button) findViewById(R.id.scissorbut);
        scissorbut.setOnClickListener(this);
        RPS = new ArrayList<String>();
        RPS.add("ROCK");
        RPS.add("PAPER");
        RPS.add("SCISSOR");
        result = new ArrayList<String>();
        score = (TextView) findViewById(R.id.score);
        playerImageview = (ImageView) findViewById(R.id.playerimageview);
        botImageview = (ImageView) findViewById(R.id.botimageview);
    }

    @Override
    public void onClick(View view) {
        if(view == (View)findViewById(R.id.rockbut)){
            playerImageview.setImageResource(R.drawable.rock);
            if(ranRPS() == "ROCK"){//draw
                result.add("ROCK"+":"+"ROCK");
                draw+=1;
                dialog("Draw");
                botImageview.setImageResource(R.drawable.rock);
            }
            else if(ranRPS() == "SCISSOR"){//win
                result.add("ROCK"+":"+"SCISSOR");
                win+=1;
                dialog("You Win");
                botImageview.setImageResource(R.drawable.scissor);
            }
            else{//lose
                result.add("ROCK"+":"+"PAPER");
                lose+=1;
                dialog("You Lose");
                botImageview.setImageResource(R.drawable.paper);
            }
        }else if(view == findViewById(R.id.paperbut)){
            playerImageview.setImageResource(R.drawable.paper);
            if(ranRPS() == "ROCK"){//win
                result.add("PAPER"+":"+"ROCK");
                win+=1;
                dialog("You Win");
                botImageview.setImageResource(R.drawable.rock);
            }
            else if(ranRPS() == "SCISSOR"){//draw
                result.add("PAPER"+":"+"SCISSOR");
                lose+=1;
                dialog("You Lose");
                botImageview.setImageResource(R.drawable.scissor);
            }
            else{//lose
                result.add("PAPER"+":"+"PAPER");
                draw+=1;
                dialog("Draw");
                botImageview.setImageResource(R.drawable.paper);
            }
        }else if(view == findViewById(R.id.scissorbut)){
            playerImageview.setImageResource(R.drawable.scissor);
            if(ranRPS() == "ROCK"){//lose
                result.add("SCISSOR"+":"+"ROCK");
                lose+=1;
                dialog("You Lose");
                botImageview.setImageResource(R.drawable.rock);
            }
            else if(ranRPS() == "SCISSOR"){//win
                result.add("SCISSOR"+":"+"SCISSOR");
                draw+=1;
                dialog("Draw");
                botImageview.setImageResource(R.drawable.scissor);
            }
            else{//draw
                result.add("SCISSOR"+":"+"PAPER");
                win+=1;
                dialog("You Win");
                botImageview.setImageResource(R.drawable.paper);
            }
        }
        update_result();
        playerImageview.setLayoutParams(layoutParams);
        botImageview.setLayoutParams(layoutParams);
    }

    String ranRPS(){
        Random ran = new Random();
        int x = ran.nextInt(3);
        //return RPS.get((int)Math.random()%3);
        return RPS.get(x);

    }

    void update_result(){
        recent.setText("Recent"+result.toString());
        score.setText("Score: "+name+" Win:"+win+" Lose:"+lose+" Draw:"+draw);
    }

    void dialog(String msg){
        new AlertDialog.Builder(this)
                .setTitle(msg)
                .show();
    }

    RotateAnimation animationRPS(){
        RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
        anim.setInterpolator(new LinearInterpolator());
        //anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);
        return anim;
    }
}
