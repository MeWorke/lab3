package lab;

/**
 * Абстрактный класс LibraryItem.
 * Абстрактное представление любого ресурса в библиотеке (книга, журнал,
 * электронная книга). Реализует поиск по основным атрибутам сущности.
 *
 * @author Emirbek Tsarikaev
 * @version 1.0
 */
public abstract class LibraryItem implements ISearchable {
    /** Уникальный идентификатор предмета. */
    protected int id;
    /** Название предмета. */
    protected String title;
    /** Год издания/выпуска. */
    protected int year;

    /**
     * Создаёт предмет библиотеки с заданными атрибутами.
     *
     * @param id    уникальный идентификатор
     * @param title название
     * @param year  год издания
     */
    public LibraryItem(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    /**
     * Возвращает идентификатор предмета.
     *
     * @return id предмета
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название предмета.
     *
     * @return название
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает год издания.
     *
     * @return год
     */
    public int getYear() {
        return year;
    }

    /**
     * Возвращает строковое описание предмета.
     *
     * @return информация о предмете
     */
    public abstract String getInfo();

    /**
     * Проверяет, соответствует ли предмет поисковому запросу.
     * Поиск выполняется по названию и году издания.
     *
     * @param query поисковый запрос
     * @return {@code true}, если предмет соответствует запросу
     */
    @Override
    public boolean matches(String query) {
        if (query == null) {
            return false;
        }
        String q = query.trim().toLowerCase();
        return title.toLowerCase().contains(q)
                || String.valueOf(year).contains(q);
    }

    @Override
    public String toString() {
        return getInfo();
    }
}