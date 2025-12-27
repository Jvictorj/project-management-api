package dev.java10x.GestaoDeProjetos.Consultor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ConsultorService {

    //Injeção de dependencia para dar ao service acesso ao repository
    private ConsultorRepository consultorRepository;
    private  ConsultorMapper consultorMapper;

    public ConsultorService(ConsultorRepository consultorRepository, ConsultorMapper consultorMapper) {
        this.consultorRepository = consultorRepository;
        this.consultorMapper = consultorMapper;
    }

    public List<ConsultorDTO> listarConsultor() {
        List<ConsultorModel> listarConsultor = consultorRepository.findAll();
        return listarConsultor.stream()
                .map(consultorMapper::map)
                .collect(Collectors.toList());
    }

    public ConsultorDTO listarConsultorPorId(Long id) {
        Optional<ConsultorModel> consultorPorId = consultorRepository.findById(id);
        return consultorPorId.map(consultorMapper::map).orElse(null);
    }

    public ConsultorDTO criarConsultor(ConsultorDTO consultorDTO) {
        ConsultorModel consultor = consultorMapper.map(consultorDTO);
        consultor = consultorRepository.save(consultor);
        return consultorMapper.map(consultor);
    }

    public void deletarConsultorPorId(Long id) {
        consultorRepository.deleteById(id);
    }

    public  ConsultorDTO atualizarConsultor (Long id, ConsultorDTO consultorDTO) {
        Optional<ConsultorModel> atualizarConsultorPorId = consultorRepository.findById(id);
        if (atualizarConsultorPorId.isPresent()) {
            ConsultorModel atualizarConsultor = consultorMapper.map(consultorDTO);
            atualizarConsultor.setId(id);
            ConsultorModel consultorSave = consultorRepository.save(atualizarConsultor);
            return consultorMapper.map(consultorSave);
        }
        return null;
    }
}
