package br.com.cesario.osworksapi.domain.repository;

import br.com.cesario.osworksapi.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
