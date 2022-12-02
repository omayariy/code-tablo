package com.example.todolist;

import com.example.todolist.entity.Code;
import com.example.todolist.service.CodeService;
import com.example.todolist.service.CodeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.*;

@SpringBootTest
class CodeApplicationTests {
    @Autowired
    private CodeServiceImpl codeServiceImpl;
    private final Code code = new Code();

    @Test
    public void testCode() {
        code.setCode("a0a0a0");
        String stringNextCode = codeServiceImpl.getNextCode(code);
        Assertions.assertEquals(stringNextCode, "a0a0a1");
    }

    @Test
    public void testCode2() {
        code.setCode("z9z9z9");
        String stringNextCode = codeServiceImpl.getNextCode(code);
        Assertions.assertEquals(stringNextCode, "a0a0a0a0");
    }

    @Test
    public void testCode3() {
        code.setCode("a0a0a9");
        String stringNextCode = codeServiceImpl.getNextCode(code);
        Assertions.assertEquals(stringNextCode, "a0a0b0");
    }

    @Test
    public void testCode4() {
        code.setCode("a0a0a9a0a0z9");
        String stringNextCode = codeServiceImpl.getNextCode(code);
        Assertions.assertEquals(stringNextCode, "a0a0a9a0a1a0");
    }

    @Test
    public void testCode5() {
        code.setCode("a0a0a9a0a0y9");
        String stringNextCode = codeServiceImpl.getNextCode(code);
        Assertions.assertEquals(stringNextCode, "a0a0a9a0a0z0");
    }


}
