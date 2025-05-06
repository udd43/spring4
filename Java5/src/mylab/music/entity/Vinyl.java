package mylab.music.entity;

/**
 * ���̴� ���ڵ� ��� ����
 */
public class Vinyl extends MusicMedia {
    private int rpm;  // ȸ�� �ӵ�

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("ȸ�� �ӵ�: %d rpm%n", rpm);
    }

    @Override
    public void play() {
        System.out.printf("���̴� ���ڵ� '%s'��(��) %drpm���� ����˴ϴ�.%n",
                          getTitle(), rpm);
    }

    /** ���̴� ���� û�� �޼��� */
    public void clean() {
        System.out.println("���̴� ���ڵ带 û���մϴ�.");
    }
}
