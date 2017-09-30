package space.archy.solohttpsdemo.netWork.bean;

import java.io.Serializable;

/**
 * @Author Archy Wang
 * @Date 2017/8/8
 * @Description
 */

public class AdvertisementBean implements Serializable {
    private boolean locker_default;
    private boolean show_locker;
    private int splash;
    private boolean show_startpagead;
    private int category_interstitial;

    public boolean isLocker_default() {
        return locker_default;
    }

    public void setLocker_default(boolean locker_default) {
        this.locker_default = locker_default;
    }

    public boolean isShow_locker() {
        return show_locker;
    }

    public void setShow_locker(boolean show_locker) {
        this.show_locker = show_locker;
    }

    public int getSplash() {
        return splash;
    }

    public void setSplash(int splash) {
        this.splash = splash;
    }

    public boolean isShow_startpagead() {
        return show_startpagead;
    }

    public void setShow_startpagead(boolean show_startpagead) {
        this.show_startpagead = show_startpagead;
    }

    public int getCategory_interstitial() {
        return category_interstitial;
    }

    public void setCategory_interstitial(int category_interstitial) {
        this.category_interstitial = category_interstitial;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "locker_default=" + locker_default +
                ", show_locker=" + show_locker +
                ", splash=" + splash +
                ", show_startpagead=" + show_startpagead +
                ", category_interstitial=" + category_interstitial +
                '}';
    }

}
