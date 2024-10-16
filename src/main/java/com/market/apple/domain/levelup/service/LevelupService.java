package com.market.apple.domain.levelup.service;


import com.market.apple.domain.levelup.repository.LevelupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LevelupService {
    private final LevelupRepository levelupRepository;

}
