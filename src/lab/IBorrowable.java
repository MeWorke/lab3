package lab;

/**
 * Интерфейс IBorrowable.
 * Описывает предметы, которые можно выдавать пользователям.
 *
 * @author Emirbek Tsarikaev
 * @version 1.0
 */
public interface IBorrowable {
    /**
     * Выдаёт предмет пользователю.
     *
     * @param user пользователь библиотеки
     */
    void borrow(User user);

    /**
     * Возвращает предмет в библиотеку.
     */
    void returnItem();

    /**
     * Проверяет, доступен ли предмет для выдачи.
     *
     * @return {@code true}, если предмет можно взять
     */
    boolean isAvailable();
}