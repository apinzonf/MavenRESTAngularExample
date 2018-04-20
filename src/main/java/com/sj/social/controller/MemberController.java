package com.sj.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sj.social.model.Member;
import com.sj.social.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService memberService;


	// Retrieve all
	@RequestMapping(value = "/member/", method = RequestMethod.GET)
    public ResponseEntity<List<Member>> listAllMembers() {
        List<Member> members = memberService.findAllMembers();
        System.err.println("member");	
        if(members.isEmpty()){
            return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
    }

	// Retrieve 
   @RequestMapping(value = "/member/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> getMember(@PathVariable("email") String email) {
        Member member = memberService.findByEmail(email);
        System.err.println("member: " + email);
        if (member == null) {
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }
   
   //, consumes="application/json",headers = "content-type=application/x-www-form-urlencoded"
   // Create
   @RequestMapping(value = "/member/", method = RequestMethod.POST)
   public ResponseEntity<Void> createMember(@RequestBody Member member, UriComponentsBuilder ucBuilder) {
	   if (member != null){
		   if (memberService.findByEmail(member.getEmail()) != null )  {
			   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		   }
       }
       memberService.save(member);
       HttpHeaders headers = new HttpHeaders();
       headers.setLocation(ucBuilder.path("/member/{email}").buildAndExpand(member.getEmail()).toUri());
       return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
   }
   
   // Update
   @RequestMapping(value = "/member/{email}", method = RequestMethod.PUT)
   public ResponseEntity<Member> updateMember(@PathVariable("email") String email, @RequestBody Member member) {
       Member currentMember = memberService.findByEmail(email);        
       if (currentMember==null) {
           return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
       }
       currentMember.setName(member.getName());        
       memberService.update(currentMember);
       return new ResponseEntity<Member>(currentMember, HttpStatus.OK);
   }
   
   //delete
   @RequestMapping(value = "/member/{email}", method = RequestMethod.DELETE)
   public ResponseEntity<Member> deleteMember(@PathVariable("email") String email) {
       Member member = memberService.findByEmail(email);
       if (member == null) {
           return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
       }

       memberService.delete(member);
       return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
   }

}

