package com.masy.ddapp.repository;

import com.masy.ddapp.data.model.Player;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, String> {


////    @Query(" select count(p) from Player p where p.name = :name")
    long countByName(String name);
}
