package com.example.lightupapp2;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    private static final String TAG = "Model";

    String name, schoolname, title, email;

    public Model(){}

    public Model(String name, String schoolname, String title, String email){
        this.name = name;
        this.email= email;
        this.schoolname = schoolname;
        this.title = title;


    }

    public Model(Parcel parcel){
        name = parcel.readString();
        email = parcel.readString();
        schoolname = parcel.readString();
        title = parcel.readString();


    }
    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(schoolname);
        parcel.writeString(name);
        parcel.writeString(title);
        parcel.writeString(email);

    }
    @Override
    public String toString() {
        return "Model{" +
                "schoolname='" + schoolname + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
