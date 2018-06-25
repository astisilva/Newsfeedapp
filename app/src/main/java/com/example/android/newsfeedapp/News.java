/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.newsfeedapp;

/**
 * An {@link News} object contains information about a News.
 */



public class News {


    /** Title of the news */
    private String mTitle;

    /** The writer of the news */
    private String mAuthor;

    /** Date when the news is written */
    private String mDate;

    /** Thw News section */
    private String mSection;


    /** Website URL of the news */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *  @param title is the title of the news
     * @param author the author of the news
     * @param date is the date of the news
     * @param section section of the news
     * @param url is the website URL to find more details about the news
     */
    public News(String title, String author, String date, String section, String url) {
        mTitle = title;
        mAuthor = author;
        mDate = date;
        mSection = section;
        mUrl = url;

    }
    /**
     * Returns the title.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the author.
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     * Returns the date.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the section.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the website URL to find more information about News.
     */
    public String getUrl() { return mUrl; }

}
