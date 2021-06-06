//package com.augenss.dao
//
//import com.augenss.model.User
//import com.augenss.model.Users
//import org.jetbrains.exposed.sql.Database
//import org.jetbrains.exposed.sql.SchemaUtils
//import org.jetbrains.exposed.sql.insert
//import org.jetbrains.exposed.sql.transactions.transaction
//
//class DaoDatabaseFacade(private val db: Database): DaoFacade {
//    override fun init() = transaction (db) {
//        SchemaUtils.create(Users)
//    }
//
//    override fun createUser(user: User) =
//        transaction(db) {
//            Users.insert {
//                it[Users.username] = user.username
//                it[Users.password] = user.password
//                it[Users.name] = user.name
//            }
//        }
//
//    override fun close() {
//        TODO("Not yet implemented")
//    }
//}