package br.com.cesario.osworksapi.api.controllers;

import br.com.cesario.osworksapi.api.model.OrdemServicoInput;
import br.com.cesario.osworksapi.api.model.OrdemServicoModel;
import br.com.cesario.osworksapi.domain.model.OrdemServico;
import br.com.cesario.osworksapi.domain.repository.OrdemServicoRepository;
import br.com.cesario.osworksapi.domain.service.GestaoOrdemServicoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordens-servico")
@AllArgsConstructor
public class OrdemServicoController {

    private GestaoOrdemServicoService gestaoOrdemServicoService;
    private OrdemServicoRepository ordemServicoRepository;
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoModel criar(@Valid @RequestBody OrdemServicoInput ordemServicoInputModel){
        OrdemServico ordemServico = toEntity(ordemServicoInputModel);
        return toModel(gestaoOrdemServicoService.criar(ordemServico));
    }

    @GetMapping
    public List<OrdemServicoModel> listar(){
        return toColectionModel(ordemServicoRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long id){
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
        if (ordemServico.isPresent()){
            OrdemServicoModel model =  toModel(ordemServico.get());
            return ResponseEntity.ok(model);
        }
        return ResponseEntity.notFound().build();
    }

    private OrdemServicoModel toModel(OrdemServico ordemServico){
        return modelMapper.map(ordemServico, OrdemServicoModel.class);
    }

    private List<OrdemServicoModel> toColectionModel(List<OrdemServico> ordemServicos){
        return ordemServicos.stream().map(ordemServico -> toModel(ordemServico))
                .collect(Collectors.toList());
    }

    private OrdemServico toEntity(OrdemServicoInput ordemServicoInput){
        return modelMapper.map(ordemServicoInput, OrdemServico.class);
    }

}
