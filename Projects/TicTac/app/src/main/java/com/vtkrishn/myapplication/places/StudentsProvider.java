package com.vtkrishn.myapplication.places;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by vtkrishn on 1/20/2015.
 */
public class StudentsProvider extends ContentProvider{
    //provider , URL, content uri
    static final String PROVIDER_NAME="com.vtkrishn.provider.College"; // provider
    static final String URL = "content://" + PROVIDER_NAME + "/courses"; // table
    public static final Uri CONTENT_URI = Uri.parse(URL);

    //table fields
    public static final String ID="_id";
    public static final String NAME="name";
    public  static final String POINTS="point";

    //table constant for uri accessing
    static final int COURSE = 1;
    static final int COURSE_ID = 2;

    //Uri Matcher intialization
    static final  UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"courses",COURSE);
        uriMatcher.addURI(PROVIDER_NAME,"courses/#",COURSE_ID);
    }

    private static HashMap<String, String> COURSE_PROJECTION_MAP;

    //db and helper
    private SQLiteDatabase database;
    static final String DATABASE_NAME="College";
    static final String TABLE_NAME="courses";
    static final int DATABASE_VERSION=1;
    static final String CREATE_DB_TABLE=
            " CREATE TABLE " + TABLE_NAME +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " name TEXT NOT NULL, " +
            " point TEXT NOT NULL);";

    /**
     * DB Helper class
     */
    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME);
            onCreate(db);
        }
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        if(database == null)
            return false;
        else
            return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case COURSE:
                qb.setProjectionMap(COURSE_PROJECTION_MAP);
                break;
            case COURSE_ID:
                qb.appendWhere( ID + "=" + uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (sortOrder == null || sortOrder == ""){
            /**
             * By default sort on student names
             */
            sortOrder = NAME;
        }
        Cursor c = qb.query(database,	projection,	selection, selectionArgs,
                null, null, sortOrder);
        /**
         * register to watch a content URI for changes
         */
        c.setNotificationUri(getContext().getContentResolver(), uri);

        return c;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case COURSE:
                return "vnd.android.cursor.dir/vnd.vtkrishn.courses";
            case COURSE_ID:
                return "vnd.android.cursor.item/vnd.vtkrishn.courses";
        }
        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowId = database.insert(TABLE_NAME,"", values);
        if(rowId > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI,rowId);
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        try {
            throw new SQLException("failed to add a record into "+ uri);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case COURSE:
                count = database.delete(TABLE_NAME, selection, selectionArgs);
                break;
            case COURSE_ID:
                String id = uri.getPathSegments().get(1);
                count = database.delete( TABLE_NAME, ID +  " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case COURSE:
                count = database.update(TABLE_NAME, values,
                        selection, selectionArgs);
                break;
            case COURSE_ID:
                count = database.update(TABLE_NAME, values, ID +
                        " = " + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri );
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
