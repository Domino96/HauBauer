package de.haubauer.helpers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Mappt die angegebenen Quellobjekte zur angegebenen Klasse. Bevorzuge die TypeToken-Variante.
     * @param source Eine Liste von Quellobjekten.
     * @param destinationClass Die Klasse, in die gecastet werden soll.
     * @param <TSource> Den Typ des Quellobjektes.
     * @param <TDestination> Den Typ des Zielobjektes.
     * @return Eine Liste von TDestination, das die Zielobjekte enthält.
     */
    public <TSource, TDestination> List<TDestination> map(List<TSource> source, Class<TDestination> destinationClass) {
        return source.stream().map(s -> this.modelMapper.map(s, destinationClass)).collect(Collectors.toList());
    }

    /**
     * Mappt die angegebenen Quellobjekte zur angegebenen Klasse.
     * @param source Eine Liste von Quellobjekten.
     * @param typeToken Ein TypeToken, der mit dem Zieltyp der Liste übereinstimmt. Z.B. {@code new TypeToken<List<Entity>>() {}}
     * @param <TSource> Den Typ des Quellobjektes.
     * @param <TDestination> Den Typ des Zielobjektes.
     * @return Eine Liste von TDestination, das die Zielobjekte enthält.
     */
    public <TSource, TDestination> List<TDestination> map(List<TSource> source, TypeToken<List<TDestination>> typeToken) {
        return this.modelMapper.map(source, typeToken.getType());
    }
}
