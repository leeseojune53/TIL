package io.github.leeseojune53.querydsl_practice.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.github.leeseojune53.querydsl_practice.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import static io.github.leeseojune53.querydsl_practice.entity.QUser.user;

@Service
@RequiredArgsConstructor
public class UserService {

	private final JPAQueryFactory query;

	public void register(RegisterRequest request) {
		if(query
				.selectFrom(user)
				.where(user.id.eq(request.getId()))
				.fetchFirst()!=null)
			throw new RuntimeException("User id already exist.");
		query.insert(user)
				.columns(user.id, user.password)
				.values(request.getId(), request.getPassword())
				.execute();
	}

	public String signUp(RegisterRequest request) {
		return query
				.selectFrom(user)
				.where(user.id.eq(request.getId())
						.and(user.password.eq(request.getPassword())))
				.fetchFirst().getPassword();
	}

}
