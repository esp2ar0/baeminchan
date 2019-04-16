package codesquad.service;

import codesquad.domain.Member;
import codesquad.domain.MemberRepository;
import codesquad.dto.MemberRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member add(MemberRequestDto memberRequestDto) {
        //TODO : 비밀번호, 비밀번호 확인 일치 여부 프론트에서 확인하기.. 비밀번호 8-16자리 숫자,영문 조합 요것도 프론트에서 체크 후 메세지 출력\
        return memberRepository.save(memberRequestDto.toEntity());
    }
}
