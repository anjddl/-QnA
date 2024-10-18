package com.market.apple.domain.levelup.service;


import com.market.apple.domain.levelup.entity.Levelup;
import com.market.apple.domain.levelup.repository.LevelupRepository;
import com.market.apple.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LevelupService {
    private final LevelupRepository levelupRepository;
    public Levelup create(String title, String content, boolean isNotice, Member member) {
        Levelup levelup = new Levelup();
        levelup.setTitle(title);
        levelup.setContent(content);
        levelup.setMember(member);


        return this.levelupRepository.save(levelup);
    }

    public List<Levelup> getList() {
        return this.levelupRepository.findAll();
    }
}
