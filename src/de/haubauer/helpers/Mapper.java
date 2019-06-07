package de.haubauer.helpers;

import it.avutils.jmapper.JMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    private static final String configurationPath = "src/de/haubauer/mappings.xml";

    /**
     * Mappt das angegebene Objekt zur angegebenen Klasse.
     * @param source Das Quellobjekt.
     * @param destinationClass Die Klasse, in das das Quellobjekt gemappt werden soll.
     * @param <TSource> Den Typ des Quellobjektes.
     * @param <TDestination> Den Typ des Zielobjektes.
     * @return Eine Instanz von TDestination, das die Werte des Quellobjektes enthält.
     */
    public static <TSource, TDestination> TDestination map(TSource source, Class<TDestination> destinationClass) {
        try {
            JMapper<TDestination, TSource> mapper = new JMapper<>(destinationClass, (Class<TSource>)source.getClass(), configurationPath);

            return mapper.getDestination(source);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Mappt das angegebene Objekt zur angegebenen Klasse.
     * @param source Die Quellliste, deren Inhalt gemappt werden soll.
     * @param destinationClass Die Klasse, in das die Inhalte gemappt werden soll.
     * @param <TSource> Den Typ der Quellobjekte.
     * @param <TDestination> Den Typ der Zielobjekte.
     * @return Eine ArrayList, die die Zielobjekte enthält.
     */
    public static <TSource, TDestination> List<TDestination> map(List<TSource> source, Class<TDestination> destinationClass) {
        JMapper<TDestination, TSource> mapper = new JMapper<>(destinationClass, (Class<TSource>)source.getClass(), configurationPath);

        return source.stream().map(mapper::getDestination).collect(Collectors.toList());
    }
}
