package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.paulnunez.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Snippet from the appEngine template
 * @link https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */
class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
  private static final String TAG = "EndpointsAsyncTask";
  private static MyApi myApiService = null;
  private Context context;
  private ResponseCallback response;

  public EndpointsAsyncTask( ResponseCallback callback){

    this.response = callback;
    execute();
  }

  public interface ResponseCallback {
     void onSucces(String result);
  }

  @Override
  protected String doInBackground(Void... params) {

    if(myApiService == null) {  // Only do this once
      MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
          new AndroidJsonFactory(), null)
          // options for running against local devappserver
          // - 10.0.2.2 is localhost's IP address in Android emulator
          // - turn off compression when running against local devappserver
          .setRootUrl("http://10.0.2.2:8080/_ah/api/")
          .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
              abstractGoogleClientRequest.setDisableGZipContent(true);
            }
          });
      // end options for devappserver



      myApiService = builder.build();
    }

//    context = params[0].first;
//    String name = params[0].second;

    try {
      return myApiService.tellJoke().execute().getData();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  @Override
  protected void onPostExecute(String result) {
//    Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    response.onSucces(result);
  }

}