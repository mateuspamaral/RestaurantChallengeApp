package br.com.digitalhouse.restaurantchallengeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Restaurant implements Parcelable {

    private String name;
    private String address;
    private String open;
    private String close;
    private int image;
    private List<Dish> dishList;

    public Restaurant() {
    }

    public Restaurant(String name, String address, String open, String close, int image, List<Dish> dishList) {
        this.name = name;
        this.address = address;
        this.open = open;
        this.close = close;
        this.image = image;
        this.dishList = dishList;
    }

    protected Restaurant(Parcel in) {
        name = in.readString();
        address = in.readString();
        open = in.readString();
        close = in.readString();
        image = in.readInt();
        dishList = in.createTypedArrayList(Dish.CREATOR);
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(open);
        dest.writeString(close);
        dest.writeInt(image);
        dest.writeTypedList(dishList);
    }
}
