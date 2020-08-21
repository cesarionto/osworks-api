package br.com.cesario.osworksapi.domain.service;

import br.com.cesario.osworksapi.domain.exception.EntidadeNãoEncontradaExceptions;
import br.com.cesario.osworksapi.domain.exception.NegocioException;
import br.com.cesario.osworksapi.domain.model.Cliente;
import br.com.cesario.osworksapi.domain.model.Comentario;
import br.com.cesario.osworksapi.domain.model.OrdemServico;
import br.com.cesario.osworksapi.domain.model.StatusOrdemServico;
import br.com.cesario.osworksapi.domain.repository.ClienteRepository;
import br.com.cesario.osworksapi.domain.repository.ComentarioRepository;
import br.com.cesario.osworksapi.domain.repository.OrdemServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class GestaoOrdemServicoService {

    private OrdemServicoRepository ordemServicoRepository;
    private ClienteRepository clienteRepository;
    private ComentarioRepository comentarioRepository;

    public OrdemServico criar (OrdemServico ordemServico){
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId()).orElseThrow(
                ()-> new NegocioException("Cliente não Encontrado")
        );
        ordemServico.setCliente(cliente);
        ordemServico.setStatusOrdemServico(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertuta(OffsetDateTime.now());
        return  ordemServicoRepository.save(ordemServico);
    }

    public Comentario adicionarComentario(Long ordemServicoId, String descricao){
        OrdemServico ordemServico = buscar(ordemServicoId);

        Comentario comentario = new Comentario();
        comentario.setDataEnvio(OffsetDateTime.now());
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);

        return comentarioRepository.save(comentario);
    }

    private OrdemServico buscar(Long ordemServicoId) {
        return ordemServicoRepository
                .findById(ordemServicoId)
                .orElseThrow(
                        () -> new EntidadeNãoEncontradaExceptions("Ordem de servico não encontrada")
                );
    }

    public void finalizar(Long id){
        OrdemServico ordemServico = buscar(id);
        ordemServico.finalizar();
        ordemServicoRepository.save(ordemServico);
    }

}
