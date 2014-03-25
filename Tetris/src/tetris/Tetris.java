package tetris;

public class Tetris {

    final Board b;// =new Board();
    final Shape shape;// = b.shape;

    public Tetris() {
        b = new Board();
        shape = b.shape;
    }

    public static void main(String[] args) {
        //SoundEffect se = new SoundEffect("row.wav");
        //SoundEffects.init();
         new Thread(new Runnable() {
            
            @Override
            public void run() {
            SoundEffect se = new SoundEffect("row.wav");//row.wav");//.TICK.play(true);
            se.play(true);
            }
        }).start();
        
        Tetris t = new Tetris();
        
    }
}
