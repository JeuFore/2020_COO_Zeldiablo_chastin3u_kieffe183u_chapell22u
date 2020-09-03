package code.moteurJeu;

import java.util.ArrayList;

public class FrameListenerUpdater {

    private static ArrayList<FrameListener> listeners = new ArrayList<FrameListener>();

    public static void addListener(FrameListener toAdd) {
        listeners.add(toAdd);
    }

    public static void call() {
        for (FrameListener hl : listeners)
            hl.frameUpdate();
    }
    
}
