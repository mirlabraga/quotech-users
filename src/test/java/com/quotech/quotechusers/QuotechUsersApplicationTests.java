package com.quotech.quotechusers;

import com.quotech.quotechusers.controllers.UserController;
import com.quotech.quotechusers.models.User;
import com.quotech.quotechusers.models.dto.UserDto;
import com.quotech.quotechusers.models.UserId;
import com.quotech.quotechusers.repositories.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class QuotechUsersApplicationTests {

	@Mock
	private UserRepository userRepository;
	private UserController controller;

	@BeforeEach
	public void setup() {
		this.controller = new UserController();
		this.controller.setUserRepository(userRepository);
	}

	@Test
	void getAllUsers() {
		List<User> assetList = Lists.list(new User(new UserId("quotech", "nick"),"Nick Melis", "nick@quotech.io", "CTO"),
				new User(new UserId("quotech", "mirla"),"Mirla Chucre", "mirlabraga@gmail.com", "DEV"));

		List<User> usersList = Lists.list(assetList.get(1));

		Mockito.when(this.userRepository.findAll()).thenReturn(usersList);
		List<UserDto> result = this.controller.findAll();

		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals("Mirla Chucre", result.get(0).getMetadata().getName());
	}
}
