package br.com.diego.forum.model

import java.time.LocalDateTime

data class Resposta(
        val id: Long?,
        val mensagem: String?,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        val author: User,
        val topico: Topico,
        val solution: Boolean?
)