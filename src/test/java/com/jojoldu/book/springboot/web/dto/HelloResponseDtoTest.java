package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class HelloResponseDtoTest {

    @Test
    public void test() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //assertj
        //assertThat(dto.getName()).isEqualTo(name);
        //assertThat(dto.getAmount()).isEqualTo(amount);

        //junit
        assertEquals("test", dto.getName());
        assertEquals(1000, dto.getAmount());
    }
}
