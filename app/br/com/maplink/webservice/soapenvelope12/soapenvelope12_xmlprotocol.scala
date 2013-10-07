// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package soapenvelope12

/**
usage:
val obj = scalaxb.fromXML[soapenvelope12.Foo](node)
val document = scalaxb.toXML[soapenvelope12.Foo](obj, "foo", soapenvelope12.defaultScope)
  * */
object `package` extends XMLProtocol {}

trait XMLProtocol extends scalaxb.XMLStandardTypes {
  val defaultScope = scalaxb.toScope(None -> "http://www.w3.org/2003/05/soap-envelope",
    Some("tns") -> "http://www.w3.org/2003/05/soap-envelope",
    Some("xs") -> "http://www.w3.org/2001/XMLSchema",
    Some("xsi") -> "http://www.w3.org/2001/XMLSchema-instance")
  implicit lazy val Soapenvelope12EnvelopeFormat: scalaxb.XMLFormat[soapenvelope12.Envelope] = new DefaultSoapenvelope12EnvelopeFormat {}
  implicit lazy val Soapenvelope12HeaderFormat: scalaxb.XMLFormat[soapenvelope12.Header] = new DefaultSoapenvelope12HeaderFormat {}
  implicit lazy val Soapenvelope12BodyFormat: scalaxb.XMLFormat[soapenvelope12.Body] = new DefaultSoapenvelope12BodyFormat {}
  implicit lazy val Soapenvelope12FaultFormat: scalaxb.XMLFormat[soapenvelope12.Fault] = new DefaultSoapenvelope12FaultFormat {}
  implicit lazy val Soapenvelope12FaultreasonFormat: scalaxb.XMLFormat[soapenvelope12.Faultreason] = new DefaultSoapenvelope12FaultreasonFormat {}
  implicit lazy val Soapenvelope12ReasontextFormat: scalaxb.XMLFormat[soapenvelope12.Reasontext] = new DefaultSoapenvelope12ReasontextFormat {}
  implicit lazy val Soapenvelope12FaultcodeFormat: scalaxb.XMLFormat[soapenvelope12.Faultcode] = new DefaultSoapenvelope12FaultcodeFormat {}
  implicit lazy val Soapenvelope12FaultcodeEnumFormat: scalaxb.XMLFormat[soapenvelope12.FaultcodeEnum] = new DefaultSoapenvelope12FaultcodeEnumFormat {}
  implicit lazy val Soapenvelope12SubcodeFormat: scalaxb.XMLFormat[soapenvelope12.Subcode] = new DefaultSoapenvelope12SubcodeFormat {}
  implicit lazy val Soapenvelope12DetailFormat: scalaxb.XMLFormat[soapenvelope12.Detail] = new DefaultSoapenvelope12DetailFormat {}
  implicit lazy val Soapenvelope12NotUnderstoodTypeFormat: scalaxb.XMLFormat[soapenvelope12.NotUnderstoodType] = new DefaultSoapenvelope12NotUnderstoodTypeFormat {}
  implicit lazy val Soapenvelope12SupportedEnvTypeFormat: scalaxb.XMLFormat[soapenvelope12.SupportedEnvType] = new DefaultSoapenvelope12SupportedEnvTypeFormat {}
  implicit lazy val Soapenvelope12UpgradeTypeFormat: scalaxb.XMLFormat[soapenvelope12.UpgradeType] = new DefaultSoapenvelope12UpgradeTypeFormat {}

  trait DefaultSoapenvelope12EnvelopeFormat extends scalaxb.ElemNameParser[soapenvelope12.Envelope] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("Envelope")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Envelope] =
      phrase(opt(scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Header")) ~
        (scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Body")) ^^ {
        case p1 ~ p2 =>
          soapenvelope12.Envelope(p1.headOption map {
            scalaxb.fromXML[soapenvelope12.Header](_, scalaxb.ElemName(node) :: stack)
          },
            scalaxb.fromXML[soapenvelope12.Body](p2, scalaxb.ElemName(node) :: stack),
            scala.collection.immutable.ListMap((node match {
              case elem: scala.xml.Elem =>
                elem.attributes.toList flatMap {

                  case scala.xml.UnprefixedAttribute(key, value, _) =>
                    List(("@" + key, scalaxb.DataRecord(None, Some(key), value.text)))
                  case scala.xml.PrefixedAttribute(pre, key, value, _) =>
                    val ns = elem.scope.getURI(pre)
                    List(("@{" + ns + "}" + key, scalaxb.DataRecord(Option[String](ns), Some(key), value.text)))
                  case _ => Nil
                }
              case _ => Nil
            }): _*))
      })

    override def writesAttribute(__obj: soapenvelope12.Envelope, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case (key, x) => attr = scala.xml.Attribute((x.namespace map {
          __scope.getPrefix(_)
        }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: soapenvelope12.Envelope, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(__obj.Header map {
        scalaxb.toXML[soapenvelope12.Header](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Header"), __scope, false)
      } getOrElse {
        Nil
      },
        scalaxb.toXML[soapenvelope12.Body](__obj.Body, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Body"), __scope, false))

  }

  trait DefaultSoapenvelope12HeaderFormat extends scalaxb.ElemNameParser[soapenvelope12.Header] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("Header")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Header] =
      phrase(rep(any(_ => true)) ^^ {
        case p1 =>
          soapenvelope12.Header(p1.toSeq map {
            scalaxb.fromXML[scalaxb.DataRecord[Any]](_, scalaxb.ElemName(node) :: stack)
          },
            scala.collection.immutable.ListMap((node match {
              case elem: scala.xml.Elem =>
                elem.attributes.toList flatMap {

                  case scala.xml.UnprefixedAttribute(key, value, _) =>
                    List(("@" + key, scalaxb.DataRecord(None, Some(key), value.text)))
                  case scala.xml.PrefixedAttribute(pre, key, value, _) =>
                    val ns = elem.scope.getURI(pre)
                    List(("@{" + ns + "}" + key, scalaxb.DataRecord(Option[String](ns), Some(key), value.text)))
                  case _ => Nil
                }
              case _ => Nil
            }): _*))
      })

    override def writesAttribute(__obj: soapenvelope12.Header, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case (key, x) => attr = scala.xml.Attribute((x.namespace map {
          __scope.getPrefix(_)
        }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: soapenvelope12.Header, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.any flatMap {
        x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, true)
      })

  }

  trait DefaultSoapenvelope12BodyFormat extends scalaxb.ElemNameParser[soapenvelope12.Body] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("Body")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Body] =
      phrase(rep(any(_ => true)) ^^ {
        case p1 =>
          soapenvelope12.Body(p1.toSeq map {
            scalaxb.fromXML[scalaxb.DataRecord[Any]](_, scalaxb.ElemName(node) :: stack)
          },
            scala.collection.immutable.ListMap((node match {
              case elem: scala.xml.Elem =>
                elem.attributes.toList flatMap {

                  case scala.xml.UnprefixedAttribute(key, value, _) =>
                    List(("@" + key, scalaxb.DataRecord(None, Some(key), value.text)))
                  case scala.xml.PrefixedAttribute(pre, key, value, _) =>
                    val ns = elem.scope.getURI(pre)
                    List(("@{" + ns + "}" + key, scalaxb.DataRecord(Option[String](ns), Some(key), value.text)))
                  case _ => Nil
                }
              case _ => Nil
            }): _*))
      })

    override def writesAttribute(__obj: soapenvelope12.Body, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case (key, x) => attr = scala.xml.Attribute((x.namespace map {
          __scope.getPrefix(_)
        }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: soapenvelope12.Body, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.any flatMap {
        x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, true)
      })

  }

  trait DefaultSoapenvelope12FaultFormat extends scalaxb.ElemNameParser[soapenvelope12.Fault] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("Fault")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Fault] =
      phrase((scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Code")) ~
        (scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Reason")) ~
        opt(scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Node")) ~
        opt(scalaxb.ElemName(None, "detail")) ^^ {
        case p1 ~ p2 ~ p3 ~ p4 =>
          soapenvelope12.Fault(scalaxb.fromXML[soapenvelope12.Faultcode](p1, scalaxb.ElemName(node) :: stack),
            scalaxb.fromXML[soapenvelope12.Faultreason](p2, scalaxb.ElemName(node) :: stack),
            p3.headOption map {
              scalaxb.fromXML[java.net.URI](_, scalaxb.ElemName(node) :: stack)
            },
            None,
            p4.headOption map {
              scalaxb.fromXML[soapenvelope12.Detail](_, scalaxb.ElemName(node) :: stack)
            })
      })

    def writesChildNodes(__obj: soapenvelope12.Fault, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[soapenvelope12.Faultcode](__obj.Code, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Code"), __scope, false),
        scalaxb.toXML[soapenvelope12.Faultreason](__obj.Reason, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Reason"), __scope, false),
        __obj.Node map {
          scalaxb.toXML[java.net.URI](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Node"), __scope, false)
        } getOrElse {
          Nil
        },
        __obj.Role map {
          scalaxb.toXML[java.net.URI](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Role"), __scope, false)
        } getOrElse {
          Nil
        },
        __obj.Detail map {
          scalaxb.toXML[soapenvelope12.Detail](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Detail"), __scope, false)
        } getOrElse {
          Nil
        })

  }

  trait DefaultSoapenvelope12FaultreasonFormat extends scalaxb.ElemNameParser[soapenvelope12.Faultreason] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("faultreason")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Faultreason] =
      phrase(rep(scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Text")) ^^ {
        case p1 =>
          soapenvelope12.Faultreason(p1.toSeq map {
            scalaxb.fromXML[soapenvelope12.Reasontext](_, scalaxb.ElemName(node) :: stack)
          }: _*)
      })

    def writesChildNodes(__obj: soapenvelope12.Faultreason, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.Text flatMap {
        scalaxb.toXML[soapenvelope12.Reasontext](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Text"), __scope, false)
      })

  }

  trait DefaultSoapenvelope12ReasontextFormat extends scalaxb.XMLFormat[soapenvelope12.Reasontext] with scalaxb.CanWriteChildNodes[soapenvelope12.Reasontext] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, soapenvelope12.Reasontext] = seq match {
      case node: scala.xml.Node => Right(soapenvelope12.Reasontext(scalaxb.fromXML[String](node, scalaxb.ElemName(node) :: stack),
        scalaxb.fromXML[String]((node \ "@{http://www.w3.org/XML/1998/namespace}lang"), scalaxb.ElemName(node) :: stack)))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }

    override def writesAttribute(__obj: soapenvelope12.Reasontext, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      attr = scala.xml.Attribute(__scope.getPrefix("http://www.w3.org/XML/1998/namespace"), "lang", __obj.xmllang.toString, attr)
      attr
    }

    def writesChildNodes(__obj: soapenvelope12.Reasontext, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq(scala.xml.Text(__obj.value.toString))


  }

  trait DefaultSoapenvelope12FaultcodeFormat extends scalaxb.ElemNameParser[soapenvelope12.Faultcode] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("faultcode")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Faultcode] =
      phrase((scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Value")) ~
        opt(scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Subcode")) ^^ {
        case p1 ~ p2 =>
          soapenvelope12.Faultcode(scalaxb.fromXML[soapenvelope12.FaultcodeEnum](p1, scalaxb.ElemName(node) :: stack),
            p2.headOption map {
              scalaxb.fromXML[soapenvelope12.Subcode](_, scalaxb.ElemName(node) :: stack)
            })
      })

    def writesChildNodes(__obj: soapenvelope12.Faultcode, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[soapenvelope12.FaultcodeEnum](__obj.Value, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Value"), __scope, false),
        __obj.Subcode map {
          scalaxb.toXML[soapenvelope12.Subcode](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Subcode"), __scope, false)
        } getOrElse {
          Nil
        })

  }

  def buildSoapenvelope12FaultcodeEnumFormat = new DefaultSoapenvelope12FaultcodeEnumFormat {}

  trait DefaultSoapenvelope12FaultcodeEnumFormat extends scalaxb.XMLFormat[soapenvelope12.FaultcodeEnum] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, soapenvelope12.FaultcodeEnum] = seq match {
      case elem: scala.xml.Elem => Right(soapenvelope12.FaultcodeEnum.fromString(elem.text, elem.scope))
      case _ => Right(soapenvelope12.FaultcodeEnum.fromString(seq.text, scala.xml.TopScope))
    }

    def writes(__obj: soapenvelope12.FaultcodeEnum, __namespace: Option[String], __elementLabel: Option[String],
               __scope: scala.xml.NamespaceBinding, __typeAttribute: Boolean): scala.xml.NodeSeq =
      scala.xml.Elem(scalaxb.Helper.getPrefix(__namespace, __scope).orNull,
        __elementLabel getOrElse {
          sys.error("missing element label.")
        },
        scala.xml.Null, __scope, scala.xml.Text(__obj.toString))
  }

  trait DefaultSoapenvelope12SubcodeFormat extends scalaxb.ElemNameParser[soapenvelope12.Subcode] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("subcode")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Subcode] =
      phrase((scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Value")) ~
        opt(scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "Subcode")) ^^ {
        case p1 ~ p2 =>
          soapenvelope12.Subcode(scalaxb.fromXML[javax.xml.namespace.QName](p1, scalaxb.ElemName(node) :: stack),
            p2.headOption map {
              scalaxb.fromXML[soapenvelope12.Subcode](_, scalaxb.ElemName(node) :: stack)
            })
      })

    def writesChildNodes(__obj: soapenvelope12.Subcode, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Seq.concat(scalaxb.toXML[javax.xml.namespace.QName](__obj.Value, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Value"), __scope, false),
        __obj.Subcode map {
          scalaxb.toXML[soapenvelope12.Subcode](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("Subcode"), __scope, false)
        } getOrElse {
          Nil
        })

  }

  trait DefaultSoapenvelope12DetailFormat extends scalaxb.ElemNameParser[soapenvelope12.Detail] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("detail")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.Detail] =
      phrase(rep(any(_ => true)) ^^ {
        case p1 =>
          soapenvelope12.Detail(p1.toSeq map {
            scalaxb.fromXML[scalaxb.DataRecord[Any]](_, scalaxb.ElemName(node) :: stack)
          },
            scala.collection.immutable.ListMap((node match {
              case elem: scala.xml.Elem =>
                elem.attributes.toList flatMap {

                  case scala.xml.UnprefixedAttribute(key, value, _) =>
                    List(("@" + key, scalaxb.DataRecord(None, Some(key), value.text)))
                  case scala.xml.PrefixedAttribute(pre, key, value, _) =>
                    val ns = elem.scope.getURI(pre)
                    List(("@{" + ns + "}" + key, scalaxb.DataRecord(Option[String](ns), Some(key), value.text)))
                  case _ => Nil
                }
              case _ => Nil
            }): _*))
      })

    override def writesAttribute(__obj: soapenvelope12.Detail, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      __obj.attributes.toList map {
        case (key, x) => attr = scala.xml.Attribute((x.namespace map {
          __scope.getPrefix(_)
        }).orNull, x.key.orNull, x.value.toString, attr)
      }
      attr
    }

    def writesChildNodes(__obj: soapenvelope12.Detail, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.any flatMap {
        x => scalaxb.toXML[scalaxb.DataRecord[Any]](x, x.namespace, x.key, __scope, true)
      })

  }

  trait DefaultSoapenvelope12NotUnderstoodTypeFormat extends scalaxb.XMLFormat[soapenvelope12.NotUnderstoodType] with scalaxb.CanWriteChildNodes[soapenvelope12.NotUnderstoodType] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, soapenvelope12.NotUnderstoodType] = seq match {
      case node: scala.xml.Node => Right(soapenvelope12.NotUnderstoodType(scalaxb.fromXML[javax.xml.namespace.QName]((node \ "@qname"), scalaxb.ElemName(node) :: stack)(scalaxb.XMLStandardTypes.qnameXMLFormat(node.scope))))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }

    override def writesAttribute(__obj: soapenvelope12.NotUnderstoodType, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      attr = scala.xml.Attribute(null, "qname", scalaxb.Helper.toString(__obj.qname, __scope), attr)
      attr
    }

    def writesChildNodes(__obj: soapenvelope12.NotUnderstoodType, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }

  trait DefaultSoapenvelope12SupportedEnvTypeFormat extends scalaxb.XMLFormat[soapenvelope12.SupportedEnvType] with scalaxb.CanWriteChildNodes[soapenvelope12.SupportedEnvType] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    def reads(seq: scala.xml.NodeSeq, stack: List[scalaxb.ElemName]): Either[String, soapenvelope12.SupportedEnvType] = seq match {
      case node: scala.xml.Node => Right(soapenvelope12.SupportedEnvType(scalaxb.fromXML[javax.xml.namespace.QName]((node \ "@qname"), scalaxb.ElemName(node) :: stack)(scalaxb.XMLStandardTypes.qnameXMLFormat(node.scope))))
      case _ => Left("reads failed: seq must be scala.xml.Node")
    }

    override def writesAttribute(__obj: soapenvelope12.SupportedEnvType, __scope: scala.xml.NamespaceBinding): scala.xml.MetaData = {
      var attr: scala.xml.MetaData = scala.xml.Null
      attr = scala.xml.Attribute(null, "qname", scalaxb.Helper.toString(__obj.qname, __scope), attr)
      attr
    }

    def writesChildNodes(__obj: soapenvelope12.SupportedEnvType, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      Nil


  }

  trait DefaultSoapenvelope12UpgradeTypeFormat extends scalaxb.ElemNameParser[soapenvelope12.UpgradeType] {
    val targetNamespace: Option[String] = Some("http://www.w3.org/2003/05/soap-envelope")

    override def typeName: Option[String] = Some("UpgradeType")

    def parser(node: scala.xml.Node, stack: List[scalaxb.ElemName]): Parser[soapenvelope12.UpgradeType] =
      phrase(rep(scalaxb.ElemName(Some("http://www.w3.org/2003/05/soap-envelope"), "SupportedEnvelope")) ^^ {
        case p1 =>
          soapenvelope12.UpgradeType(p1.toSeq map {
            scalaxb.fromXML[soapenvelope12.SupportedEnvType](_, scalaxb.ElemName(node) :: stack)
          }: _*)
      })

    def writesChildNodes(__obj: soapenvelope12.UpgradeType, __scope: scala.xml.NamespaceBinding): Seq[scala.xml.Node] =
      (__obj.SupportedEnvelope flatMap {
        scalaxb.toXML[soapenvelope12.SupportedEnvType](_, Some("http://www.w3.org/2003/05/soap-envelope"), Some("SupportedEnvelope"), __scope, false)
      })

  }


}

