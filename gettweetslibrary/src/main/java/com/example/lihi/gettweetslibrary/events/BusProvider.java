package com.example.lihi.gettweetslibrary.events;

import com.squareup.otto.Bus;

/**
 * Created by lihi sharkanski
 */

public class BusProvider {
    private static Bus mInstance = null;

    private BusProvider() {

    }

    public static Bus getInstance() {
        if (mInstance == null) {
            mInstance = new Bus();
        }
        return mInstance;
    }
}
