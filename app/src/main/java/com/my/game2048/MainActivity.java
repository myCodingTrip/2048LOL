package com.my.game2048;


import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
    GameView gameView;

    public MainActivity() {
        mainactivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvScore = (TextView) findViewById(R.id.tvScore);
        gameView = (GameView) findViewById(R.id.gameView);
        animLayer = (AnimLayer) findViewById(R.id.animLayer);
        tvBestScore = (TextView) findViewById(R.id.tvBestScore);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.start) {
            gameView.startGame();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clearScore() {
        score = 0;
        showScore();
    }

    public void showScore() {
        tvScore.setText(score + "");
    }

    public void addScore(int s) {
        score += s;
        showScore();
        int maxScore = Math.max(score, getBestScore());
        saveBestScore(maxScore);
        showBestScore(maxScore);
    }

    //利用SharedPreferences长期存储bestScore
    public void saveBestScore(int s) {
        Editor e = getPreferences(MODE_PRIVATE).edit();
        e.putInt(SP_KEY_BEST_SCORE, s);
        e.commit();
    }

    public int getBestScore() {
        return getPreferences(MODE_PRIVATE).getInt(SP_KEY_BEST_SCORE, 0);
    }

    public void showBestScore(int s) {
        tvBestScore.setText(s + "");
    }

    public AnimLayer getAnimLayer() {
        return animLayer;
    }

    private int score = 0;
    private TextView tvScore;
    private TextView tvBestScore;
    private static MainActivity mainactivity = null;
    private AnimLayer animLayer = null;

    public static MainActivity getMainActivity() {
        return mainactivity;
    }

    public static final String SP_KEY_BEST_SCORE = "bestScore";
}
