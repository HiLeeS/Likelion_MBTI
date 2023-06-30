package com.example.likelion_mbti.repository;

import com.example.likelion_mbti.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MbtiRepository extends JpaRepository<Mbti, Long> {

    @Override
    List<Mbti> findAll();

    List<Mbti> findByMbti(String mbti);
}
