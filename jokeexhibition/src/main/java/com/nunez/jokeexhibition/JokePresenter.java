package com.nunez.jokeexhibition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokePresenter extends AppCompatActivity {

  public static final String EXTRA_JOKE = "extra_joke";

  private TextView jokeText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke_presenter);

    jokeText = (TextView) findViewById(R.id.txt_joke);

    Intent intent = getIntent();
    if (intent != null){
      String joke = getIntent().getStringExtra(EXTRA_JOKE);
      jokeText.setText(joke);
    }
  }
}
