package msm.sc.routes

import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport.defaultNodeSeqMarshaller
import akka.http.scaladsl.server.directives.MethodDirectives.get
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.http.scaladsl.server.Directives._

/**
 * Routes for Service Discovery (lookup & register).
 */
trait ServiceDiscovery {

  lazy val sdRoutes =
    /**
     * Look up for a service by its name.
     */
    path("lookup") {
      get {
        parameter("name") { (name) =>
          complete(s"Service $name is not available because Service Discovery" +
            " is not implemented yet.")
        }
      }
    }
}
