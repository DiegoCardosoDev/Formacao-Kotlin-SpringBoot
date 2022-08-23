package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.UsuarioRepo
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepo: UsuarioRepo) {


    fun buscarPorId(id: Long): Usuario {
        return usuarioRepo.getOne(id)


    }
}
