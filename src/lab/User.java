package lab;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс User.
 * Зарегистрированный пользователь библиотеки, который может брать
 * и возвращать предметы. Поддерживает список взятых предметов.
 */
public class User {
    private int id;
    private String name;
    private List<LibraryItem> borrowedItems;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Добавляет предмет в список взятых пользователем.
     *
     * @param item взятый предмет
     */
    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    /**
     * Удаляет предмет из списка взятых пользователем (при возврате).
     *
     * @param item возвращаемый предмет
     */
    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    /**
     * Возвращает список предметов, взятых данным пользователем.
     *
     * @return список взятых предметов
     */
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    /**
     * Возвращает информацию о пользователе и его взятых предметах.
     *
     * @return строка с описанием пользователя
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Пользователь] id=%d | имя: %s | взято предметов: %d%n",
                id, name, borrowedItems.size()));
        if (!borrowedItems.isEmpty()) {
            sb.append("  Взятые предметы:\n");
            for (LibraryItem item : borrowedItems) {
                sb.append("    - ").append(item.getInfo()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
