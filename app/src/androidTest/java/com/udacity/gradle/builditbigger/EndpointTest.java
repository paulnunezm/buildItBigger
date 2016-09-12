package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

/**
 * Created by paulnunez on 9/11/16.
 */
public class EndpointTest extends AndroidTestCase {

  /**
   * This test that the asynctask that request a joke from the gce backend
   * doesn't return null.
   *
   * NOTE: For this, as we are using multidex had to change the
   * Specific Instrumentation Runner to "com.android.test.runner.MultiDexTestRunner"
   * in Run -> Edit Configurations
   */
  public void testAEndpointReturnsNonEmptyJoke(){
    new EndpointsAsyncTask(new EndpointsAsyncTask.ResponseCallback() {
      @Override
      public void onSucces(String result) {
        assertTrue(!result.isEmpty());
      }
    });
  }
}
