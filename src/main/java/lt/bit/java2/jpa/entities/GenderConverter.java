package lt.bit.java2.jpa.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Character> {
    @Override
    public Character convertToDatabaseColumn(Gender attribute) {
        if (attribute == null) {
            return null;
        }
        switch (attribute) {
            case M:
                return 'M';
            case F:
                return 'F';
            default:
                throw new IllegalArgumentException("Unknown" + attribute);
        }    }

    @Override
    public Gender convertToEntityAttribute(Character dbData) {
        if (dbData == null) {
            return null;
        }
        switch (dbData) {
            case 'M':
                return Gender.M;
            case 'F':
                return Gender.F;
            default:
                throw new IllegalArgumentException("Unknown" + dbData);
        }
    }
}
