package com.example.connection_rds.controller;

import com.example.connection_rds.model.Member;
import com.example.connection_rds.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

//    @GetMapping("/test")
//    public Member memberTest(){
//        return new Member(0L, "Wickies", 20, "제주", new Date());
//    }
//
//    @GetMapping("/test2")
//    public ArrayList<Member> memberTest2(){
//        return new ArrayList(Arrays.asList(
//                new Member(1L, "Wickies", 20, "제주", new Date()),
//                new Member(2L, "마동석", 40, "전주", new Date()),
//                new Member(3L, "조승우", 22, "무주", new Date()),
//                new Member(4L, "박보영", 32, "진주", new Date()),
//                new Member(5L, "엄복동", 17, "상주", new Date())
//        ));
//    }

    @RequestMapping("/insert") // CREATE
    public Member insert(@RequestBody Map<String, String> map){
        return memberRepository.save(
                new Member(map.get("name"), intParser(map.get("age")), map.get("address"))
        );
    }

    @RequestMapping("/select") // READ
    public List<Member> selectAll(){
        return memberRepository.findAll();
    }

    @RequestMapping("/select/{id}") // READ
    public Member selectOne(@PathVariable("id") long id){
        return memberRepository.findById(id).orElse(null);
    }

    @RequestMapping("/update/{id}") // UPDATE
    public Member updateOne(@PathVariable("id") long id, @RequestBody Map<String, String> map){
        System.out.println(id);
        System.out.println(map);
        Member member = memberRepository.findById(id).orElse(null);
        member.setName(map.get("name"));
        member.setAge(intParser(map.get("age")));
        member.setAddress(map.get("address"));
        return memberRepository.save(member);
    }

    @RequestMapping("/delete/{id}") // DELETE
    public String deleteOne(@PathVariable("id") long id){
        memberRepository.deleteById(id);
        return "삭제 완료";
    }

    int intParser(String age){
        try{
            return Integer.parseInt(age);
        } catch(ClassCastException e){
            e.printStackTrace();
            return 0;
        }
    }
}
