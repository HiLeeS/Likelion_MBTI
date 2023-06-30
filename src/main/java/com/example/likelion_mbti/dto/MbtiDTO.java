package com.example.likelion_mbti.dto;

import com.example.likelion_mbti.entity.Mbti;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MbtiDTO {

    private Long id;
    private String mbti;
    private String info;

    public Mbti toMbti(){return new Mbti(null, mbti, info);}
}