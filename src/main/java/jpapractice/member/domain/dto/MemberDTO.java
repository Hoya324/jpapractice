package jpapractice.member.domain.dto;

import jpapractice.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDTO {

	private Long id;
	private String name;
	private String email;
	private String password;

	@Builder
	public MemberDTO(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static MemberDTO from(Member member) {
		return MemberDTO.builder()
			.id(member.getId())
			.name(member.getName())
			.email(member.getEmail())
			.password(member.getPassword())
			.build();
	}
}
