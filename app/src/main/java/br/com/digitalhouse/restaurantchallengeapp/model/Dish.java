package br.com.digitalhouse.restaurantchallengeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dish implements Parcelable {
    private String name;
    private String description;
    private int image;

    public Dish() {
    }

    public Dish(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    protected Dish(Parcel in) {
        name = in.readString();
        description = in.readString();
        image = in.readInt();
    }

    public static final Creator<Dish> CREATOR = new Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(image);
    }
}