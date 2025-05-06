package mylab.music.entity;

/**
 * MP3 파일 재생 구현
 */
public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;   // MB
    private int volume;     // 현재 볼륨 레벨

    /** 주 생성자: 파일 크기와 함께, 초기 볼륨은 5로 설정 */
    public MP3(String title, String artist, int fileSize) {
        super(title, artist, "MP3");
        this.fileSize = fileSize;
        this.volume = 5;
    }

    /** 부 생성자: 제목만 주면 나머지는 기본값으로 설정 */
    public MP3(String title) {
        this(title, "Unknown", 0);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // 제목·아티스트·포맷
        System.out.printf("파일 크기: %dMB%n", fileSize);
    }

    @Override
    public void play() {
        super.play();         // "MP3 형식의 '...'이(가) 디지털로 재생됩니다."
        System.out.printf("현재 볼륨: %d%n", volume);
    }

    @Override
    public void setVolume(int level) {
        this.volume = level;
        System.out.printf("볼륨이 %d로 설정되었습니다.%n", level);
    }

    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }
}
