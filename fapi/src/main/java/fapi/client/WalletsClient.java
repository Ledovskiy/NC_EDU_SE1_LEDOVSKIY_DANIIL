package fapi.client;

import fapi.dto.WalletsDto;
import fapi.exeption.NotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WalletsClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HttpHeaders headers = new HttpHeaders();

    private final String walletsUrl = "http://localhost:8081/api/v1/wallets";

    public WalletsDto[] getWallets() {
        ResponseEntity<WalletsDto[]> response = restTemplate.getForEntity(this.walletsUrl, WalletsDto[].class);
        return response.getBody();
    }

    public void deleteWallet(Long id) throws NotFoundException {
        restTemplate.delete(this.walletsUrl + "/" + id, WalletsDto.class);
    }

    public WalletsDto saveWallet(WalletsDto walletsDto) {
        HttpEntity<WalletsDto> entity = new HttpEntity<>(walletsDto, this.headers);
        return this.restTemplate.exchange(this.walletsUrl, HttpMethod.POST, entity, WalletsDto.class).getBody();
    }

    public WalletsDto putWallet(Long id, WalletsDto walletsDto) {
        HttpEntity<WalletsDto> entity = new HttpEntity<>(walletsDto, this.headers);
        return this.restTemplate.exchange(this.walletsUrl + "/" + id, HttpMethod.PUT, entity, WalletsDto.class).getBody();
    }

    public WalletsDto getWalletById(Long id) {
        return this.restTemplate.getForObject(this.walletsUrl +  "/" + id, WalletsDto.class);
    }
}
