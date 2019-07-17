package msm.sc.routes

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.PathDirectives.pathEndOrSingleSlash
import akka.http.scaladsl.server.directives.RouteDirectives.complete

/**
 * Encompass all service routes.
 */
object BaseRoutes {

  lazy val baseRoutes: Route =
    /*
     * Path root (`/`).
     */
    pathEndOrSingleSlash {
      complete("Server up and running")
    }
}
