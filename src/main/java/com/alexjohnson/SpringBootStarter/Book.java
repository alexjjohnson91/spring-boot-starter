package com.alexjohnson.SpringBootStarter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue
}
