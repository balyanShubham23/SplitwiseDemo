package com.example.splitwisedemo.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {

    public int id;

    private Date createdDate;

    private Date lastModifiedDate;
}
