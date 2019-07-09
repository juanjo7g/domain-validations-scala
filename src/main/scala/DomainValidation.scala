trait DomainValidation {
  def messageError: String
}

case object InvalidName extends DomainValidation{
  override def messageError = "El nombre usuario incorrecto"
}

case object InvalidPass extends DomainValidation{
  override def messageError = "El password incorrecto"
}

case object InvalidAge extends DomainValidation{
  override def messageError = "Usted no ha nacido"
}
