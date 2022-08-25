package br.com.alura.forum.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val javaMailSender: JavaMailSender
) {
    fun notificar(autor:String) {

        val message = SimpleMailMessage()
        message.setSubject("[Alura] Resposta recebida")
        message.setText("Ola, seu tópico tem uma resposta, vamos confereir?")
        message.setTo(autor)
        javaMailSender.send(message)

    }
}

