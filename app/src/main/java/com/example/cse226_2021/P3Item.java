package com.example.cse226_2021;

public class P3Item
{
    String placeName;
    int placeImage;

public P3Item (String placeName , int placeImage)
{
this.placeImage = placeImage;
this.placeName = placeName;
}

    public String getPlaceName()
    {
        return placeName;
    }
    public int getPlaceImage()
    {
        return placeImage;
    }
}