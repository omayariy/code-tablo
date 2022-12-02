package com.example.todolist.service;

import com.example.todolist.entity.Code;

public interface CodeService {

    Code getLastCode();

    Code createNextCode();
}
