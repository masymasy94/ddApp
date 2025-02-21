package com.masy.ddapp.repository;

import com.masy.ddapp.data.model.MagicItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagicItemRepository extends JpaRepository<MagicItem, String> {
}
