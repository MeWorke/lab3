package lab;

/**
 * Интерфейс ISearchable.
 * Описывает предметы, которые можно найти по поисковому запросу.
 */
public interface ISearchable {
    /**
     * Проверяет, соответствует ли предмет поисковому запросу.
     *
     * @param query поисковый запрос (название, автор и т.д.)
     * @return true, если предмет соответствует запросу
     */
    boolean matches(String query);
}

