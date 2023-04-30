package ch.giuntini.netjlo_timed.sockets;

import ch.giuntini.netjlo_base.socket.Send;
import ch.giuntini.netjlo_timed.packages.TimedPackage;

import java.util.Date;

public interface TimedSend<P extends TimedPackage> extends Send<P> {

    default void send(P pack, int delay) {
        // TODO set proper Exception message
        throw new UnsupportedOperationException("");
    }

    default void send(P pack, Date timestamp) {
        // TODO set proper Exception message
        throw new UnsupportedOperationException("");
    }

    default void sendAll(P p, int delay) {
        // TODO set proper Exception message
        throw new UnsupportedOperationException("");
    }

    default void sendAll(P p, Date timestamp) {
        // TODO set proper Exception message
        throw new UnsupportedOperationException("");
    }
}
