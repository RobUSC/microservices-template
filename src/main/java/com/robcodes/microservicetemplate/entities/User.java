package com.robcodes.microservicetemplate.entities;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RedisHash("User")
public class User {

    @Id
    Integer id;
    String name;
    BigDecimal listPrice;

    //We do not have GUIDS generated in the DB in MariaDB, create them in the code
    @Column(columnDefinition = "uniqueidentifier")
    String guidValue;


    //Foreign Relation of many to many e.g. XREF
    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "User_UserGroup",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "userGroup_id",
                            referencedColumnName = "id"
                    )
            }
    )
    List<UserGroup> userGroups = new ArrayList<>();

    @ManyToOne
    HomeAddress homeAddress;

}
