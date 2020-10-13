package com.example.notice.controller;


import com.example.notice.model.Notice;
import com.example.notice.repository.NoticeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class NoticeController {
    private final NoticeRepository noticeRepository;

    public NoticeController(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    @RequestMapping("/insert")
    public Notice insert(@RequestBody Map<String, String> map){
        return noticeRepository.save(
            new Notice(map.get("title"), map.get("Written"))
        );
    }

}
