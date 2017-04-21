package com.video

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.google.inject.name.Names
import com.video.config.StreamConfiguration
import com.video.provider.VideoProvider
import io.dropwizard.setup.Environment

class VideoGuiceModule extends AbstractModule {
    private final StreamConfiguration configuration
    private final Environment environment

    VideoGuiceModule(final StreamConfiguration configuration, final Environment environment) {
        this.configuration = configuration
        this.environment = environment
    }

//    @Provides
//    VideoProvider prepareVideoProvider() {
//        new VideoProvider(configuration.cdnUrl)
//    }


    protected void configure() {
        bind(StreamConfiguration).toInstance(configuration)
        bindConstant().annotatedWith(Names.named('cdnUrl')).to(configuration.cdnUrl)
    }
}
