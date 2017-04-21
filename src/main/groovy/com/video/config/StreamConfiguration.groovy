package com.video.config

import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

class StreamConfiguration extends Configuration {
    @NotEmpty
    String cdnUrl
}
