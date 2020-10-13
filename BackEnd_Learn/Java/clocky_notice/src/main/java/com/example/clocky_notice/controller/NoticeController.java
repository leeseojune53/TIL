package com.example.clocky_notice.controller;

import com.example.clocky_notice.model.Notice;
import com.example.clocky_notice.repository.NoticeRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/Notice")
@RestController
public class NoticeController {
    private final NoticeRepository noticeRepository;

    public NoticeController(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    @RequestMapping("/insert")
    public Notice insert(@RequestBody Map<String, String> map){
        return noticeRepository.save(
            new Notice(map.get("title"), map.get("written"))
        );
    }

    @RequestMapping("/delete/{id}")
    public String deleteOne(@PathVariable("id") long id){
        noticeRepository.deleteById(id);
        return "Success delete";
    }

    @RequestMapping("/select")
    public List<Notice> SelectAll(){
        return noticeRepository.findAll();
    }

    @RequestMapping("/seletc/{id}")
    public Notice Select(@PathVariable("id") long id){
        return noticeRepository.findById(id).orElse(null);
    }

}
