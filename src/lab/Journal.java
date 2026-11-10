package lab;

/**
 * Класс Journal.
 * Журнал с указанием номера выпуска.
 * Является выдаваемым предметом (реализует IBorrowable).
 */
public class Journal extends LibraryItem implements IBorrowable {
    private int issueNumber;
    private boolean available;

    public Journal(int id, String title, int year, int issueNumber) {
        super(id, title, year);
        this.issueNumber = issueNumber;
        this.available = true; // новый журнал сразу доступен
    }

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
                + ") возвращен в библиотеку.");
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

