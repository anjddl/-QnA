package com.market.apple.domain.levelup.repository;

import com.market.apple.domain.levelup.entity.Levelup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelupRepository extends JpaRepository<Levelup, Long> {
}
