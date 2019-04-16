package codesquad.web;

import codesquad.domain.Member;
import codesquad.dto.MemberRequestDto;
import codesquad.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(ApiMemberController.class);

    @PostMapping("")
    public ResponseEntity<Void> create(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        Member savedMember = memberService.add(memberRequestDto);

        logger.info("password : '{}'", savedMember.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        //TODO : 위에 코드 필요없는데. 어떻게 처리해줄지
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}