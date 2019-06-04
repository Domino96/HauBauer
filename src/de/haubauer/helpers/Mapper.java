package src.de.haubauer.helpers;

import it.avutils.jmapper.JMapper;

public class Mapper {
    private static final String configurationPath = "src/de/haubauer/mappings.xml";

    public static <TSource, TDestination> TDestination map(Class sourceClass, Class destinationClass, TSource source) {
        JMapper<TDestination, TSource> mapper = new JMapper<TDestination, TSource>(sourceClass, destinationClass, configurationPath);

        return mapper.getDestination(source);
    }
}
