package codesquad.web;

import codesquad.domain.Member;
import codesquad.dto.MemberRequestDto;
import codesquad.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/members")
public class ApiMemberController {

    @Autowired
    private MemberService memberService;

    //TODO : 로그 찍기

    @PostMapping("")
    public ResponseEntity<Void> create(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        Member savedMember = memberService.add(memberRequestDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/members/" + savedMember.getId()));
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}