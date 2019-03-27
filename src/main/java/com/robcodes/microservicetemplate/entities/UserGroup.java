package com.robcodes.microservicetemplate.entities;


import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@RedisHash("UserGroup")
public class UserGroup {

    @Id
    Integer id;
    String groupName;

    //Foreign Relation
    @ManyToMany(mappedBy = "userGroups",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<User> users = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();

}
