package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    val aNumber = returnSomeNumber()
    Ok(views.html.index("the number returned is: " +  aNumber))
  }

  def returnSomeNumber() : Int = {
    3 + 3
  }

  def upper(word: String) = Action {
    Ok("Got request for word [" + word + "], and made it uppercase [" + word.toUpperCase() + "]")
  }

  def mapWord(word: String) = Action {
    Ok("mapped the word to this: [" + mapMe(word) + "]")
  }

  def mapMe(word: String) : String = {
    word.map(_.toUpper)
  }

}
