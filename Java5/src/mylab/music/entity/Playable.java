package mylab.music.entity;

/**
 * 재생 제어 기능을 정의하는 인터페이스
 */
public interface Playable {
    void setVolume(int level);
    void stop();
}
