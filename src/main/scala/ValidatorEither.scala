trait ValidatorEither {
  def validateName(name: String): Either[DomainValidation, String] = {
    Either.cond(
      name.length >= 5,
      name,
      InvalidName
    )
  }
  def validatePass(pass: String): Either[DomainValidation, String] = {
    Either.cond(
      pass.length >= 10,
      pass,
      InvalidPass
    )
  }
  def validateAge(age: Int): Either[DomainValidation, Int] = {
    Either.cond(
      age > 0,
      age,
      InvalidAge
    )
  }

  def validateForm(name: String, pass: String, age: Int): Either[DomainValidation, RegistrationObject] = {
    for {
      validName <- validateName(name)
      validPass <- validatePass(pass)
      validAge  <- validateAge(age)
    } yield RegistrationObject(validName, validPass, validAge)
  }
}

object ValidatorEither extends ValidatorEither