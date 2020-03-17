package com.example.demo.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class DomainImpl {
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIME)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
