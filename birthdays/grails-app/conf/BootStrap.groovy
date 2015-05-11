import com.meli.Role


class BootStrap {
   def init = { servletContext ->
      def adminRole = new Role(tipo: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(tipo: 'ROLE_USER').save(flush: true)
      
   }
}
