package com.example.likelion_mbti.service;

import com.example.likelion_mbti.dto.MbtiDTO;
import com.example.likelion_mbti.entity.Mbti;
import com.example.likelion_mbti.repository.MbtiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MbtiService {
    @Autowired
    private MbtiRepository mbtiRepository;

    public List<Mbti> index() {
        return mbtiRepository.findAll();
    }

    public Mbti getMbti(String mbti) {
        List<Mbti> listMbti = mbtiRepository.findByMbti(mbti);

        if(listMbti.size() == 0){
            return null;
        }
        else if(listMbti.size() == 1){
            return listMbti.get(0);
        }
        else{
            Collections.shuffle(listMbti);
            return listMbti.get(0);
        }
    }


    public int createInfo(MbtiDTO mbti) {
        Mbti mb = new Mbti(mbti.getMbti(), mbti.getInfo());
        if(mb.getMbti() == null || mb.getInfo() == null){
            return 1;
        }
        else {
            mbtiRepository.save(mb);
            return 0;
        }
    }

    public Mbti deleteMbti(Long id) {
        Mbti target = mbtiRepository.findById(id).orElse(null);
        //잘못된 요청 처리
        if(target == null){
            return null;
        }
        //대상 삭제
        mbtiRepository.delete(target);
        return target;
    }

}