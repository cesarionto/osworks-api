package br.com.cesario.osworksapi.domain.service;

import br.com.cesario.osworksapi.domain.exception.NegocioException;
import br.com.cesario.osworksapi.domain.model.Cliente;
import br.com.cesario.osworksapi.domain.model.OrdemServico;
import br.com.cesario.osworksapi.domain.model.StatusOrdemServico;
import br.com.cesario.osworksapi.domain.repository.ClienteRepository;
import br.com.cesario.osworksapi.domain.repository.OrdemServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class GestaoOrdemServicoService {

    private OrdemServicoRepository ordemServicoRepository;
    private ClienteRepository clienteRepository;

    public OrdemServico criar (OrdemServico ordemServico){
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId()).orElseThrow(
                ()-> new NegocioException("Cliente não Encontrado")
        );
        ordemServico.setCliente(cliente);
        ordemServico.setStatusOrdemServico(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertuta(LocalDateTime.now());
        return  ordemServicoRepository.save(ordemServico);
    }
}
