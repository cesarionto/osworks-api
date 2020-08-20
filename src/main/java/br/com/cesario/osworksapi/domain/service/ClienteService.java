package br.com.cesario.osworksapi.domain.service;

import br.com.cesario.osworksapi.domain.exception.NegocioException;
import br.com.cesario.osworksapi.domain.model.Cliente;
import br.com.cesario.osworksapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteExistente != null && !clienteExistente.equals(cliente))
            throw new NegocioException("email já cadastrado");
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}