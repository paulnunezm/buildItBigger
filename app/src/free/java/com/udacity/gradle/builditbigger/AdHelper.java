package com.udacity.gradle.builditbigger;

import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by paulnunez on 9/12/16.
 */
public class AdHelper {

  public AdHelper() {

  }

  public void prepareAd(View root) {
    AdView mAdView = (AdView) root.findViewById(R.id.adView);

    // Create an ad request. Check logcat output for the hashed device ID to
    // get test ads on a physical device. e.g.
    // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
    AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // physical device
        .addTestDevice("ABCDEF012345") // emulator
        .build();
    mAdView.loadAd(adRequest);
  }

}
