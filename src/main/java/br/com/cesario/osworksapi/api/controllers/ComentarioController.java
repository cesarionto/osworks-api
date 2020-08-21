package br.com.cesario.osworksapi.api.controllers;

import br.com.cesario.osworksapi.api.model.ComentarioModel;
import br.com.cesario.osworksapi.api.model.ComentarioModelInput;
import br.com.cesario.osworksapi.domain.exception.EntidadeNãoEncontradaExceptions;
import br.com.cesario.osworksapi.domain.model.Comentario;
import br.com.cesario.osworksapi.domain.model.OrdemServico;
import br.com.cesario.osworksapi.domain.repository.OrdemServicoRepository;
import br.com.cesario.osworksapi.domain.service.GestaoOrdemServicoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordens-servico/{id}/comentarios")
@AllArgsConstructor
public class ComentarioController {

    private GestaoOrdemServicoService gestaoOrdemServicoService;
    private OrdemServicoRepository ordemServicoRepository;
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioModel adicionar(@Valid @PathVariable Long id, @RequestBody ComentarioModelInput comentarioModelInput){
        Comentario comentario = gestaoOrdemServicoService
                .adicionarComentario(id, comentarioModelInput.getDescricao());
        return toModel(comentario);
    }

    @GetMapping
    public List<ComentarioModel> listar(@PathVariable Long id){
        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElseThrow(()-> new EntidadeNãoEncontradaExceptions("Ordem de serviço não encontrada"));

        return toCollectionModel(ordemServico.getComentarios());
    }

    private ComentarioModel toModel(Comentario comentario){
        return  modelMapper.map(comentario, ComentarioModel.class);
    }

    private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios){
        return comentarios.stream().map(comentario -> toModel(comentario))
                .collect(Collectors.toList());
    }
}
