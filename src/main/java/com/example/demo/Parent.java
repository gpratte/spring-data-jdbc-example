package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
public class Parent {
  @Id
  private int id;
  private int count;
  @MappedCollection(idColumn = "ID")
  OneToOne oneToOne;
  @MappedCollection
  Set<Day> days;
  @MappedCollection
  Map<String, Color> colors;
  @MappedCollection
  List<Car> cars;
  @MappedCollection
  List<Orderr> orders;
}
