package ch.giuntini.netjlo_timed.packages;

import ch.giuntini.netjlo_base.packages.BasePackage;

import java.util.Date;

public class TimedPackage extends BasePackage {

    /**
     * the timestamp at which the package should be interpreted by the maschine the socket is connected to
     */
    public Date timeStamp;

    public TimedPackage(String information) {
        super(information);
    }
}