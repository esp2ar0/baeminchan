package codesquad.service;

import codesquad.domain.Member;
import codesquad.domain.MemberRepository;
import codesquad.dto.MemberRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member add(MemberRequestDto memberRequestDto) {
        //TODO : 비밀번호 8-16자리 숫자,영문 조합 요것도 프론트에서 체크 후 메세지 출력\
        memberRequestDto.setPassword(passwordEncoder.encode(memberRequestDto.getPassword()));
        return memberRepository.save(memberRequestDto.toEntity());
    }
}
