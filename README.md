# Build it bigger

This project demonstrate an app with multiple flavors that uses
multiple library modules, a banner ad and Google Could Endpoints.

## Description
The app consist in four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## On this project
* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server
