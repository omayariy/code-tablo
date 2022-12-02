package com.example.todolist.controller;

import com.example.todolist.entity.Code;
import com.example.todolist.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tablo")
@RequiredArgsConstructor
public class CodeController {
    private final CodeService codeService;

    @GetMapping
    public ResponseEntity<Code> getLast() {
        return ResponseEntity.ok(codeService.getLastCode());
    }

    @PostMapping
    public ResponseEntity<Code> createNext() {
        return ResponseEntity.ok(codeService.createNextCode());
    }

}
