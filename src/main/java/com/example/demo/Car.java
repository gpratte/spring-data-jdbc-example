package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class Car {
  @Id
  private int id;
  private String name;
}
