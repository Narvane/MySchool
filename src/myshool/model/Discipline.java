package myshool.model;


public class Discipline {
    private Average media;

    public Discipline() {
    }

    public Discipline(Average media) {
        this.media = media;
    }

    public Average getMedia() {
        return media;
    }

    public void setMedia(Average media) {
        this.media = media;
    }
    
}
