package org.whunmr.scalatestdemo

import org.openqa.selenium._
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FunSuite, Matchers}

class WebTestDemoFunSuiteStyle extends FunSuite with Matchers with WebBrowser  {
  implicit val webDriver: WebDriver = new HtmlUnitDriver
  val host = "http://www.baidu.com"

  test("Google browser works!") {
    go to (host)

    click on "kw"
    textField("kw").value = "Cheese!"
    submit()

    assert (pageTitle contains ("Cheese!") )
  }
}

