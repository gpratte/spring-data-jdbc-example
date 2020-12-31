package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@ToString
public class Orderr {
  @Id
  private int id;
  private int orderNum;
  private List<Item> items;
}
