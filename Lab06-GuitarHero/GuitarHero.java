 

import java.util.*;
public class GuitarHero{ 

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C

        double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        HashMap<Character, GuitarString> notes = new HashMap<>();
        String letters = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        for(int i = 0; i < letters.length(); ++i)
            notes.put(letters.charAt(i), new GuitarString(CONCERT_A * Math.pow(2, (i - 24.0) / 12)));
        RingBuffer buffer = new RingBuffer(1);
        StdDraw.enableDoubleBuffering();
        while (true) {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                // the user types this character
                
                char key = StdDraw.nextKeyTyped();
                if(notes.containsKey(key)) {
                    notes.get(key).pluck();
                }
            }

            // compute the superposition of the samples
            double sample = 0;
            for(Map.Entry<Character, GuitarString> e : notes.entrySet())
                sample += e.getValue().sample();

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(Map.Entry<Character, GuitarString> e : notes.entrySet())
               e.getValue().tic();

        }
    }
}

    

