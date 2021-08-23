package com.example.bookmanager.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmanager.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// 1 jpa는 optional, set 등 굉장히 많은 return 타입을 제공하고 있다.
	User findByName(String name);
	//Optional<User> findByName(String name); 
	//Set<User> findByName(String name);
	
	// 2 nameing규칙 extends로 User를 받았다면 필드 전체를 사용가능
	User findByEmail(String email);
	User getByEmail(String email);
	User readByEmail(String email);
	User queryByEmail(String email);
	User searchByEmail(String email);
	User streamByEmail(String email);
	User findUserByEmail(String email);
	User findSomethingByEmail(String email);

	// 3 
	List<User> findFirst2ByName(String name);
    List<User> findTop2ByName(String name);
    List<User> findLast1ByName(String name);

    // 4 조건절 and, or 
    List<User> findByEmailAndName(String email, String name);
    List<User> findByEmailOrName(String email, String name);

    // 5 시간 비교
    List<User> findByCreatedAtAfter(LocalDateTime yesterday);
    List<User> findByIdAfter(Long id);
    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<User> findByIdBetween(Long id1, Long id2);
    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    // 6
    List<User> findByIdIsNotNull();
    // 잘 사용하지 않음 주의) 문자열의 empty가 아닌 collection의 empty를 체크한다
//    List<User> findByAddressIsNotEmpty();   

    // 7 in, not in 실무에서 자주 사용함
    List<User> findByNameIn(List<String> names);
  
    // 8 LIKE
    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContains(String name);
    List<User> findByNameLike(String name);

    List<User> findTop1ByName(String name);
    List<User> findTopByNameOrderByIdDesc(String name);
    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);
    List<User> findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);

}
