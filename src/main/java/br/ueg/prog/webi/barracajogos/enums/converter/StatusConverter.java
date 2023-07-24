package br.ueg.prog.webi.barracajogos.enums.converter;

import br.ueg.prog.webi.barracajogos.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Classe de conversão JPA referente ao enum {@link Status}.
 *
 * @author UEG
 */
@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status != null ? status.getId() : null;
    }

    @Override
    public Status convertToEntityAttribute(String id) {
        return Status.getById(id);
    }

}