package mylab.book.entity;

public class ReferenceBook extends Publication {
    private String field;  // 예: "소프트웨어공학"

    public ReferenceBook(String title, String publishDate, int page,
                         int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return String.format("%s [참고서] 분야:%s, %d쪽, %d원, 출판일:%s",
            getTitle(), field, getPage(), getPrice(), getPublishDate());
    }
}
