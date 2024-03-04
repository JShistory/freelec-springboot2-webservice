package com.study.freelecspringboot2webservice.web.dto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    public void �Һ�_���_�׽�Ʈ(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);
        assertEquals(dto.getName(),name);
        assertEquals(dto.getAmount(), amount);
    }
}