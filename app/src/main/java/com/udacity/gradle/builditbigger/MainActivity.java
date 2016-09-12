package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JokesProvider;
import com.nunez.jokeexhibition.JokePresenter;


public class MainActivity extends AppCompatActivity {

  private JokesProvider jokesProvider;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void tellJoke(View view) {

//    Toast.makeText(this, jokesProvider.getJoke(), Toast.LENGTH_LONG).show();
//    Intent jokePresenterIntent = new Intent(this, JokePresenter.class);
//    jokePresenterIntent.putExtra(JokePresenter.EXTRA_JOKE, jokesProvider.getJoke());
//    startActivity(jokePresenterIntent);

//    new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    new EndpointsAsyncTask(new EndpointsAsyncTask.ResponseCallback() {
      @Override
      public void onSucces(String result) {
        Intent jokePresenterIntent = new Intent(MainActivity.this, JokePresenter.class);
        jokePresenterIntent.putExtra(JokePresenter.EXTRA_JOKE, result);
        startActivity(jokePresenterIntent);
      }
    });

  }


}
