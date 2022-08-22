package br.com.diego.forum.model

import br.com.diego.forum.enum.StatusTopico
import java.time.LocalDateTime

data class Topico(
        val id: Long?=null,
        val titulo: String?,
        val mensagem: String?,
        val data: LocalDateTime = LocalDateTime.now(),
        val curso: Course,
        val author: User,
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
        val respostas:List<Resposta> = ArrayList()

)