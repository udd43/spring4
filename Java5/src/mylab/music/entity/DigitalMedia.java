package mylab.music.entity;

/**
 * ������ �̵�� ���� ��� ����
 */
public class DigitalMedia extends MusicMedia {
    private String format;  // ex: "MP3", "WAV" ��

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    @Override
    public void play() {
        System.out.printf("%s ������ '%s'��(��) �����з� ����˴ϴ�.%n",
                          format, getTitle());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("����: %s%n", format);
    }

    protected String getFormat() {
        return format;
    }
}
