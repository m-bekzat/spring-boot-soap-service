package kz.bekzat.springbootsoapservice.service;

import kz.bekzat.springbootsoapservice.repository.UserRepository;
import kz.bekzat.springbootsoapservice.user.UserDetailsRequest;
import kz.bekzat.springbootsoapservice.user.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://bekzat.kz/springbootsoapservice/user";

    private UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserDetailsRequest")
    @ResponsePayload
    public UserDetailsResponse getUser(@RequestPayload UserDetailsRequest request) {
        UserDetailsResponse response = new UserDetailsResponse();
        response.setUser(userRepository.findUser(request.getId()));
        return response;
    }
}
