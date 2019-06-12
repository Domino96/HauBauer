package de.haubauer.db;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;

/**
 * Ein QueryBuilder für die Entity T.
 * @param <T> Die Klasse der Entity, für die eine Query gebaut werden soll.
 */
public class QueryBuilder<T> {
    private Class<T> entityClass;
    private Session session;
    private String hql;
    private HashMap<String, Object> parameters = new HashMap<>();

    /**
     * Dieser Konstruktor sollte nie manuell aufgerufen werden, sondern stehts von einer Dao-Klasse gecallt werden.
     */
    QueryBuilder(Session session, Class<T> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
        this.hql = "from " + entityClass.getSimpleName() + " r";
    }

    /**
     * Filtert die Query nach der angegebenen Where-Bedingung. Kann auch NamedParameter enthalten.
     * @param whereFieldName Das Feld, nach dem gefiltert werden soll.
     * @param comparer Der Vergleichsoperator mit dem Vergleichswert.
     * @return this
     */
    public QueryBuilder<T> where(String whereFieldName, String comparer) {
        this.hql += " WHERE r." + whereFieldName + " " + comparer;

        return this;
    }

    /**
     * Filtert die Query nach der angegebenen Where-Bedingung. Kann auch NamedParameter enthalten.
     * @param whereFieldName Das Feld, nach dem gefiltert werden soll.
     * @param comparisonOperator Der Vergleichsoperator.
     * @param comparedValue Der verglichene Wert.
     * @return this
     */
    public QueryBuilder<T> where(String whereFieldName, String comparisonOperator, Object comparedValue) {
        this.hql += " WHERE r." + whereFieldName + " " + comparisonOperator + " " + comparedValue;

        return this;
    }

    /**
     * Filtert die Query nach der angegebenen Where-Bedingung. Kann auch NamedParameter enthalten.
     * @param whereClause Die Where-Klausel, ohne das vorangehende WHERE.
     * @return this
     */
    public QueryBuilder<T> where(String whereClause) {
        if (!whereClause.toLowerCase().startsWith("where")) {
            this.hql += " where";
        }

        this.hql += " " + whereClause;

        return this;
    }

    /**
     * Sortiert die Query nach dem angegebenen Feld.
     * @param fieldToSortBy Das Feld, nach dem sortiert werden soll.
     * @param descending Ob die Sortierung absteigend sein soll.
     * @return this
     */
    public QueryBuilder<T> orderBy(String fieldToSortBy, boolean descending) {
        this.hql += " ORDER BY r." + fieldToSortBy + " " + (descending ? "DESC" : "ASC");

        return this;
    }

    /**
     * Gruppiert die Datensätze nach dem angegebenen Feld.
     * @param fieldToGroupBy Das Feld, nach dem gruppiert werden soll.
     * @return this
     */
    public QueryBuilder<T> groupBy(String fieldToGroupBy) {
        this.hql += " GROUP BY r." + fieldToGroupBy;

        return this;
    }

    /**
     * Setzt den gewählten NamedParameter. Muss irgendwo in der Query enthalten sein.
     * @param parameterName Der Name des NamedParameters.
     * @param value Der Wert des NamedParameters.
     * @return this
     */
    public QueryBuilder<T> setParameter(String parameterName, Object value) {
        this.parameters.put(parameterName, value);

        return this;
    }

    /**
     * Baut die Hibernate Query, um danach list() davon aufzurufen.
     * @return Eine Hibernate Query.
     */
    public Query<T> build() {
        final Query<T> query = this.session.createQuery(this.hql, this.entityClass);

        this.parameters.forEach(query::setParameter);

        return query;
    }
}
