package utils

import play.api.http.HttpFilters
import play.api.mvc.EssentialFilter
import play.filters.cors.CORSFilter
import play.filters.csrf.CSRFFilter
import play.filters.headers.SecurityHeadersFilter

import javax.inject.Inject

/**
 * Предоставляет фильтры.
 */
class Filters @Inject() (csrfFilter: CSRFFilter, securityHeadersFilter: SecurityHeadersFilter, corsFilter: CORSFilter) extends HttpFilters {
  override def filters: Seq[EssentialFilter] = Seq(csrfFilter, securityHeadersFilter, corsFilter)
}
