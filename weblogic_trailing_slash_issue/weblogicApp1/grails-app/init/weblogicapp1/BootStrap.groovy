package weblogicapp1

class BootStrap {

    def init = { servletContext ->
        //new ProductAnnouncement(message: 'Launch day').save()
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role('ROLE_USER').save()
        //def userRole = new Role('ROLE_USER').save()

        def me = new User('CBUNTE3', '111111').save()

        UserRole.create me, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

    }
    def destroy = {
    }
}
