package com.video.provider

import com.google.inject.Inject
import com.google.inject.name.Named
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class VideoProvider {

    final String url

    @Inject
    VideoProvider(@Named("cdnUrl") String url) {
        this.url = url
    }

    String getCloudFrontUrl() {
        DateTime dateTime = new DateTime(DateTimeZone.forID("America/Chicago"))
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
        String bucket= formatter.print(dateTime)
//      url + bucket + "/gita.mp4"
        url + bucket + "/story_html5.html"
    }

    String getPreviousUrl(int day) {
        DateTime dateTime = new DateTime(DateTimeZone.forID("America/Chicago"))
        DateTime previousDateTime = dateTime.minusDays(day)
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
        String bucket = formatter.print(previousDateTime)
        url + bucket + "/story_html5.html"
    }
}
