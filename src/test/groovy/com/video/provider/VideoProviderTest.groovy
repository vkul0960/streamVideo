package com.video.provider

import spock.lang.Specification

class VideoProviderTest extends Specification {
    void "should return cloudfront url"() {
        given:
        String url = "http://http://d2fhamibhu70ff.cloudfront.net/"
        VideoProvider videoProvider = new VideoProvider(url)

        when:
        String cdnUrl = videoProvider.getCloudFrontUrl()

        then:
        !cdnUrl.isEmpty()
    }
}
