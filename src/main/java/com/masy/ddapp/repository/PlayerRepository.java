package com.masy.ddapp.repository;

import com.masy.ddapp.data.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {
}
