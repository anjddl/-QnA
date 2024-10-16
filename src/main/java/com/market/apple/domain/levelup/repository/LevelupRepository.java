package com.market.apple.domain.levelup.repository;

import com.market.apple.domain.levelup.entity.Levelup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelupRepository extends JpaRepository<Levelup, Long> {
}
