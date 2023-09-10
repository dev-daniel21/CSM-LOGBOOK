package com.csm.csmlogbook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RolesClient {

    private final RestTemplate restTemplate;

    public String getUserRoles(String userId) {

        String url = String.format("http://localhost:8315/roles/%s", userId);

        String userRole = restTemplate.getForObject(url, String.class);

        return userRole;
    }
}
