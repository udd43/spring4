package mylab.music.entity;

/**
 * ��� ���� �̵���� ���� ��� ���� (�߻� Ŭ����)
 */
public abstract class MusicMedia {
    private String title;
    private String artist;

    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /** �̵� ��� ����� ����Ŭ�������� �ݵ�� ���� */
    public abstract void play();

    /** ���񡤾�Ƽ��Ʈ ���� ��� */
    public void displayInfo() {
        System.out.printf("����: %s, ��Ƽ��Ʈ: %s%n", title, artist);
    }

    protected String getTitle() {
        return title;
    }

    protected String getArtist() {
        return artist;
    }
}
