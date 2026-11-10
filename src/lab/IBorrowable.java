package lab;

/**
 * Интерфейс IBorrowable.
 * Описывает предметы, которые можно выдавать пользователям.
 */
public interface IBorrowable {
    /**
     * Выдает предмет пользователю.
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
     * @return true, если предмет можно взять
     */
    boolean isAvailable();
}
