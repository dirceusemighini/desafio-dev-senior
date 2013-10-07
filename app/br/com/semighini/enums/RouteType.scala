package br.com.semighini.enums

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 02/10/13
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */
object RouteType extends Enumeration {
  type Enum = Value
  val Fastest = Value(0)
  // 0 	Rota padrão mais rápida
  val Shortest = Value(1)
  //1 	Rota padrão mais curta
  val Walking = Value(2)
  //2 	Rota “a pé” (pedestre)
  val AvoidFerryBoat = Value(3)
  //6 	Rota evitando balsas.(Somente utilizando base rodoviária)
  val AvoidLocalRoad = Value(7)
  //7 	Rota evitando estradas de terra.(Somente utilizando base rodoviária)
  val AvoidFerryBoatAndLocalRoad = Value(8)
  //8 	Rota evitando balsas e estradas de terra.(Somente utilizando base rodoviária)
  val UseOnlyMainRoads = Value(9)
  //9 	Rota evitando estradas em condições precárias.(Somente utilizando base rodoviária)
  val AvoidToll = Value(10)
  //10 Rota evitando pedágios
  val UsingPublicTransportation = Value(21)
  //  * 	Rota com transporte público
  val AvoidTraffic = Value(23)
  //23 	Rota evitando o trânsito. (Somente utilizando base urbana, verificar disponibilidade)
  val StandardFastestWithTrafficTime = Value(24)
  //24 	Rota padrão mais rápida com o tempo considerando trânsito
  val StandardShortestWithTrafficTime = Value(25)
  //25 	Rota padrão mais curta com o tempo considerando trânsito
  val PriorizeBikeRoutes = Value(26) //26 ** 	Rota priorizando ciclovias, ciclofaixas e ciclorrotas
}
