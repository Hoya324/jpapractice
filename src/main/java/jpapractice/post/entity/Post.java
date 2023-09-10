package jpapractice.post.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jpapractice.comment.domain.Comment;
import jpapractice.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String writer;
	private String contents;

	private int commentAmount;

	@CreatedDate
	private LocalDateTime createDate;

	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;

	@OneToMany(mappedBy = "post")
	private List<Comment> comments = new ArrayList<>();

	@Builder
	public Post(String title, String writer, String contents, Member member) {
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.member = member;
	}

	public static Post createPost(Member member, String title, String contents) {
		return Post.builder()
			.member(member)
			.writer(member.getName())
			.title(title)
			.contents(contents)
			.build();
	}
}
