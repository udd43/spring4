package mylab.book.entity;

public class Magazine extends Publication {
    private String publishPeriod;  // 예: "매월"

    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    public String getPublishPeriod() {
        return publishPeriod;
    }

    @Override
    public String toString() {
        return String.format("%s [잡지] 발행주기:%s, %d쪽, %d원, 출판일:%s",
            getTitle(), publishPeriod, getPage(), getPrice(), getPublishDate());
    }
}
