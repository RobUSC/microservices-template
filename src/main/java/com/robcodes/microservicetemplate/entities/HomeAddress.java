package com.robcodes.microservicetemplate.entities;


import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class HomeAddress {

    @Id
    Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<User> users = new ArrayList<>();


}
