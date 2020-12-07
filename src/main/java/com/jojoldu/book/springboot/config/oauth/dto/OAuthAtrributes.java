package com.jojoldu.book.springboot.config.oauth.dto;

import com.jojoldu.book.springboot.domain.user.Role;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAtrributes {
    private Map<String, Object> atrributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAtrributes(Map<String, Object> atrributes, String nameAttributeKey, String name, String email, String picture) {
        this.atrributes = atrributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAtrributes of(String registrationId, String userNameAttributeName, Map<String, Object> atrributes) {
        return ofGoogle(userNameAttributeName, atrributes);
    }

    public static OAuthAtrributes ofGoogle(String userNameAttributeName, Map<String, Object> atrributes) {
        return  OAuthAtrributes.builder()
                .name((String) atrributes.get("name"))
                .email((String) atrributes.get("email"))
                .picture((String) atrributes.get("picture"))
                .atrributes(atrributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
