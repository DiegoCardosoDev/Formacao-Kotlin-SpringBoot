package br.com.alura.forum.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {

    private val expiration: Long=6000
    @Value(value = "\${jwt.secret}")
    private lateinit var secret:String

    fun generateToken(username: String):String?{
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis()+expiration))
            .signWith(SignatureAlgorithm.ES512,secret.toByteArray())
            .compact()

    }
}