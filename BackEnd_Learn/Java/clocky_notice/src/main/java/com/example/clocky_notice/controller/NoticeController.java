package com.example.clocky_notice.controller;

import com.example.clocky_notice.model.Notice;
import com.example.clocky_notice.repository.NoticeRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NoticeController {
    private final NoticeRepository noticeRepository;

    public NoticeController(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    @RequestMapping("/test")
    public Notice insert(@RequestBody Map<String, String> map){
        return noticeRepository.save(
            new Notice(map.get("title"), map.get("written"))
        );
    }

}
