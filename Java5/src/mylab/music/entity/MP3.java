package mylab.music.entity;

/**
 * MP3 ���� ��� ����
 */
public class MP3 extends DigitalMedia implements Playable {
    private int fileSize;   // MB
    private int volume;     // ���� ���� ����

    /** �� ������: ���� ũ��� �Բ�, �ʱ� ������ 5�� ���� */
    public MP3(String title, String artist, int fileSize) {
        super(title, artist, "MP3");
        this.fileSize = fileSize;
        this.volume = 5;
    }

    /** �� ������: ���� �ָ� �������� �⺻������ ���� */
    public MP3(String title) {
        this(title, "Unknown", 0);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // ���񡤾�Ƽ��Ʈ������
        System.out.printf("���� ũ��: %dMB%n", fileSize);
    }

    @Override
    public void play() {
        super.play();         // "MP3 ������ '...'��(��) �����з� ����˴ϴ�."
        System.out.printf("���� ����: %d%n", volume);
    }

    @Override
    public void setVolume(int level) {
        this.volume = level;
        System.out.printf("������ %d�� �����Ǿ����ϴ�.%n", level);
    }

    @Override
    public void stop() {
        System.out.println("MP3 ����� �����Ǿ����ϴ�.");
    }
}
