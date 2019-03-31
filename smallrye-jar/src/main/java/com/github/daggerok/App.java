package com.github.daggerok;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.se.SeContainerInitializer;

@ApplicationScoped
public class App {
  public static void main(String[] args) {
    SeContainerInitializer.newInstance().initialize();
  }
}
