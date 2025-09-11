package dev.java10x.GestaoDeProjetos.Projetos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProjetoService {

    private ProjetoRepository projetoRepository;

    private  ProjetoMapper projetoMapper;

    public ProjetoService(ProjetoRepository projetoRepository, ProjetoMapper projetoMapper) {
        this.projetoRepository = projetoRepository;
        this.projetoMapper = projetoMapper;
    }

    public List<ProjetoDTO> listarProjeto () {
        List<ProjetosModel> listarProjeto = projetoRepository.findAll();
        return listarProjeto.stream()
                .map(projetoMapper::map)
                .collect(Collectors.toList());
    }

    public ProjetoDTO listarProjetoPorId (Long id) {
        Optional<ProjetosModel> projetoPorId = projetoRepository.findById(id);
        return projetoPorId.map(projetoMapper::map).orElse(null);
    }

    public ProjetoDTO criarProjeto (ProjetoDTO projetoDTO) {
        ProjetosModel projeto = projetoMapper.map(projetoDTO);
        projeto = projetoRepository.save(projeto);
        return projetoMapper.map(projeto);
    }

    public ProjetoDTO atualizarProjeto (Long id, ProjetoDTO alterarProjetoDTO) {
        Optional<ProjetosModel> alterarProjetoPorId = projetoRepository.findById(id);
        if (alterarProjetoPorId.isPresent()) {
            ProjetosModel alterarProjeto = projetoMapper.map(alterarProjetoDTO);
            alterarProjeto.setId(id);
            ProjetosModel alterarProjetoSave = projetoRepository.save(alterarProjeto);
            return projetoMapper.map(alterarProjetoSave);
        }
        return null;
    }

    public void deletarProjetoPorId (Long id) {
        projetoRepository.deleteById(id);
    }

}
