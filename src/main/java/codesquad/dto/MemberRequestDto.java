package codesquad.dto;

import codesquad.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {

    @NotBlank(message = "NotBlank emailId")
    private String emailId;

    @NotBlank(message = "NotBlank emailDomain")
    private String emailDomain;

    @NotBlank(message = "NotBlank password")
    private String password;

    @NotBlank(message = "NotBlank name")
    private String name;

    @NotBlank(message = "NotBlank cell")
    private String cell1;

    @NotBlank(message = "NotBlank cell")
    private String cell2;

    @NotBlank(message = "NotBlank cell")
    private String cell3;

    public Member toEntity() {
        return Member.builder()
                .emailId(emailId)
                .emailDomain(emailDomain)
                .password(password)
                .name(name)
                .cell1(cell1)
                .cell2(cell2)
                .cell3(cell3)
                .build();
    }
}