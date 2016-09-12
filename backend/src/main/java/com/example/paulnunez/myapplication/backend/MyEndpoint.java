/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.paulnunez.myapplication.backend;

import com.example.JokesProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v3",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.paulnunez.example.com",
    ownerName = "backend.myapplication.paulnunez.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
//    @ApiMethod(name = "sayHi")
//    public MyBean sayHi(@Named("name") String name) {
//        MyBean response = new MyBean();
//        response.setData("Hi, " + name);
//        return response;
//    }

    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        response.setData(JokesProvider.getJoke());
        return response;
    }
}
