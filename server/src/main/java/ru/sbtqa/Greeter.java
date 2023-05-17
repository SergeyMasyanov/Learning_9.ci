package ru.sbtqa;

/**
 * Greeter class
 */
public class Greeter {

  /**
   * Constructor of Greeter class.
   */
  public Greeter() {

  }

  /**
   * method for greeting a person
   * @param name = name of a person
   * @return = greeting
   */
  public final String greet(final String name) {
    return String.format("Hello, %s!", name);
  }
}
