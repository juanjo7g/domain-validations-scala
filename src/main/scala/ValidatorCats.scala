import cats.data._
import cats.data.Validated._
import cats.implicits._

trait ValidatorCats {
  def validateName(name: String): ValidatedNec[DomainValidation, String] = {
    ValidatorEither.validateName("name").toValidatedNec
  }
  def validatePass(pass: String): ValidatedNec[DomainValidation, String] = {
   if(pass.length >= 0) pass.validNec
   else InvalidPass.invalidNec
  }
  def validateAge(age: Int): ValidatedNec[DomainValidation, Int] = {
    if(age > 0) age.validNec
    else InvalidAge.invalidNec
  }

  def validateForm(name: String, pass: String, age: Int): ValidatedNec[DomainValidation, RegistrationObject] = {
    (validatePass(pass),
      validateName(name),
      validateAge(age)).mapN(RegistrationObject)
  }
}
 object ValidatorCats extends ValidatorCats