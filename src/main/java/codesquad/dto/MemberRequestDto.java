package codesquad.dto;

import codesquad.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @NotBlank(message = "NotBlank emailId")
    private String emailId;

    @NotBlank(message = "NotBlank emailDomain")
    private String emailDomain;

    @NotBlank(message = "NotBlank password")
    private String[] pwd;

    @NotBlank(message = "NotBlank name")
    private String name;

    @NotBlank(message = "NotBlank cell")
    private String[] cell;

    public Member toEntity() {
        return Member.builder()
                .emailId(emailId)
                .emailDomain(emailDomain)
                .password(passwordEncoder.encode(pwd[0]))
                .name(name)
                .cell1(cell[0])
                .cell2(cell[1])
                .cell3(cell[2])
                .build();
    }

}
