package com.threethings.api.init;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.threethings.api.challenge.domain.ChallengeCategory;
import com.threethings.api.member.domain.AgeGroup;
import com.threethings.api.member.domain.Gender;
import com.threethings.api.member.domain.Member;
import com.threethings.api.member.domain.Provider;
import com.threethings.api.member.repository.MemberRepository;

@Component
public class MemberTestInitDB {
	@Autowired
	MemberRepository memberRepository;

	@Transactional
	public void initDB() {
		initTestMember();
	}

	private void initTestMember() {
		Member member1 = Member.builder()
			.nickname("testMember1")
			.provider(Provider.NAVER)
			.socialCode("12345678")
			.ageGroup(AgeGroup.TEENS)
			.profileImageId(1L)
			.gender(Gender.MALE)
			.favoriteChallengeCategories(Set.of(ChallengeCategory.EXERCISE, ChallengeCategory.GROWTH)).build();

		Member member2 = Member.builder()
			.nickname("testMember2")
			.provider(Provider.KAKAO)
			.socialCode("87654321")
			.ageGroup(AgeGroup.TEENS)
			.profileImageId(2L)
			.gender(Gender.MALE)
			.favoriteChallengeCategories(Set.of(ChallengeCategory.PET_CARE, ChallengeCategory.GROWTH)).build();

		memberRepository.saveAll(List.of(member1, member2));
	}
}
