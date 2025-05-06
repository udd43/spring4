package mylab.music.entity;

/**
 * 디지털 미디어 공통 기능 구현
 */
public class DigitalMedia extends MusicMedia {
    private String format;  // ex: "MP3", "WAV" 등

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    @Override
    public void play() {
        System.out.printf("%s 형식의 '%s'이(가) 디지털로 재생됩니다.%n",
                          format, getTitle());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("포맷: %s%n", format);
    }

    protected String getFormat() {
        return format;
    }
}
