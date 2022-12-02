package com.example.todolist.service;

import com.example.todolist.entity.Code;
import com.example.todolist.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;


    @Override
    public Code getLastCode() {
        List<Code> codes = codeRepository.findAll();
        return codes.get(codes.size() - 1);
    }

    @Override
    public Code createNextCode() {
        Code lastCode = getLastCode();
        String stringCode = getNextCode(lastCode);
        Code nextCode = new Code();
        nextCode.setCode(stringCode);
        codeRepository.save(nextCode);
        return nextCode;
    }

    public String getNextCode(Code code) {
        String codeString = code.getCode();
        int pos = codeString.length() - 2;
        while (pos >= 0) {
            if (codeString.charAt(pos) == 'z' && codeString.charAt(pos + 1) == '9')
                pos -= 2;
            else
                break;
        }
        if (pos == -2) {
            StringBuilder newCodeString = new StringBuilder();
            for (; pos < codeString.length(); pos += 2) {
                newCodeString.append('a');
                newCodeString.append('0');
            }
            return newCodeString.toString();
        }
        StringBuilder newCodeString = new StringBuilder(codeString);
        for (int i = pos + 2; i < codeString.length(); i += 2) {
            newCodeString.setCharAt(i, 'a');
            newCodeString.setCharAt(i + 1, '0');
        }
        if (codeString.charAt(pos + 1) != '9')
            pos++;
        else
            newCodeString.setCharAt(pos + 1, '0');
        newCodeString.setCharAt(pos, (char) (newCodeString.charAt(pos) + 1));
        return newCodeString.toString();
    }

}
