package com.example.aptivist_u002.a11052017mediasample;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;

public class ExoPlayerActivity extends AppCompatActivity {

    private static final Uri VIDEO_URI = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
    private SimpleExoPlayerView simpleExoPlayerView;
    private SimpleExoPlayer simpleExoPlayer;

    private DefaultBandwidthMeter bandwidthMeter;
    private TrackSelection.Factory selectionFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);

        simpleExoPlayerView = findViewById(R.id.a_exo_player);

        //1.-Setup the Bandwidth meter
        bandwidthMeter = new DefaultBandwidthMeter();
        //2.-Setup the track Selection
        selectionFactory = new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        //3.-Create the Exoplayer with the selectionFactory created
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this,
                new DefaultTrackSelector(selectionFactory), new DefaultLoadControl());
        //4.-Setting the view for the exoPLayer
        simpleExoPlayerView.setPlayer(simpleExoPlayer);
        //5.-Set data source
        String userAgent = Util.getUserAgent(this, getString(R.string.app_name));
        HttpDataSource.Factory httpDataSourceFactory = new
                DefaultHttpDataSourceFactory(userAgent);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, bandwidthMeter, httpDataSourceFactory);

        //6.-Setup the media source
        MediaSource mediaSource = new ExtractorMediaSource(VIDEO_URI, dataSourceFactory,
                new DefaultExtractorsFactory(),new Handler(), null);

        //7.- Prepare to play ExoPLayer
        simpleExoPlayer.prepare(mediaSource);
    }

}
