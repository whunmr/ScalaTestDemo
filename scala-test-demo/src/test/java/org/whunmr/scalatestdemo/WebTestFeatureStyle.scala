package org.whunmr.scalatestdemo

import org.scalatest.selenium.WebBrowser.{click, go}
import org.scalatest.{FeatureSpec, GivenWhenThen}
import org.openqa.selenium._
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FunSuite, Matchers}

class WebTestFeatureStyle extends FeatureSpec with GivenWhenThen with Matchers with WebBrowser {
  implicit val webDriver: WebDriver = new HtmlUnitDriver
  val host = "http://www.baidu.com"

  feature("The user can pop an element off the top of the stack") {
    info("As a programmer, I want to be able to pop items off the stack, So that I can get them in last-in-first-out order")

    scenario("pop is invoked on a non-empty stack") {
      Given("a non-empty stack")
      go to (host)

      When("when pop is invoked on the stack")
      click on "kw"
      textField("kw").value = "Cheese!"
      submit()

      Then("the most recently pushed element should be returned")
      assert (pageTitle contains ("Cheese!") )
    }

    scenario("pop is invoked on an empty stack") {
      Given("an empty stack")
      When("when pop is invoked on the stack")
      Then("NoSuchElementException should be thrown")
      And("the stack should still be empty")
      pending
    }
  }
}
