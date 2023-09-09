package jpapractice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpapractice.member.domain.Member;

@Repository
public interface UseRepository extends JpaRepository<Member, Long> {
}
