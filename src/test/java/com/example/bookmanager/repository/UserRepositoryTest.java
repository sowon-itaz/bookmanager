package com.example.bookmanager.repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

import java.time.LocalDateTime;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.example.bookmanager.domain.User;

@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;

	@Test
	void crud() {
		// 1. save
		userRepository.save(new User(null, "가나다", "ganada@fast.com", LocalDateTime.now(), LocalDateTime.now()));
		userRepository.save(new User());
		userRepository.save(new User(null, "마바사", "mabasa@fast.com", LocalDateTime.now(), LocalDateTime.now()));
		userRepository.save(new User(null, "ma", "ma@slow.com", LocalDateTime.now(), LocalDateTime.now()));
		userRepository.save(new User(null, "라", "ra@slow.com", LocalDateTime.now(), LocalDateTime.now()));

		userRepository.findAll().forEach(System.out::println);

		// 2. matcher
		ExampleMatcher matcher1 = ExampleMatcher.matching().withIgnorePaths("name").withMatcher("email", endsWith());
		Example<User> example1 = Example.of(new User("ma", "ma@fast.com"), matcher1);

		userRepository.findAll(example1).forEach(System.out::println);
	}

	@Test
	void select() {
		userRepository.save(new User(null, "가나다", "ganada@fast.com", LocalDateTime.now(), LocalDateTime.now()));
		userRepository.save(new User());
		userRepository.save(new User(null, "마바사", "mabasa@fast.com", LocalDateTime.now(), LocalDateTime.now()));
		userRepository.save(new User(null, "ma", "ma@slow.com", LocalDateTime.now(), LocalDateTime.now()));
		userRepository.save(new User(null, "ma", "ma@slow.com", LocalDateTime.now(), LocalDateTime.now()));
		userRepository.save(new User(null, "라", "ra@slow.com", LocalDateTime.now(), LocalDateTime.now()));
		
		userRepository.findAll().forEach(System.out::println);
		// 1
//		System.out.println(userRepository.findByName("마바사"));
		
		// 2
//		System.out.println("@ findByEmail : " + userRepository.findByEmail("ra@slow.com"));
//		System.out.println("@ getByEmail : " + userRepository.getByEmail("ra@slow.com"));
//		System.out.println("@ readByEmail : " + userRepository.readByEmail("ra@slow.com"));
//		System.out.println("@ queryByEmail : " + userRepository.queryByEmail("ra@slow.com"));
//		System.out.println("@ searchByEmail : " + userRepository.searchByEmail("ra@slow.com"));
//		System.out.println("@ streamByEmail : " + userRepository.streamByEmail("ra@slow.com"));
//		System.out.println("@ findUserByEmail : " + userRepository.findUserByEmail("ra@slow.com"));
//		System.out.println("@ findSomethingByEmail : " + userRepository.findSomethingByEmail("ra@slow.com"));

		// 3
//		System.out.println("findTop2ByName : " + userRepository.findTop2ByName("ma"));
//		System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("ma"));
//		System.out.println("findLast1ByName : " + userRepository.findLast1ByName("ma"));
		
		// 4 조건절 and, or 
//		System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("ma@slow.com", "ma"));
//		System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("ma@slow.com", "마바사"));

		// 5 시간 비교
//		System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//		System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//		System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//		System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//		System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//		System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//		System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

		// 6
//		System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//	    System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

		// 7 in, not in 실무에서 자주 사용함
//		System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("ma", "가나다")));

		// 8 LIKE
		System.out.println("findByNameStartingWith: " + userRepository.findByNameStartingWith("m"));
		System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("다"));
		System.out.println("findByNameContains : " + userRepository.findByNameContains("나"));
		System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "나" + "%"));
	}
}
