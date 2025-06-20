package com.SavePoint.SavePoint.mapper;

import com.SavePoint.SavePoint.controller.request.UserRequest;
import com.SavePoint.SavePoint.controller.response.UserResponse;
import com.SavePoint.SavePoint.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest){
        return User
                .builder()
                .email(userRequest.email())
                .nickname(userRequest.nickname())
                .password(userRequest.password())
                .build();
    }

    public UserResponse toUserResponse(User user){
        return UserResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build();
    }
}
