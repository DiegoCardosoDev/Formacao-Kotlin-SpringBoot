package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import br.com.alura.forum.repository.TopicoRepo
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
        private var topicoRepo: TopicoRepo,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoFormMapper: TopicoFormMapper,
        private val notFoundMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicoRepo.findAll().stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicoRepo.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topicoRepo.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicoRepo.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo=form.titulo
        topico.mensagem=form.mensagem
        return topicoViewMapper.map(topico)

    }

    fun deletar(id: Long) {
       topicoRepo.deleteById(id)
    }

}