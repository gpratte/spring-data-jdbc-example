package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {
  public static void initDbSchema(JdbcTemplate jdbcTemplate) throws IOException {
    InputStream resource = new ClassPathResource(
      "create_toc_schema.sql").getInputStream();
    try (BufferedReader reader = new BufferedReader(
      new InputStreamReader(resource))) {
      String line;
      StringBuilder sb = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        if (StringUtils.isBlank(line)) {
          continue;
        }
        if (line.startsWith("#")) {
          continue;
        }

        sb.append(" " + line);

        if (line.endsWith(";")) {
          jdbcTemplate.execute(sb.toString());
          sb = new StringBuilder();
        }
      }
    }
  }
}
