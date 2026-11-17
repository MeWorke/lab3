package lab;

/**
 * Интерфейс ISearchable.
 * Описывает предметы, которые можно найти по поисковому запросу.
 *
 * @author Emirbek Tsarikaev
 * @version 1.0
 */
public interface ISearchable {
    /**
     * Проверяет, соответствует ли предмет поисковому запросу.
     *
     * @param query поисковый запрос
     * @return {@code true}, если предмет соответствует запросу
     */
    boolean matches(String query);
}