// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package generated

import soapenvelope12.{Faultreason, Reasontext}


trait AddressFinderSoap {
  def findPOI(name: Option[String], city: generated.City, resultRange: generated.ResultRange, token: Option[String]): Either[scalaxb.Fault[Any], generated.POIInfo]

  def findAddress(address: generated.Address, ao: generated.AddressOptions, token: Option[String]): Either[scalaxb.Fault[Any], generated.AddressInfo]

  def getAddress(point: generated.Point, token: Option[String], tolerance: Double): Either[scalaxb.Fault[Any], generated.AddressLocation]

  def getXY(address: generated.Address, token: Option[String]): Either[scalaxb.Fault[Any], generated.Point]

  def getXYRadiusWithMap(address: generated.Address, mo: generated.MapOptions, radius: Int, token: Option[String]): Either[scalaxb.Fault[Any], generated.MapInfo]

  def findCity(cidade: generated.City, ao: generated.AddressOptions, token: Option[String]): Either[scalaxb.Fault[Any], generated.CityLocationInfo]

  def getCrossStreetXY(cidade: generated.City, firstStreet: Option[String], secondStreet: Option[String], token: Option[String]): Either[scalaxb.Fault[Any], generated.GetCrossStreetXYResponse]

  def getCrossStreetAddress(point: generated.Point, token: Option[String]): Either[scalaxb.Fault[Any], generated.GetCrossStreetAddressResponse]
}




