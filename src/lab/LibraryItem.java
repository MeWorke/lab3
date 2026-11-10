package lab;
/**
 * Абстрактный класс LibraryItem.
 * Абстрактное представление любого ресурса в библиотеке (книга, журнал,
 * электронная книга). Реализует поиск по основным атрибутам сущности.
 */
public abstract class LibraryItem implements ISearchable {
    protected int id;
    protected String title;
    protected int year;

    public LibraryItem(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    /**
     * Возвращает информацию о предмете библиотеки.
     *
     * @return строка с описанием предмета
     */
    public abstract String getInfo();

    /**
     * Проверяет, соответствует ли предмет поисковому запросу.
     * Поиск выполняется по основным атрибутам сущности:
     * название и год издания.
     *
     * @param query поисковый запрос
     * @return true, если запрос найден в атрибутах предмета
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
