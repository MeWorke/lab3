package lab;

/**
 * Класс Journal.
 * Журнал с указанием номера выпуска.
 * Является выдаваемым предметом (реализует IBorrowable).
 *
 * @author Emirbek Tsarikaev
 * @version 1.0
 */
public class Journal extends LibraryItem implements IBorrowable {
    /** Номер выпуска журнала. */
    private int issueNumber;
    /** Флаг доступности для выдачи. */
    private boolean available;

    /**
     * Создаёт новый журнал.
     *
     * @param id          идентификатор
     * @param title       название
     * @param year        год выпуска
     * @param issueNumber номер выпуска
     */
    public Journal(int id, String title, int year, int issueNumber) {
        super(id, title, year);
        this.issueNumber = issueNumber;
        this.available = true; // новый журнал сразу доступен
    }

    /**
     * Возвращает номер выпуска.
     *
     * @return номер выпуска
     */
    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void borrow(User user) {
        if (!isAvailable()) {
            System.out.println("Журнал \"" + title + "\" недоступен для выдачи.");
            return;
        }
        available = false;
        user.addBorrowedItem(this);
        System.out.println("Журнал \"" + title + "\" (выпуск №" + issueNumber
                + ") выдан пользователю " + user.getName() + ".");
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("Журнал \"" + title + "\" (выпуск №" + issueNumber
                + ") возвращён в библиотеку.");
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean matches(String query) {
        // Поиск по основным атрибутам: название, год, номер выпуска
        if (super.matches(query)) {
            return true;
        }
        return String.valueOf(issueNumber).contains(query.trim());
    }

    @Override
    public String getInfo() {
        return String.format("[Журнал] id=%d | \"%s\" | год: %d | выпуск №%d | доступен: %s",
                id, title, year, issueNumber, available ? "да" : "нет");
    }
}