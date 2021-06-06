package com.augenss.dao

import com.augenss.model.User
import java.io.Closeable

interface DaoFacade: Closeable {
    fun init()
    fun createUser(user: User)
}