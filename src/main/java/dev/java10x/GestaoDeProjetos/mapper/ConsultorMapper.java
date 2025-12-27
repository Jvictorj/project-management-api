package dev.java10x.GestaoDeProjetos.mapper;

import dev.java10x.GestaoDeProjetos.dto.ConsultorDTO;
import dev.java10x.GestaoDeProjetos.model.ConsultorModel;
import org.springframework.stereotype.Component;

@Component
public class ConsultorMapper {

    public ConsultorModel map(ConsultorDTO consultorDTO) {
        ConsultorModel consultorModel = new ConsultorModel();

        consultorModel.setId(consultorDTO.getId());
        consultorModel.setNome(consultorDTO.getNome());
        consultorModel.setEmail(consultorDTO.getEmail());
        consultorModel.setIdade(consultorDTO.getIdade());
        consultorModel.setCargo(consultorDTO.getCargo());
        consultorModel.setFrase(consultorDTO.getFrase());
        consultorModel.setProjetos(consultorDTO.getProjetos());

        return consultorModel;
    }

    public ConsultorDTO map(ConsultorModel consultorModel) {
        ConsultorDTO consultorDTO = new ConsultorDTO();

        consultorDTO.setId(consultorModel.getId());
        consultorDTO.setNome(consultorModel.getNome());
        consultorDTO.setEmail(consultorModel.getEmail());
        consultorDTO.setIdade(consultorModel.getIdade());
        consultorDTO.setCargo(consultorModel.getCargo());
        consultorDTO.setFrase(consultorModel.getFrase());
        consultorDTO.setProjetos(consultorModel.getProjetos());

        return consultorDTO;
    }
}
