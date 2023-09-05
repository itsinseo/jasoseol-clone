package com.itsinseo.jasoseolclone.user;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomAnimalNickname {
    private final String[] adjectives = {
            "활기찬", "행복한", "유쾌한", "화가난", "우울한", "불만스러운",
            "차분한", "무뚝뚝한", "냉정한", "괴상한", "용감한", "욕심쟁이",
            "은밀한", "비밀스러운", "빛나는"
    };

    private final String[] animals = {
            "고양이", "강아지", "팬더", "뱀", "코뿔소", "상어",
            "거북이", "오리", "호랑이", "오소리", "곰", "여우",
            "펭귄", "앵무새", "바다거북"
    };

    Random random = new Random();

    public String generateRandomNickname() {
        return adjectives[random.nextInt(adjectives.length)] +
                ' ' +
                animals[random.nextInt(animals.length)];
    }
}