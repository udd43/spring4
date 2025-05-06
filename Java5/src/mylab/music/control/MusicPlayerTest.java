package mylab.music.control;

import mylab.music.entity.*;

/**
 * Sample Run 과 동일하게 동작하는 테스트 클래스
 */
public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("===== 음악 재생 시스템 테스트 =====\n");

        // --- MP3 테스트 ---
        System.out.println("--- MP3 테스트 ---");
        MP3 mp3 = new MP3("Dynamite", "BTS", 5);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(8);
        mp3.play();
        mp3.stop();
        System.out.println();

        // --- Vinyl 테스트 ---
        System.out.println("--- Vinyl 테스트 ---");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();
        System.out.println();

        // --- 다형성 테스트 ---
        System.out.println("--- 다형성 테스트 ---");
        MusicMedia media = new MP3("Butter", "BTS", 4);
        media.displayInfo();
        media.play();
        System.out.println();

        // --- 캐스팅 테스트 ---
        System.out.println("--- 캐스팅 테스트 ---");
        Playable player = (Playable) media;
        player.setVolume(3);
        media.play();
        player.setVolume(7);
        player.stop();
    }
}
