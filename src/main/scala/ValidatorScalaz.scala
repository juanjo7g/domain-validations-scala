import scalaz.{Failure, Success, ValidationNel}
import scalaz._
import Scalaz._

trait ValidatorScalaz {
  def validateName(name: String): ValidationNel[DomainValidation, String] = {
    (if(name.length >= 5) Success(name)
    else Failure(InvalidName)).toValidationNel
  }
  def validatePass(pass: String): ValidationNel[DomainValidation, String] = {
    (if(pass.length >= 10) Success(pass)
    else Failure(InvalidPass)).toValidationNel
  }
  def validateAge(age: Int): ValidationNel[DomainValidation, Int] = {
    (if(age > 0) Success(age)
    else Failure(InvalidAge)).toValidationNel
  }

  def validateForm(name: String, pass: String, age: Int): ValidationNel[DomainValidation, RegistrationObject] = {
    (validatePass(pass) |@|
      validateName(name) |@|
      validateAge(age)) {
      RegistrationObject
    }
  }
}

object ValidatorScalaz extends ValidatorScalaz