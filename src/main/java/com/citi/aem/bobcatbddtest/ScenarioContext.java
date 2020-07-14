package com.citi.aem.bobcatbddtest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Collects the objects shared between steps.
 *
 * This is a similar approach to the 'world' object from Ruby implementation of Cucumber.
 *
 * Read more at: http://www.thinkcode.se/blog/2017/08/16/sharing-state-between-steps-in-cucumberjvm-using-guice
 */
@ScenarioScoped
public class ScenarioContext {

  private final Map<String, Object> context;

  /**
   * Constructs the ScenarioContext.
   */
  public ScenarioContext() {
    context = new HashMap<>();
  }

  /**
   * Adds an object to the context.
   *
   * @param key Identifier of the object in the context.
   * @param obj Object to be stored in the context.
   */
  public void add(String key, Object obj) {
    context.put(key, obj);
  }

  /**
   * Fetches the object from the context. Throws IllegalArgumentException if the provided key is missing.
   *
   * @param key Identifier of the object in the context.
   * @return The object fetched from the context.
   */
  @SuppressWarnings("unchecked")
  public <T> T get(String key) {
    if (context.containsKey(key)) {
      return (T) context.get(key);
    } else {
      throw new IllegalArgumentException("Specified key does not exist in ScenarioContext map");
    }
  }

  /**
   * Fetches the string from the context, short for "get(key, String.class)".
   *
   * @param key Identifier of the object in the context.
   * @return value for the key
   */
  public String getString(String key) {
    return get(key);
  }

  /**
   * Fetches the list from the context, short for "get(key, List.class)".
   *
   * @param key Identifier of the object in the context.
   * @param <T> list class
   * @return value for the key
   */
  public <T> List<T> getList(String key) {
    return get(key);
  }

  /**
   * Method for checking if scenarioContext map contains a mapping for the specified
   * key.
   *
   * @param key Identifier of the object in the context.
   * @return true - if scenarioContext map contains the specified key, otherwise false
   */
  public boolean containsKey(String key) {
    return context.containsKey(key);
  }
}
