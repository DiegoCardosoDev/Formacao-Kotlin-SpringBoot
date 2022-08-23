package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.repository.CursoRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val cursoRepo: CursoRepo) {


    fun buscarPorId(id: Long): Curso {
        return cursoRepo.getOne(id)
    }


}
