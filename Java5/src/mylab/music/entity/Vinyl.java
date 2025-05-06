package mylab.music.entity;

/**
 * 바이닐 레코드 재생 구현
 */
public class Vinyl extends MusicMedia {
    private int rpm;  // 회전 속도

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("회전 속도: %d rpm%n", rpm);
    }

    @Override
    public void play() {
        System.out.printf("바이닐 레코드 '%s'이(가) %drpm으로 재생됩니다.%n",
                          getTitle(), rpm);
    }

    /** 바이닐 전용 청소 메서드 */
    public void clean() {
        System.out.println("바이닐 레코드를 청소합니다.");
    }
}
