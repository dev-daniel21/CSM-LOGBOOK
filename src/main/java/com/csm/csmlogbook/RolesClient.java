package com.csm.csmlogbook;

import com.csm.csmlogbook.web.exceptions.ServiceNotAvailableException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RolesClient {

    private final RestTemplate restTemplate;

    public String getUserRoles(String userId) {

        String url = String.format("http://localhost:8315/roles/%s", userId);
        String userRole;
        try {
            userRole = restTemplate.getForObject(url, String.class);
        } catch (RestClientException exception) {
            throw new ServiceNotAvailableException("Authentication service not available");
        }
        return userRole;
    }
}
