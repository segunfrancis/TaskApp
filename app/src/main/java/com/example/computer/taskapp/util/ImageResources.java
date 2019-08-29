package com.example.computer.taskapp.util;

import android.net.Uri;

import com.example.computer.taskapp.R;

public class ImageResources {
    public static final String personalImage = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.personal_icon).toString();
    public static final String familyImage = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.family_icon).toString();
    public static final String entertainmentImage = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.party_icon).toString();
    public static final String educationImage = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.education_icon).toString();
    public static final String sportImage = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.sport_icon).toString();
    public static final String religionImage = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.religion_icon).toString();
    public static final String otherImage = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.other_icon).toString();

    public static final String moreIcon = Uri.parse("android.resource://com.example.computer.taskapp/" + R.drawable.ic_more_horiz).toString();
}
