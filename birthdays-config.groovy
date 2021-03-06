dataSource {
	pooled = true
	driverClassName = 'com.mysql.jdbc.Driver'
	dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
}

environments {
    development {
        dataSource {
         //   dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
         //   url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			dbCreate = 'create'
			url = 'jdbc:mysql://localhost/meli_app?useUnicode=yes&charaterEncoding=UTF-8'
			username = 'root'
			password = 'root'
        }
    }
    test {
        dataSource {
         //   dbCreate = "update"
         //   url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			dbCreate = 'create'
			url = 'jdbc:mysql://localhost/meli_app?useUnicode=yes&charaterEncoding=UTF-8'
			username = 'root'
			password = 'root'
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            properties {
               // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
               jmxEnabled = true
               initialSize = 5
               maxActive = 50
               minIdle = 5
               maxIdle = 25
               maxWait = 10000
               maxAge = 10 * 60000
               timeBetweenEvictionRunsMillis = 5000
               minEvictableIdleTimeMillis = 60000
               validationQuery = "SELECT 1"
               validationQueryTimeout = 3
               validationInterval = 15000
               testOnBorrow = true
               testWhileIdle = true
               testOnReturn = false
               jdbcInterceptors = "ConnectionState"
               defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}