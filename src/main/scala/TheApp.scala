import cats.data.Validated.{Invalid, Valid}
import scalaz.{Failure, Success}

object TheApp extends App {
  println("APP START")
  val result = ValidatorEither.validateForm(
    "juanjo",
    "contraseñagigantesegura",
    2
  )
  println(s"RES $result")

  val resulte = ValidatorEither.validateForm(
    "juanjo",
    "contraseñagigantesegura",
    0
  )
  println(s"RES $resulte")

  resulte match {
    case Right(v) => println(s"Nice: $v")
    case Left(v) => println(s"Oh nooo ${v.messageError}")
  }

  val resulte2 = ValidatorEither.validateForm(
    "juanjo",
    "pass",
    0
  )
  println(s"RES $resulte2")

 val resulte2cats = ValidatorCats.validateForm(
    "juanjo",
    "pass",
    0
  )
  resulte2cats match {
    case Valid(a) => println(s"BVALID")
    case Invalid(e) => println(s"Errors ${e.toChain.map(_.messageError)}")
  }
  println(s"RES ${resulte2cats}")

  val resulte2scalaz = ValidatorScalaz.validateForm(
    "juanjo",
    "pass",
    0
  )

  println(s"resuuuuult $resulte2scalaz")

  resulte2scalaz match  {
    case Success(a) => println(s"SUCCESSSSSSS $a")
    case Failure(e) => println(s"${e.map(_.messageError)}")
  }

  val resulteSUcc = ValidatorScalaz.validateForm(
    "juanjo",
    "passasdasdasd",
    12
  )

  println(s"resuuuuult $resulteSUcc")

  resulteSUcc match  {
    case Success(a) => println(s"SUCCESSSSSSS $a")
    case Failure(e) => println(s"${e.map(_.messageError)}")
  }

}
