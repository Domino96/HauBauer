package de.haubauer.helpers;

import org.modelmapper.ModelMapper;

/**
 * Ein Wrapper für ModelMapper, um das Mapping zwischen Entity (Datenschicht) und Model (Logikschicht) zu vereinfachen.
 */
public class Mapper {
    private static Mapper instance;
    private ModelMapper modelMapper = new ModelMapper();

    private Mapper() { }

    public static Mapper getInstance() {
        if (Mapper.instance == null) {
            Mapper.instance = new Mapper();
        }

        return Mapper.instance;
    }

    /**
     * Mappt das angegebene Objekt zur angegebenen Klasse.
     * @param source Das Quellobjekt.
     * @param destinationClass Die Klasse, in das das Quellobjekt gemappt werden soll.
     * @param <TSource> Den Typ des Quellobjektes.
     * @param <TDestination> Den Typ des Zielobjektes.
     * @return Eine Instanz von TDestination, das die Werte des Quellobjektes enthält.
     */
    public <TSource, TDestination> TDestination map(TSource source, Class<TDestination> destinationClass) {
        return this.modelMapper.map(source, destinationClass);
    }
}
