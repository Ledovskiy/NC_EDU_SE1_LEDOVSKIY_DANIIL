package fapi.web.controller;

import fapi.client.WalletsClient;
import fapi.dto.WalletsDto;
import fapi.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fapi/v1/wallets")
public class WalletsController {


    private final WalletsClient walletsClient;

    @Autowired
    public WalletsController(WalletsClient walletsClient) {
        this.walletsClient = walletsClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletsDto> getWallet(@PathVariable("id") Long id) throws NotFoundException {
        WalletsDto walletsDto = walletsClient.getWalletById(id);
        return new ResponseEntity<>(walletsDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<WalletsDto[]> getWallets() {
        WalletsDto[] walletsDto = walletsClient.getWallets();
        return new ResponseEntity<>(walletsDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WalletsDto> saveWallet(@RequestBody WalletsDto walletsDto) {
        WalletsDto savedWalletsDto = walletsClient.saveWallet(walletsDto);
        return new ResponseEntity<>(savedWalletsDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalletsDto> updateWallet(@PathVariable("id") Long id, @RequestBody WalletsDto walletsDto) {
        WalletsDto updatedWalletsDto = walletsClient.putWallet(id, walletsDto);
        return new ResponseEntity<>(updatedWalletsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteWallet(@PathVariable Long id) throws NotFoundException {
        walletsClient.deleteWallet(id);
    }
}
