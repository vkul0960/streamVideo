package com.video.resource

import com.google.inject.Inject
import com.video.provider.VideoProvider

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/v1/stream")
class VideoResource {
    @Inject
    VideoProvider videoProvider

    @GET
    def streamVideo() {
        String cdnUrl = videoProvider.getCloudFrontUrl()
        URI location = new URI(cdnUrl)
        Response.temporaryRedirect(location).build()
    }
}
