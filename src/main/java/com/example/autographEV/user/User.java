package com.example.autographEV.user;

import com.example.autographEV.Validator.ValidName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="users")
public class User {
    @Id
    private String userId;
    //@NotEmpty @ValidName
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String profilePhotoUrl;
    private String address;
    private int age;
}
