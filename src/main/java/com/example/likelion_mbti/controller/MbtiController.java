package com.example.likelion_mbti.controller;

import com.example.likelion_mbti.dto.MbtiDTO;
import com.example.likelion_mbti.entity.Mbti;
import com.example.likelion_mbti.service.MbtiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MbtiController {

    @Autowired
    private MbtiService mbtiService;

    @GetMapping("/mbti")    //저장된 모든 MBTI 특징 조회
    public List<Mbti> index(){
        return mbtiService.index();
    }

    @GetMapping("/mbti/{mbti}")
    public Mbti getMbti(@PathVariable String mbti){
        Mbti newMbti = mbtiService.getMbti(mbti);
        return newMbti;
    }

    @PostMapping("/mbti")   //성공적으로 들어갔는지 repository의 반환값을 통해 service에서 0 or 1을 반환하도록 하기
    public Integer createInfo(@RequestBody MbtiDTO mbti){
        return mbtiService.createInfo(mbti);
    }

    @DeleteMapping("/mbti/{id}")    //entity로 받지 말고 service에서 끝내는 방식 고안해보기
    public void delete(@PathVariable Long id){
        Mbti mbti = mbtiService.deleteMbti(id);
    }

}
