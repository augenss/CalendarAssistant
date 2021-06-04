package com.augenss.repository

import org.jetbrains.exposed.sql.Database
import java.sql.DriverManager

class DbConnection {
    // DB_CLOSE_DELAY is needed because without it the db connection would close before we'd be able to do anything with it;
    // hbm2ddl closes the connection after creating the table, so h2 discards it
    // by doing so, h2 will keep db's content as long as the vm lives.
    fun connectToH2() = Database.connect({DriverManager.getConnection("jdbc:h2:mem:ca;DB_CLOSE_DELAY=-1")})
}