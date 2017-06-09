package com.video.provider

import spock.lang.Specification

class VideoProviderTest extends Specification {
    void "should return cloudfront url"() {
        given:
//      String url = "http://http://d2fhamibhu70ff.cloudfront.net/"
        String url = "https://s3.amazonaws.com/chinmaya-pilot-videos/"
        VideoProvider videoProvider = new VideoProvider(url)

        when:
        String cdnUrl = videoProvider.getCloudFrontUrl()

        then:
        !cdnUrl.isEmpty()
    }

    void "should return previous cloudfront url"() {
        given:
        String url = "https://s3.amazonaws.com/chinmaya-pilot-videos/"
        VideoProvider videoProvider = new VideoProvider(url)

        when:
        String cdnUrl = videoProvider.getPreviousUrl(1)

        then:
        !cdnUrl.isEmpty()
    }
}
