package com.nimsoc.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AtitudeTest {

  @Given("^I am on e-buyer homepage$")
  public void I_am_on_homepage() throws Throwable {
    System.out.println("e-buyer homepage loaded");
  }

  @Given("^I work in ([^\"]*)$")
  public void ln(String str) {
    if (str.equals("Latenights")) {
      System.out.println("latenight automation");
    }
    if (str.equals("Mornings")) {
      System.out.println("Morning automation");
    }
  }

  @When("^I meet ([^\"]*)$")
  public void Imeet(String str) {
    if (str.equals("watchmen")) {
      System.out.println("watchmen automation");
    }
    if (str.equals("NewspaperBoy")) {
      System.out.println("NewspaperBoy automation");
    }
  }

  @Given("^we work in \"([^\"]*)\"$")
  public void we_work_in(String ss) throws Throwable {
    // Express the Regexp above with the code you wish you had
    System.out.println(ss);
  }

  @When("^we meet \"([^\"]*)\">$")
  public void we_meet_(String arg1) throws Throwable {
    // Express the Regexp above with the code you wish you had
  }

  @Then("^I ([^\"]*) him$")
  public void gre(String str) {
    if (str.equals("Greeted")) {
      System.out.println("Greeted automation");
    }
    if (str.equals("skipGreeting")) {
      System.out.println("skipGreeting automation");
    }
  }
}
