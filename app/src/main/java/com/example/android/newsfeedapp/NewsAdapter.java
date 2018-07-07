package com.example.android.newsfeedapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * The part of the location string from the News service that we use to determine
     * whether or not there is a location offset present ("5km N of Cairo, Egypt").

     private static final String LOCATION_SEPARATOR = " of ";
     */
    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the News at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        // Find the TextView with view Author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        // Display the author of the current news in that TextView
        authorView.setText(currentNews.getAuthor());

        // Find the TextView with view ID location offset
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        // Display the location offset of the current earthquake in that TextView
        sectionView.setText(currentNews.getSection());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // gets the Date and time of the news from the currentNews object and stores it in the variable date
        String dateAndTime = currentNews.getDate();

        // creates a new SimpleDateFormat object with the ISODateFormat that is uses in the Guardian API and stores
        // in the variable dateTimeFormat
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

        // creates a new SimpleDateFormat object with the format of the year that it should be shown and stores
        // in the variable dateFormat
        DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy, h:mm a");
        // creates a new SimpleDateFormat object with the format of the time that it should be shown and stores

        try {

            // the dateTimeFormat from the currentNews object gets parsed and stored in the variable dateAndTimeParsed
            Date dateAndTimeParsed = dateTimeFormat.parse(dateAndTime);
            // the dateFormat becomes formatted
            String dateString = dateFormat.format(dateAndTimeParsed);
            // the timeFormat becomes formatted
            //sets the date from the current news in the dateTextView with the right format
            dateView.setText(dateString);

        } catch (ParseException e) {

        }

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


    //This will check if the author is available and set it.
    //If it is not, then take out the whole author TextView from the list_item
    private void processAuthorTextView(TextView authorTextView, String author) {
        if (author == null) {
            authorTextView.setVisibility(View.GONE);
        } else {
            authorTextView.setVisibility(View.VISIBLE);
            authorTextView.setText(author);
        }
    }


 }

/*Source
https://stackoverflow.com/questions/4772425/change-date-format-in-a-java-string
https://stackoverflow.com/questions/49752149/how-do-i-convert-2018-04-10t040000-000z-string-to-datetime
and slack-people
*/