package com.video

import com.google.inject.Guice
import com.google.inject.Injector
import com.video.config.StreamConfiguration
import com.video.resource.VideoResource
import io.dropwizard.Application
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.ResourceConfigurationSourceProvider
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class VideoApplication extends Application<StreamConfiguration> {

    static void main(String[] args) throws Exception {
        new VideoApplication().run(args)
    }

    @Override
    void run(StreamConfiguration configuration, Environment environment) throws Exception {
        Injector injector = Guice.createInjector(new VideoGuiceModule(configuration, environment))
        environment.jersey().register(injector.getInstance(VideoResource))
//        environment.jersey().register(new VideoResource())
    }

    @Override
    void initialize(Bootstrap<StreamConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(new ResourceConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)))
    }
}
