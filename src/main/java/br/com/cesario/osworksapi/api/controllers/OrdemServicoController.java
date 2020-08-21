package br.com.cesario.osworksapi.api.controllers;

import br.com.cesario.osworksapi.domain.model.OrdemServico;
import br.com.cesario.osworksapi.domain.service.GestaoOrdemServicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordens-servico")
@AllArgsConstructor
public class OrdemServicoController {

    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico){
        return gestaoOrdemServicoService.criar(ordemServico);
    }

}
