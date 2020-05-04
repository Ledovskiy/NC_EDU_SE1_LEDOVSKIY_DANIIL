package fapi.client;

import fapi.dto.RoleDto;
import fapi.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoleClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HttpHeaders headers = new HttpHeaders();

    private final String rolesUrl = "http://localhost:8081/api/v1/roles";

    public RoleDto[] getRoles() {
        ResponseEntity<RoleDto[]> response = restTemplate.getForEntity(this.rolesUrl, RoleDto[].class);
        return response.getBody();
    }

    public void deleteRole(Long id) throws NotFoundException {
        restTemplate.delete(this.rolesUrl + "/" + id, RoleDto.class);
    }

    public RoleDto saveRole(RoleDto roleDto) {
        HttpEntity<RoleDto> entity = new HttpEntity<>(roleDto, this.headers);
        return this.restTemplate.exchange(this.rolesUrl, HttpMethod.POST, entity, RoleDto.class).getBody();
    }

    public RoleDto putRole(Long id, RoleDto roleDto) {
        HttpEntity<RoleDto> entity = new HttpEntity<>(roleDto, this.headers);
        return this.restTemplate.exchange(this.rolesUrl + "/" + id, HttpMethod.PUT, entity, RoleDto.class).getBody();
    }

    public RoleDto getRoleById(Long id) {
        return this.restTemplate.getForObject(this.rolesUrl +  "/" + id, RoleDto.class);
    }
}
