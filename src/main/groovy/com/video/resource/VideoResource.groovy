package com.video.resource

import com.google.inject.Inject
import com.video.provider.VideoProvider

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
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

    @GET
    @Path('/{day}')
    def streamPreviousVideo(@PathParam('day') int day) {
        String cdnUrl = videoProvider.getPreviousUrl(day)
        URI location = new URI(cdnUrl)
        Response.temporaryRedirect(location).build()
    }
}
