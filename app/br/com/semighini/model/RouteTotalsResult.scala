package br.com.semighini.model

import org.joda.time.{Period, DateTime}

/**
 * Created with IntelliJ IDEA.
 * User: dirceu
 * Date: 04/10/13
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
case class RouteTotalsResult(totalDistance: BigDecimal = BigDecimal(0),
                             totalfuelCost: BigDecimal = BigDecimal(0), totalCost: BigDecimal = BigDecimal(0),
                             totalTime: Period = new Period(0l))