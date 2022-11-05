package Structural;
//        Step 1
//        Create interfaces for Media Player and Advanced Media Player.
//        MediaPlayer.java

interface MediaPlayer {
    public void play(String audioType, String fileName);
}


interface AdvancedMediaPlayer {
    public void playVlc(String fileName);

    public void playMp4(String fileName);
}
//        Step 2
//        Create concrete classes implementing the AdvancedMediaPlayer interface.
//        VlcPlayer.java

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //do nothing
    }
}

class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

//        Step 3
//        Create adapter class implementing the MediaPlayer interface.
//        MediaAdapter.java

class MediaAdapter implements MediaPlayer {


    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {


        switch (audioType) {
            case "vlc" -> advancedMusicPlayer = new VlcPlayer();
            case "mp4" -> advancedMusicPlayer = new Mp4Player();
            default -> {
            }
        }


    }

    @Override
    public void play(String audioType, String fileName) {

        switch (audioType) {
            case "vlc" -> advancedMusicPlayer.playVlc(fileName);
            case "mp4" -> advancedMusicPlayer.playMp4(fileName);
            default -> {
            }

        }


    }
}
//        Step 4
//        Create concrete class implementing the MediaPlayer interface.
//        AudioPlayer.java

class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {


        switch (audioType) {

            //inbuilt support to play mp3 music files
            case "mp3" -> System.out.println("Playing " + audioType + " file. Name: " + fileName);
            //mediaAdapter is providing support to play other file formats
            case "vlc", "mp4" -> {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            }
            default -> System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

//        Step 5
//        Use the AudioPlayer to play different types of audio formats.
//        AdapterPatternDemo.java

class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
//        Step 6
//        Verify the output.
//        Playing mp3 file. Name: beyond the horizon.mp3
//        Playing mp4 file. Name: alone.mp4
//        Playing vlc file. Name: far, far away.vlc
//        Invalid media. avi format not supported