package com.projects.memberAPI.controller;

import com.projects.memberAPI.entity.Member;
import com.projects.memberAPI.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class memberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/getAll")
    public List<Member> findAllMembers() {
        return memberService.getAllMembers();
    }




    @GetMapping("/{id}")
    public ResponseEntity<Object> getMemberById(@PathVariable Long id) {
        return this.memberService.findMemberById(id);
    }




    @PostMapping("/create")
    public ResponseEntity<Object> createMember(@RequestBody Member member) {
        return memberService.newMember(member);
    }




    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateMember(@PathVariable long id, @RequestBody Member updatedMember) {
        return this.memberService.updateMember(id, updatedMember);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable Long id) {
        return this.memberService.deleteMember(id);
    }
}