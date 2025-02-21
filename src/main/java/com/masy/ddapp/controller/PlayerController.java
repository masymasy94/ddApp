package com.masy.ddapp.controller;

import com.masy.ddapp.data.dto.PlayerDto;
import com.masy.ddapp.service.player.PlayerDeleteService;
import com.masy.ddapp.service.player.PlayerFindAllService;
import com.masy.ddapp.service.player.PlayerSaveService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(value = "players", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    private final PlayerFindAllService playerFindAllService;
    private final PlayerDeleteService playerDeleteService;
    private final PlayerSaveService playerSaveService;

    // 200
    @GetMapping()
    public List<PlayerDto> getAllPlayers() {
        return playerFindAllService.findAll();
    }

    // 201 or 400 validation
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertPlayer(@Valid @RequestBody PlayerDto dto) {

        String name = playerSaveService.savePlayer(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", name)
                .build();
    }

    // 204 empty body or 404
    @DeleteMapping("{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice(@PathVariable("name") String name) {
        playerDeleteService.deletePlayer(name);
    }


}
