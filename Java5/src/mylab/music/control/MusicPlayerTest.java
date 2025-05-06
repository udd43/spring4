package mylab.music.control;

import mylab.music.entity.*;

/**
 * Sample Run �� �����ϰ� �����ϴ� �׽�Ʈ Ŭ����
 */
public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("===== ���� ��� �ý��� �׽�Ʈ =====\n");

        // --- MP3 �׽�Ʈ ---
        System.out.println("--- MP3 �׽�Ʈ ---");
        MP3 mp3 = new MP3("Dynamite", "BTS", 5);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(8);
        mp3.play();
        mp3.stop();
        System.out.println();

        // --- Vinyl �׽�Ʈ ---
        System.out.println("--- Vinyl �׽�Ʈ ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();
        System.out.println();

        // --- ������ �׽�Ʈ ---
        System.out.println("--- ������ �׽�Ʈ ---");
        MusicMedia media = new MP3("Butter", "BTS", 4);
        media.displayInfo();
        media.play();
        System.out.println();

        // --- ĳ���� �׽�Ʈ ---
        System.out.println("--- ĳ���� �׽�Ʈ ---");
        Playable player = (Playable) media;
        player.setVolume(3);
        media.play();
        player.setVolume(7);
        player.stop();
    }
}
