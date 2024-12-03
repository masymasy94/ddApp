package com.masy.ddapp.controller;

import com.masy.ddapp.data.dto.PlayerDto;
import com.masy.ddapp.service.PlayerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping(value = "player", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("all")
    public List<PlayerDto> getAllPlayers() {
        return playerService.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertPlayer(@Valid @RequestBody PlayerDto dto) {

        String name = playerService.savePlayer(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", name)
                .build();
    }

    @DeleteMapping("{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 empty body or 404
    public void deleteDevice(@PathVariable("name") String name) {
        playerService.deletePlayer(name);
    }


}
