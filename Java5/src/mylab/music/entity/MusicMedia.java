package mylab.music.entity;

/**
 * 모든 음악 미디어의 공통 기능 정의 (추상 클래스)
 */
public abstract class MusicMedia {
    private String title;
    private String artist;

    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /** 미디어별 재생 방식은 서브클래스에서 반드시 구현 */
    public abstract void play();

    /** 제목·아티스트 정보 출력 */
    public void displayInfo() {
        System.out.printf("제목: %s, 아티스트: %s%n", title, artist);
    }

    protected String getTitle() {
        return title;
    }

    protected String getArtist() {
        return artist;
    }
}
