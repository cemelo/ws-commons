package br.gov.siop.ws.rs

import javax.ws.rs.ClientErrorException
import javax.ws.rs.core.Context
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

/**
 * Provider used to report resource not found errors.
 *
 * @author Carlos Eduardo Melo
 * @since 1.0
 */
@Provider
class ClientErrorExceptionMapper implements ExceptionMapper<ClientErrorException> {

    @Context
    private HttpHeaders headers

    @Override
    Response toResponse(ClientErrorException exception) {
        Response.ResponseBuilder builder = Response.fromResponse(exception.response)

        if (headers.acceptableMediaTypes != null && !headers.acceptableMediaTypes.empty) {
            builder.type(headers.acceptableMediaTypes[0])
        } else {
            builder.type(headers.mediaType)
        }

        return builder.build()
    }
}
