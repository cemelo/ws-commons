package br.gov.siop.ws.rs.security

import javax.servlet.http.HttpServletRequest
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.PreMatching
import javax.ws.rs.core.Context

@PreMatching
class AuthenticationFilter implements ContainerRequestFilter {

    @Context
    private HttpServletRequest request

    @Override
    void filter(ContainerRequestContext requestContext) throws IOException {
        // Busca o certificado
        // Se não tiver, busca as informações de usuário e senha no header
    }
}
