class SmartPhone extends Phone implements Camera, MusicPlayer {
    public void click() {
        System.out.println("Clicking photo...");
    }

    public void record() {
        System.out.println("Recording video...");
    }

    public void play() {
        System.out.println("Playing music...");
    }

    public void stop() {
        System.out.println("Stopping music...");
    }
}

