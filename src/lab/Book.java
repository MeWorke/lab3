package lab;

/**
 * Класс Book.
 * Книга с информацией об авторе и количестве страниц.
 * Является выдаваемым предметом (реализует IBorrowable).
 */
public class Book extends LibraryItem implements IBorrowable {
    private String author;
    private int pages;
    private boolean available;

    public Book(int id, String title, int year, String author, int pages) {
        super(id, title, year);
        this.author = author;
        this.pages = pages;
        this.available = true; // новая книга сразу доступна
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void borrow(User user) {
        if (!isAvailable()) {
            System.out.println("Книга \"" + title + "\" недоступна для выдачи.");
            return;
        }
        available = false;
        user.addBorrowedItem(this);
        System.out.println("Книга \"" + title + "\" выдана пользователю " + user.getName() + ".");
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("Книга \"" + title + "\" возвращена в библиотеку.");
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean matches(String query) {
        // Поиск по основным атрибутам: название, год, автор
        if (super.matches(query)) {
            return true;
        }
        return author.toLowerCase().contains(query.trim().toLowerCase());
    }

    @Override
    public String getInfo() {
        return String.format("[Книга] id=%d | \"%s\" | автор: %s | год: %d | страниц: %d | доступна: %s",
                id, title, author, year, pages, available ? "да" : "нет");
    }
}
