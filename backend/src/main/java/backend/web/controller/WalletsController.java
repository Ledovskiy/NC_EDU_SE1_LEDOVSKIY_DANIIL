package backend.web.controller;

import backend.dto.WalletsDto;
import backend.entity.Wallets;
import backend.exeption.NotFoundException;
import backend.mapper.WalletsMapper;
import backend.service.WalletsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/wallets")
public class WalletsController {

    private final WalletsService walletsService;
    private final WalletsMapper mapper;

    @Autowired
    public WalletsController(WalletsService walletsService, WalletsMapper mapper) {
        this.walletsService = walletsService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletsDto> getWallets(@PathVariable("id") Long id) throws NotFoundException {
        Wallets wallets = walletsService.getWallet(id);
        WalletsDto walletsDto = mapper.toDto(wallets);
        return new ResponseEntity<>(walletsDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<WalletsDto>> getWallets() {
        List<Wallets> wallets = walletsService.getWallets();
        List<WalletsDto> walletsDto = wallets.stream().map((mapper::toDto)).collect(Collectors.toList());
        return new ResponseEntity<>(walletsDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WalletsDto> saveWallets(@RequestBody WalletsDto walletsDto) {
        Wallets wallets = mapper.toEntity(walletsDto);
        Wallets savedWallets = walletsService.saveWallet(wallets);
        WalletsDto savedWalletsDto = mapper.toDto(savedWallets);
        return new ResponseEntity<>(savedWalletsDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalletsDto> updateWallets(@PathVariable("id") Long id, @RequestBody WalletsDto walletsDto) {
        Wallets wallets = mapper.toEntity(walletsDto);
        Wallets updatedWallets = walletsService.updateWallet(id, wallets);
        WalletsDto updatedWalletsDto = mapper.toDto(updatedWallets);
        return new ResponseEntity<>(updatedWalletsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WalletsDto> deleteWallets(@PathVariable("id") Long id) throws NotFoundException {
        this.walletsService.deleteWallet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<WalletsDto> deleteWallets() {
        this.walletsService.deleteWallets();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
