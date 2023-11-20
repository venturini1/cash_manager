package com.cashmanager.cashmanagerAPI.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = )
public class Users {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String email;

    private String password;


}
