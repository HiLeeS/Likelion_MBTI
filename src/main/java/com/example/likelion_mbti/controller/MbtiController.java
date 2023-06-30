package com.example.likelion_mbti.controller;

import com.example.likelion_mbti.dto.MbtiDTO;
import com.example.likelion_mbti.entity.Mbti;
import com.example.likelion_mbti.service.MbtiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MbtiController {

    @Autowired
    private MbtiService mbtiService;

    @GetMapping("/mbti")    //저장된 모든 MBTI 특징 조회
    public List<Mbti> index(){
        return mbtiService.index();
    }

    @GetMapping("/mbti/{mbti}")     //특정 MBTI의 특징 랜덤 추출, return 타입을 String으로 바꾸고 특징을 보낼 때 특징이 있으면 toString으로, 없으면 문자열로 없음 문자 보내기
    public Mbti getMbti(@PathVariable String mbti){
        Mbti newMbti = mbtiService.getMbti(mbti);
        if(newMbti == null) return null;
        
        return newMbti;
    }

    @PostMapping("/mbti")   //성공적으로 들어갔는지 repository의 반환값을 통해 service에서 0 or 1을 반환하도록 하기
    public int createInfo(@RequestBody MbtiDTO mbti){
        int check = mbtiService.createInfo(mbti);
        if(check == 1) return 1;
        return 0;
    }

    @DeleteMapping("/mbti/{id}")    //entity로 받지 말고 service에서 끝내는 방식 고안해보기
    public void delete(@PathVariable Long id){
        Mbti mbti = mbtiService.deleteMbti(id);
    }

}
