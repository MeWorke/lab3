package lab;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Library.
 * Управляет каталогом ресурсов и пользовательскими аккаунтами.
 */
public class Library {
    private List<LibraryItem> items;
    private List<User> users;

    public Library() {
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    /**
     * Добавляет новый предмет в библиотечный фонд.
     *
     * @param item новый предмет библиотеки
     */
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("В фонд добавлен: " + item.getInfo());
    }

    /**
     * Добавляет пользователя в систему библиотеки.
     *
     * @param user новый пользователь
     */
    public void addUser(User user) {
        users.add(user);
        System.out.println("Зарегистрирован пользователь: " + user.getName());
    }

    /**
     * Ищет предметы по поисковому запросу (название, автор, год и т.д.).
     *
     * @param query поисковый запрос
     * @return список предметов, соответствующих запросу
     */
    public List<LibraryItem> find(String query) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.matches(query)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Выдает выдаваемый предмет пользователю, если он доступен.
     *
     * @param item выдаваемый предмет
     * @param user пользователь
     */
    public void borrowItem(IBorrowable item, User user) {
        if (!items.contains((LibraryItem) item)) {
            System.out.println("Ошибка: данный предмет отсутствует в фонде библиотеки.");
            return;
        }
        item.borrow(user);
    }

    /**
     * Принимает возвращенный предмет и убирает его из списка
     * взятых у указанного пользователя.
     *
     * @param item возвращаемый предмет
     * @param user пользователь
     */
    public void returnItem(LibraryItem item, User user) {
        if (user.getBorrowedItems().contains(item) && item instanceof IBorrowable) {
            ((IBorrowable) item).returnItem();
            user.removeBorrowedItem(item);
        } else {
            System.out.println("Ошибка: этот предмет не числится за данным пользователем.");
        }
    }

    /**
     * Возвращает информацию о всех предметах библиотеки.
     *
     * @return строка с описанием фонда
     */
    public String getCatalogInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Каталог библиотеки (предметов: ").append(items.size()).append(") ===\n");
        for (LibraryItem item : items) {
            sb.append(item.getInfo()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Возвращает информацию о всех пользователях и их взятых предметах.
     *
     * @return строка с описанием пользователей
     */
    public String getUsersInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Пользователи библиотеки: ").append(users.size()).append(" ===\n");
        for (User user : users) {
            sb.append(user.getInfo());
        }
        return sb.toString();
    }
}
