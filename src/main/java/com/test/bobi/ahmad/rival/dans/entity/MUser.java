package com.test.bobi.ahmad.rival.dans.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = MUser.TABLE_NAME)
public class MUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_USERNAME)
    private String username;

    @Column(name = COLUMN_PASSWORD)
    private String password;

    public static final String TABLE_NAME = "m_user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
}
